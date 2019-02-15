package com.wxm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.google.common.base.Objects;
import com.wxm.constants.CommonStatus;
import com.wxm.rocksdb.RocksDBService;
import com.wxm.rocksdb.RocksdbActionGrpc.RocksdbActionImplBase;
import com.wxm.rocksdb.RocksdbActionKVSReply;
import com.wxm.rocksdb.RocksdbActionReply;
import com.wxm.rocksdb.RocksdbRequest;
import com.wxm.rocksdb.RocksdbRequests;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcServerService extends RocksdbActionImplBase {

    @Resource
    private RocksDBService rocksdbService;

    @Override
    public void saveKV(RocksdbRequest req, StreamObserver<RocksdbActionReply> responseObserver) {
        String table = req.getTable();
        String key = req.getKey();
        String value = req.getValue();

        int result = rocksdbService.put(table, key, value);
        CommonStatus code = CommonStatus.FAIL;
        if (result > 0) {
            code = CommonStatus.SUCCESS;
        }

        RocksdbActionReply reply = RocksdbActionReply.newBuilder().setCode(code.getValue()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void saveKVS(RocksdbRequests req, StreamObserver<RocksdbActionReply> responseObserver) {
        String table = req.getTable();
        List<String> keys = req.getKeysList();
        List<String> values = req.getValuesList();

        CommonStatus code = CommonStatus.FAIL;
        if (StringUtils.isEmpty(table) || CollectionUtils.isEmpty(keys)
                || CollectionUtils.isEmpty(values) || !Objects.equal(keys.size(), values.size())) {
            code = CommonStatus.PARAM_ERROR;
        }
        Map<String, String> kvs = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            kvs.put(keys.get(i), values.get(i));
        }
        int result = rocksdbService.batchSave(table, kvs);
        if (result > 0) {
            code = CommonStatus.SUCCESS;
        }

        RocksdbActionReply reply = RocksdbActionReply.newBuilder().setCode(code.getValue()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteKey(RocksdbRequest req, StreamObserver<RocksdbActionReply> responseObserver) {
        String table = req.getTable();
        String key = req.getKey();

        int result = rocksdbService.delete(table, key);
        CommonStatus code = CommonStatus.FAIL;
        if (result > 0) {
            code = CommonStatus.SUCCESS;
        }

        RocksdbActionReply reply = RocksdbActionReply.newBuilder().setCode(code.getValue()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();

    }

    @Override
    public void deleteKeys(RocksdbRequests req,
            StreamObserver<RocksdbActionReply> responseObserver) {
        String table = req.getTable();
        List<String> keys = req.getKeysList();

        int result = rocksdbService.deleteKeys(table, keys);
        CommonStatus code = CommonStatus.FAIL;
        if (result > 0) {
            code = CommonStatus.SUCCESS;
        }

        RocksdbActionReply reply = RocksdbActionReply.newBuilder().setCode(code.getValue()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();

    }

    @Override
    public void getValue(RocksdbRequest req, StreamObserver<RocksdbActionReply> responseObserver) {
        String table = req.getTable();
        String key = req.getKey();

        String value = rocksdbService.get(table, key);
        CommonStatus code = CommonStatus.SUCCESS;

        RocksdbActionReply reply =
                RocksdbActionReply.newBuilder().setCode(code.getValue()).setData(value).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();

    }

    @Override
    public void getValues(RocksdbRequests req,
            StreamObserver<RocksdbActionKVSReply> responseObserver) {
        String table = req.getTable();
        List<String> keys = req.getKeysList();

        Map<String, String> result = rocksdbService.multiGet(table, keys);
        CommonStatus code = CommonStatus.SUCCESS;

        RocksdbActionKVSReply reply = RocksdbActionKVSReply.newBuilder().setCode(code.getValue())
                .putAllKvs(result).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
