package com.wxm.rocksdb;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.rocksdb.ColumnFamilyDescriptor;
import org.rocksdb.ColumnFamilyHandle;
import org.rocksdb.ColumnFamilyOptions;
import org.rocksdb.RocksDBException;
import org.rocksdb.RocksIterator;
import org.rocksdb.WriteBatch;
import org.rocksdb.WriteOptions;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.wxm.log.CommonLogger;

@Service
public class RocksDBService {
    private static final Object lockObject = new Object();
    private static ColumnFamilyHandle getColumn(String table) throws RocksDBException {
        ColumnFamilyHandle cfh = RocksSourceService.getColumnFamily().get(table);
        if (cfh != null) {
            return cfh;
        }
        synchronized (lockObject) {
            // 获取锁之后，再check一次map中是否包含
            cfh = RocksSourceService.getColumnFamily().get(table);
            if (cfh != null) {
                return cfh;
            }
            cfh = RocksSourceService.getRocksDB().createColumnFamily(
                    new ColumnFamilyDescriptor(table.getBytes(StandardCharsets.UTF_8), new ColumnFamilyOptions()));
            RocksSourceService.getColumnFamily().put(table, cfh);
        }
        
        return cfh;
    }

    public int put(String table, String key, String value) {
        try {
            RocksSourceService.getRocksDB().put(getColumn(table), key.getBytes(StandardCharsets.UTF_8), value.getBytes(StandardCharsets.UTF_8));
            return 1;
        } catch (Exception ex) {
            CommonLogger.error("【rocksdb write】error", ex);
            return 0;
        }
    }

    public boolean keyMayExist(String table, String key) {
        try {
            return RocksSourceService.getRocksDB().keyMayExist(getColumn(table), key.getBytes(StandardCharsets.UTF_8), new StringBuilder());
        } catch (Exception ex) {
            CommonLogger.error("【rocksdb keyMayExist】error", ex);
        }
        return false;
    }

    public String get(String table, String key) {
        try {
            byte[] result = RocksSourceService.getRocksDB().get(getColumn(table), key.getBytes(StandardCharsets.UTF_8));
            if (result == null) {
                return StringUtils.EMPTY;
            }
            return new String(result);
        } catch (Exception ex) {
            CommonLogger.error("【rocksdb get】error", ex);
        }
        return StringUtils.EMPTY;
    }
    
    public Map<String,String> multiGet(String table, List<String> keys) {
        List<ColumnFamilyHandle> columns = new ArrayList<>();
        List<byte[]> keyBytes = new ArrayList<>();
        Map<String,String> result = new HashMap<>();
        try {
            for(String key : keys){
                keyBytes.add(key.getBytes(StandardCharsets.UTF_8));
                columns.add(getColumn(table));
            }
            Map<byte[], byte[]> map = RocksSourceService.getRocksDB().multiGet(columns, keyBytes);
            if (CollectionUtils.isEmpty(map)) {
                return Collections.emptyMap();
            }
            for(Entry<byte[], byte[]> entry : map.entrySet()){
                result.put(new String(entry.getKey()), new String(entry.getValue()));
            }
        } catch (Exception ex) {
            CommonLogger.error("【rocksdb multiGet】error", ex);
        }
        return result;
    }

    public int delete(String table, String key) {
        try {
            RocksSourceService.getRocksDB().delete(getColumn(table), key.getBytes(StandardCharsets.UTF_8));
            return 1;
        } catch (Exception ex) {
            CommonLogger.error("【rocksdb delete】error", ex);
            return 0;
        }
    }

    public int batchSave(String table, Map<String, String> kvs) {
        if (CollectionUtils.isEmpty(kvs)) {
            return 0;
        }
        WriteBatch writeBatch = new WriteBatch();
        try {
            for (Entry<String, String> kv : kvs.entrySet()) {
                writeBatch.put(getColumn(table), kv.getKey().getBytes(StandardCharsets.UTF_8), kv.getValue().getBytes(StandardCharsets.UTF_8));
            }
            RocksSourceService.getRocksDB().write(new WriteOptions(), writeBatch);
            return 1;
        } catch (Exception ex) {
            CommonLogger.error("【rocksdb batch save】error", ex);
            return 0;
        } finally {
            writeBatch.close();
        }
    }

    public int deleteKeys(String table, List<String> keys) {
        if (CollectionUtils.isEmpty(keys)) {
            return 0;
        }
        WriteBatch writeBatch = new WriteBatch();
        try {
            for (String key : keys) {
                writeBatch.delete(getColumn(table), key.getBytes(StandardCharsets.UTF_8));
            }
            RocksSourceService.getRocksDB().write(new WriteOptions(), writeBatch);
            return 1;
        } catch (Exception ex) {
            CommonLogger.error("【rocksdb batch delete】error", ex);
            return 0;
        } finally {
            writeBatch.close();
        }
    }

    public RocksIterator getRocksIterator(String table) {
        try {
            return RocksSourceService.getRocksDB().newIterator(getColumn(table));
        } catch (Exception ex) {
            CommonLogger.error("【rocksdb get】error", ex);
        }
        return null;
    }
    
    public long getTableCount(String table){
        long count = 0;
        RocksIterator iterator = null;
        try {
            iterator = RocksSourceService.getRocksDB().newIterator(getColumn(table));
            if (iterator != null) {
                for (iterator.seekToFirst(); iterator.isValid(); iterator.next()) {
                    count++;
                }
            }
        } catch (Exception ex) {
            CommonLogger.error("【rocksdb table count】 error：", ex);
        } finally{
            if(iterator != null){
                iterator.close();
            }
        }
        return count;
    }
    
    public Map<String,String> getTableKVs(String table,int numbers){
        long count = 0;
        RocksIterator iterator = null;
        Map<String,String> result = new HashMap<>();
        try {
            iterator = RocksSourceService.getRocksDB().newIterator(getColumn(table));
            if (iterator != null) {
                for (iterator.seekToFirst(); iterator.isValid(); iterator.next()) {
                    if(count++ >= numbers){
                        break;
                    }
                    String key = new String(iterator.key());
                    String value = new String(iterator.value());
                    result.put(key, value);
                }
            }
        } catch (Exception ex) {
            CommonLogger.error("【rocksdb table count】 error：", ex);
        } finally{
            if(iterator != null){
                iterator.close();
            }
        }
        return result;
    }
    
    public Set<String> getTables(){
        Map<String, ColumnFamilyHandle> columns = RocksSourceService.getColumnFamily();
        if(CollectionUtils.isEmpty(columns)){
            return Collections.emptySet();
        }
        return columns.keySet();
    }

}
