package com.wxm.grpc;

import org.springframework.stereotype.Service;

import com.wxm.rocksdb.RocksdbActionGrpc.RocksdbActionBlockingStub;
import com.wxm.rocksdb.RocksdbActionReply;
import com.wxm.rocksdb.RocksdbRequest;

import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class GrpcClientService {

    // @GrpcClient("local-grpc-server")
    // private SimpleBlockingStub simpleStub;

    @GrpcClient("local-grpc-server")
    private RocksdbActionBlockingStub rocksdbActionBlockingStub;

    public String saveKV(String table, String key, String value) {
        try {
            RocksdbActionReply reply = rocksdbActionBlockingStub.saveKV(RocksdbRequest.newBuilder()
                    .setTable(table).setKey(key).setValue(value).build());
            return String.valueOf(reply.getCode());
        } catch (StatusRuntimeException ex) {
            return "-1";
        }
    }
    
    public String getV(String table, String key) {
        try {
            RocksdbActionReply reply = rocksdbActionBlockingStub.getValue(RocksdbRequest.newBuilder()
                    .setTable(table).setKey(key).build());
            return reply.getData();
        } catch (StatusRuntimeException ex) {
            return "-1";
        }
    }
}
