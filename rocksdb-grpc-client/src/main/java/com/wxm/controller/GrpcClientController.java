package com.wxm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wxm.grpc.GrpcClientService;

@RestController
@RequestMapping("/rocksdb")
public class GrpcClientController {

    @Autowired
    private GrpcClientService grpcClientService;

    @PostMapping("/kv")
    public String saveKV(
            @RequestParam(name="table") String table,
            @RequestParam(name="k") String k,
            @RequestParam(name="v") String v) {
        return grpcClientService.saveKV(table, k, v);
    }

    @GetMapping("/k")
    public String getK(
            @RequestParam(name="table") String table,
            @RequestParam(name="k") String k) {
        return grpcClientService.getV(table, k);
    }
}
