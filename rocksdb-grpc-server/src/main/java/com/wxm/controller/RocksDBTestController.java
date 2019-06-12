package com.wxm.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Splitter;
import com.wxm.constants.CommonStatus;
import com.wxm.constants.ResultJson;
import com.wxm.rocksdb.RocksDBService;

@RestController
@RequestMapping("/rocksdb/test")
public class RocksDBTestController {

    @Resource
    private RocksDBService rocksdbService;

    @PostMapping("/kv")
    public ResultJson saveKV(@RequestParam(value = "table") String table,
            @RequestParam(value = "key") String key) {
        if (StringUtils.isEmpty(table) || StringUtils.isEmpty(key)) {
            return new ResultJson(CommonStatus.PARAM_ERROR);
        }
        long btime = System.currentTimeMillis();
        String v =
                "\"c1ccccc1\",\"c1nc(-c2cnn(CC3CCCC3)c2)c2cc[nH]c2n1\",\"c1ccc(Cc2ccccc2)cc1\",\"c1ccc(-c2ccccc2)cc1\",\"Cc1ccccc1\",\"NCCc1ccc(O)c(O)c1\",\"Cc1cccc(C)c1\",\"CCCc1cccc(CCC)c1\",\"c1ccc(-c2cc[nH]c2)cc1\",\"Cc1ccc(-c2ccccc2)cc1\"";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 1000; i++) {
            sb.append(v).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        int result = rocksdbService.put(table, key, sb.toString());

        long etime = System.currentTimeMillis();
        if (result > 0) {
            return new ResultJson(CommonStatus.SUCCESS, (etime - btime) + "ms");
        }
        return new ResultJson(CommonStatus.FAIL);
    }


    @GetMapping("/kv")
    public ResultJson getValue(@RequestParam(value = "table") String table,
            @RequestParam(value = "key") String key) {
        if (StringUtils.isEmpty(table) || StringUtils.isEmpty(key)) {
            return new ResultJson(CommonStatus.PARAM_ERROR);
        }
        long btime = System.currentTimeMillis();
        String result = rocksdbService.get(table, key);
        long etime = System.currentTimeMillis();
        System.out.println((etime - btime) + "ms");
        return new ResultJson(CommonStatus.SUCCESS, result);
    }

    @GetMapping("/kvs")
    public ResultJson getValues(@RequestParam(value = "table") String table,
            @RequestParam(value = "keys") String keys) {
        if (StringUtils.isEmpty(table) || StringUtils.isEmpty(keys)) {
            return new ResultJson(CommonStatus.PARAM_ERROR);
        }
        long btime = System.currentTimeMillis();
        List<String> keyList = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(keys);
        Map<String, String> result = rocksdbService.multiGet(table, keyList);
        long etime = System.currentTimeMillis();
        System.out.println((etime - btime) + "ms");
        return new ResultJson(CommonStatus.SUCCESS, result);
    }

    @GetMapping("/tables")
    public ResultJson getTables() {
        Set<String> tables = rocksdbService.getTables();
        return new ResultJson(CommonStatus.SUCCESS, tables);
    }
}

