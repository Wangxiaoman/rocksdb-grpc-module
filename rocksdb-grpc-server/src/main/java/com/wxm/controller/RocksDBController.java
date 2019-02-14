package com.wxm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.wxm.constants.CommonStatus;
import com.wxm.constants.ResultJson;
import com.wxm.rocksdb.RocksDBService;

@RestController
@RequestMapping("/rocksdb")
public class RocksDBController {

    @Resource
    private RocksDBService rocksdbService;

    @PostMapping("/kv")
    public ResultJson saveKV(@RequestParam(value="table")String table, 
            @RequestParam(value="key")String key, 
            @RequestParam(value="value")String value) {
        if (StringUtils.isEmpty(table) || StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            return new ResultJson(CommonStatus.PARAM_ERROR);
        }
        int result = rocksdbService.put(table, key, value);
        if (result > 0) {
            return new ResultJson(CommonStatus.SUCCESS);
        }
        return new ResultJson(CommonStatus.FAIL);
    }

    @PostMapping("/kvs")
    public ResultJson saveKVS(@RequestParam(value="table")String table, 
            @RequestParam(value="keys")List<String> keys, 
            @RequestParam(value="values")List<String> values) {
        if (StringUtils.isEmpty(table) || CollectionUtils.isEmpty(keys)
                || CollectionUtils.isEmpty(values) || !Objects.equal(keys.size(), values.size())) {
            return new ResultJson(CommonStatus.PARAM_ERROR);
        }
        Map<String, String> kvs = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            kvs.put(keys.get(i), values.get(i));
        }
        int result = rocksdbService.batchSave(table, kvs);
        if (result > 0) {
            return new ResultJson(CommonStatus.SUCCESS);
        }
        return new ResultJson(CommonStatus.FAIL);
    }

    @PostMapping("/k/del")
    public ResultJson deleteKey(@RequestParam(value="table")String table, @RequestParam(value="key")String key) {
        if (StringUtils.isEmpty(table) || StringUtils.isEmpty(key)) {
            return new ResultJson(CommonStatus.PARAM_ERROR);
        }
        int result = rocksdbService.delete(table, key);
        if (result > 0) {
            return new ResultJson(CommonStatus.SUCCESS);
        }
        return new ResultJson(CommonStatus.FAIL);
    }

    @PostMapping("/ks/del")
    public ResultJson deleteKeys(@RequestParam(value="table")String table, @RequestParam(value="keys")List<String> keys) {
        if (StringUtils.isEmpty(table) || CollectionUtils.isEmpty(keys)) {
            return new ResultJson(CommonStatus.PARAM_ERROR);
        }
        int result = rocksdbService.deleteKeys(table, keys);
        if (result > 0) {
            return new ResultJson(CommonStatus.SUCCESS);
        }
        return new ResultJson(CommonStatus.FAIL);
    }

    @GetMapping("/kv")
    public ResultJson getValue(@RequestParam(value="table")String table, @RequestParam(value="key")String key) {
        if (StringUtils.isEmpty(table) || StringUtils.isEmpty(key)) {
            return new ResultJson(CommonStatus.PARAM_ERROR);
        }
        String value = rocksdbService.get(table, key);
        return new ResultJson(CommonStatus.SUCCESS, value);
    }

    @GetMapping("/kvs")
    public ResultJson getValues(@RequestParam(value="table")String table, @RequestParam(value="keys")String keys) {
        if (StringUtils.isEmpty(table) || StringUtils.isEmpty(keys)) {
            return new ResultJson(CommonStatus.PARAM_ERROR);
        }
        List<String> keyList = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(keys);
        Map<String, String> result = rocksdbService.multiGet(table, keyList);
        return new ResultJson(CommonStatus.SUCCESS, result);
    }

    @GetMapping("/count")
    public ResultJson countTable(@RequestParam(value="table")String table) {
        if (StringUtils.isEmpty(table)) {
            return new ResultJson(CommonStatus.PARAM_ERROR);
        }
        long count = rocksdbService.getTableCount(table);
        return new ResultJson(CommonStatus.SUCCESS, count);
    }
    
    @GetMapping("/hundred/kvs")
    public ResultJson tableContent(@RequestParam(value="table")String table) {
        if (StringUtils.isEmpty(table)) {
            return new ResultJson(CommonStatus.PARAM_ERROR);
        }
        Map<String,String> result = rocksdbService.getTableKVs(table,100);
        return new ResultJson(CommonStatus.SUCCESS, result);
    }

    @GetMapping("/tables")
    public ResultJson getTables() {
        Set<String> tables = rocksdbService.getTables();
        return new ResultJson(CommonStatus.SUCCESS, tables);
    }
}
