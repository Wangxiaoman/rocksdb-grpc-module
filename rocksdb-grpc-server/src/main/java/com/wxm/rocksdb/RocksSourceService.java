package com.wxm.rocksdb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.rocksdb.BlockBasedTableConfig;
import org.rocksdb.BloomFilter;
import org.rocksdb.ColumnFamilyDescriptor;
import org.rocksdb.ColumnFamilyHandle;
import org.rocksdb.ColumnFamilyOptions;
import org.rocksdb.CompactionStyle;
import org.rocksdb.DBOptions;
import org.rocksdb.Filter;
import org.rocksdb.HashLinkedListMemTableConfig;
import org.rocksdb.HashSkipListMemTableConfig;
import org.rocksdb.Options;
import org.rocksdb.PlainTableConfig;
import org.rocksdb.RateLimiter;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.rocksdb.SkipListMemTableConfig;
import org.rocksdb.Statistics;
import org.rocksdb.VectorMemTableConfig;
import org.rocksdb.util.SizeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.wxm.log.CommonLogger;


@Configuration
public class RocksSourceService {
    
    @Value("${rocksdb.path}")
    private String dbPath;
    @Value("${rocksdb.bg.flush.thread.cnt}")
    private int dbFlushCnt;
    @Value("${rocksdb.bg.compact.thread.cnt}")
    private int dbCompactCnt;
    @Value("${rocksdb.open.file.cnt}")
    private int dbOpenFileCnt;
    @Value("${rocksdb.max.total.wal.size}")
    private int dbMaxTotoalWal;
    
    private static RocksDB db = null;
    private static final List<ColumnFamilyHandle> columnFamilyHandles = new ArrayList<>();
    private static final Map<String, ColumnFamilyHandle> columnFamilyHandleMap = new ConcurrentHashMap<>();
    private static final List<ColumnFamilyDescriptor> columnFamilyDescriptors = new ArrayList<>();
    private static DBOptions dbOptions = null;
    
    @PostConstruct
    public void init(){
        load(dbPath, dbFlushCnt, dbCompactCnt, dbOpenFileCnt, dbMaxTotoalWal);
    }

    private void load(String dbPath,int dbFlushCnt,int dbCompactCnt,int dbOpenFileCnt,int dbMaxTotoalWal) {
        System.out.println("【rocksdb init beigin】dbPath:"+dbPath);
        CommonLogger.info("【rocksdb init beigin】dbPath:"+dbPath);
        long beginTime = System.currentTimeMillis();
        RocksDB.loadLibrary();
        try {
            Options options = getCommonOptions();
            List<byte[]> cfs = RocksDB.listColumnFamilies(options, dbPath);
            if (cfs.size() > 0) {
                for (byte[] cf : cfs) {
                    System.out.println("【rocksdb columns：】 column name - " + new String(cf));
                    CommonLogger.info("【rocksdb columns：】 column name - " + new String(cf));
                    columnFamilyDescriptors
                            .add(new ColumnFamilyDescriptor(cf, new ColumnFamilyOptions()));
                }
            } else {
                columnFamilyDescriptors.add(new ColumnFamilyDescriptor(
                        RocksDB.DEFAULT_COLUMN_FAMILY, new ColumnFamilyOptions()));
            }
            db = RocksDB.open(
                    getCommonDBOptions(dbFlushCnt, dbCompactCnt, dbOpenFileCnt, dbMaxTotoalWal),
                    dbPath, columnFamilyDescriptors, columnFamilyHandles);
            for (ColumnFamilyHandle c : columnFamilyHandles) {
                columnFamilyHandleMap.put(new String(c.getName()), c);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("【rocksdb init end】,cost time:"+(endTime-beginTime) +"ms");
            CommonLogger.info("【rocksdb init end】,cost time:"+(endTime-beginTime) +"ms");
        } catch (RocksDBException e) {
            System.out.println("【rocksdb init error】：" + e);
            CommonLogger.error("【rocksdb init error】", e);
        }
    }

    private synchronized static DBOptions getCommonDBOptions(int dbFlushCnt,int dbCompactCnt,int dbOpenFileCnt,int dbMaxTotoalWal) {
        if(dbOptions == null){
            dbOptions = createDBOptions(dbFlushCnt, dbCompactCnt, dbOpenFileCnt, dbMaxTotoalWal);
        }
        return dbOptions;
    }
    
    private static DBOptions createDBOptions(int dbFlushCnt,int dbCompactCnt,int dbOpenFileCnt,int dbMaxTotoalWal){
        DBOptions dbOptions = new DBOptions();
        final RateLimiter rateLimiter = new RateLimiter(10000000, 10000, 10);
        dbOptions.setCreateIfMissing(true);
        dbOptions.setCreateMissingColumnFamilies(true);
        dbOptions.setRateLimiter(rateLimiter);
        dbOptions.setMaxBackgroundFlushes(dbFlushCnt);// 设置10个线程
        dbOptions.setMaxBackgroundCompactions(dbCompactCnt);// 设置为10个线程
        dbOptions.setMaxOpenFiles(dbOpenFileCnt);// 最大文件句柄为400个
        dbOptions.setMaxTotalWalSize(dbMaxTotoalWal * SizeUnit.MB);
        
        
//        dbOptions.setMaxTotalWalSize(256 * SizeUnit.MB);
//        dbOptions.setMaxLogFileSize(16 * SizeUnit.MB);
//        dbOptions.setKeepLogFileNum(200);
//        dbOptions.setDbWriteBufferSize(2048 * SizeUnit.MB);
        return dbOptions;
    }

    private synchronized static Options getCommonOptions() {
        Options options = new Options();
        final Filter bloomFilter = new BloomFilter(10);
        final Statistics stats = new Statistics();
        final RateLimiter rateLimiter = new RateLimiter(10000000, 10000, 10);

        options.setCreateIfMissing(true).setCreateMissingColumnFamilies(true).setStatistics(stats)
                .setWriteBufferSize(8 * SizeUnit.KB).setMaxWriteBufferNumber(3)
                .setMaxBackgroundCompactions(10).setCompactionStyle(CompactionStyle.UNIVERSAL);

        options.setMemTableConfig(new HashSkipListMemTableConfig().setHeight(4)
                .setBranchingFactor(4).setBucketCount(2000000));

        options.setMemTableConfig(new HashLinkedListMemTableConfig().setBucketCount(100000));
        assert (options.memTableFactoryName().equals("HashLinkedListRepFactory"));

        options.setMemTableConfig(new VectorMemTableConfig().setReservedSize(10000));
        assert (options.memTableFactoryName().equals("VectorRepFactory"));

        options.setMemTableConfig(new SkipListMemTableConfig());
        assert (options.memTableFactoryName().equals("SkipListFactory"));

        options.setTableFormatConfig(new PlainTableConfig());
        options.setAllowMmapReads(true);
        options.setRateLimiter(rateLimiter);

        final BlockBasedTableConfig table_options = new BlockBasedTableConfig();
        table_options.setBlockCacheSize(64 * SizeUnit.KB).setFilter(bloomFilter)
                .setCacheNumShardBits(6).setBlockSizeDeviation(5).setBlockRestartInterval(10)
                .setCacheIndexAndFilterBlocks(true).setHashIndexAllowCollision(false)
                .setBlockCacheCompressedSize(64 * SizeUnit.KB)
                .setBlockCacheCompressedNumShardBits(10);

        options.setTableFormatConfig(table_options);
        return options;
    }

    public synchronized static RocksDB getRocksDB() {
        return db;
    }
    
    public synchronized static Map<String, ColumnFamilyHandle> getColumnFamily(){
        return columnFamilyHandleMap;
    }
}

