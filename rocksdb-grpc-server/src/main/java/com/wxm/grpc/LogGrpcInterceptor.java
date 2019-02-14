package com.wxm.grpc;

import com.wxm.log.CommonLogger;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;

public class LogGrpcInterceptor implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata,
            ServerCallHandler<ReqT, RespT> serverCallHandler) {
        CommonLogger.info(serverCall.getMethodDescriptor().getFullMethodName());
        return serverCallHandler.startCall(serverCall, metadata);
    }
}
