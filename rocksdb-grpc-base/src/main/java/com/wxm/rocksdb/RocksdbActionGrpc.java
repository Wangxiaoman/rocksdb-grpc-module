package com.wxm.rocksdb;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.18.0)",
    comments = "Source: rocksdb.proto")
public final class RocksdbActionGrpc {

  private RocksdbActionGrpc() {}

  public static final String SERVICE_NAME = "RocksdbAction";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequest,
      com.wxm.rocksdb.RocksdbActionReply> getSaveKVMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveKV",
      requestType = com.wxm.rocksdb.RocksdbRequest.class,
      responseType = com.wxm.rocksdb.RocksdbActionReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequest,
      com.wxm.rocksdb.RocksdbActionReply> getSaveKVMethod() {
    io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequest, com.wxm.rocksdb.RocksdbActionReply> getSaveKVMethod;
    if ((getSaveKVMethod = RocksdbActionGrpc.getSaveKVMethod) == null) {
      synchronized (RocksdbActionGrpc.class) {
        if ((getSaveKVMethod = RocksdbActionGrpc.getSaveKVMethod) == null) {
          RocksdbActionGrpc.getSaveKVMethod = getSaveKVMethod = 
              io.grpc.MethodDescriptor.<com.wxm.rocksdb.RocksdbRequest, com.wxm.rocksdb.RocksdbActionReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RocksdbAction", "saveKV"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wxm.rocksdb.RocksdbRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wxm.rocksdb.RocksdbActionReply.getDefaultInstance()))
                  .setSchemaDescriptor(new RocksdbActionMethodDescriptorSupplier("saveKV"))
                  .build();
          }
        }
     }
     return getSaveKVMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequests,
      com.wxm.rocksdb.RocksdbActionReply> getSaveKVSMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveKVS",
      requestType = com.wxm.rocksdb.RocksdbRequests.class,
      responseType = com.wxm.rocksdb.RocksdbActionReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequests,
      com.wxm.rocksdb.RocksdbActionReply> getSaveKVSMethod() {
    io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequests, com.wxm.rocksdb.RocksdbActionReply> getSaveKVSMethod;
    if ((getSaveKVSMethod = RocksdbActionGrpc.getSaveKVSMethod) == null) {
      synchronized (RocksdbActionGrpc.class) {
        if ((getSaveKVSMethod = RocksdbActionGrpc.getSaveKVSMethod) == null) {
          RocksdbActionGrpc.getSaveKVSMethod = getSaveKVSMethod = 
              io.grpc.MethodDescriptor.<com.wxm.rocksdb.RocksdbRequests, com.wxm.rocksdb.RocksdbActionReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RocksdbAction", "saveKVS"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wxm.rocksdb.RocksdbRequests.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wxm.rocksdb.RocksdbActionReply.getDefaultInstance()))
                  .setSchemaDescriptor(new RocksdbActionMethodDescriptorSupplier("saveKVS"))
                  .build();
          }
        }
     }
     return getSaveKVSMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequest,
      com.wxm.rocksdb.RocksdbActionReply> getDeleteKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteKey",
      requestType = com.wxm.rocksdb.RocksdbRequest.class,
      responseType = com.wxm.rocksdb.RocksdbActionReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequest,
      com.wxm.rocksdb.RocksdbActionReply> getDeleteKeyMethod() {
    io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequest, com.wxm.rocksdb.RocksdbActionReply> getDeleteKeyMethod;
    if ((getDeleteKeyMethod = RocksdbActionGrpc.getDeleteKeyMethod) == null) {
      synchronized (RocksdbActionGrpc.class) {
        if ((getDeleteKeyMethod = RocksdbActionGrpc.getDeleteKeyMethod) == null) {
          RocksdbActionGrpc.getDeleteKeyMethod = getDeleteKeyMethod = 
              io.grpc.MethodDescriptor.<com.wxm.rocksdb.RocksdbRequest, com.wxm.rocksdb.RocksdbActionReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RocksdbAction", "deleteKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wxm.rocksdb.RocksdbRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wxm.rocksdb.RocksdbActionReply.getDefaultInstance()))
                  .setSchemaDescriptor(new RocksdbActionMethodDescriptorSupplier("deleteKey"))
                  .build();
          }
        }
     }
     return getDeleteKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequests,
      com.wxm.rocksdb.RocksdbActionReply> getDeleteKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteKeys",
      requestType = com.wxm.rocksdb.RocksdbRequests.class,
      responseType = com.wxm.rocksdb.RocksdbActionReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequests,
      com.wxm.rocksdb.RocksdbActionReply> getDeleteKeysMethod() {
    io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequests, com.wxm.rocksdb.RocksdbActionReply> getDeleteKeysMethod;
    if ((getDeleteKeysMethod = RocksdbActionGrpc.getDeleteKeysMethod) == null) {
      synchronized (RocksdbActionGrpc.class) {
        if ((getDeleteKeysMethod = RocksdbActionGrpc.getDeleteKeysMethod) == null) {
          RocksdbActionGrpc.getDeleteKeysMethod = getDeleteKeysMethod = 
              io.grpc.MethodDescriptor.<com.wxm.rocksdb.RocksdbRequests, com.wxm.rocksdb.RocksdbActionReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RocksdbAction", "deleteKeys"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wxm.rocksdb.RocksdbRequests.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wxm.rocksdb.RocksdbActionReply.getDefaultInstance()))
                  .setSchemaDescriptor(new RocksdbActionMethodDescriptorSupplier("deleteKeys"))
                  .build();
          }
        }
     }
     return getDeleteKeysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequest,
      com.wxm.rocksdb.RocksdbActionReply> getGetValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getValue",
      requestType = com.wxm.rocksdb.RocksdbRequest.class,
      responseType = com.wxm.rocksdb.RocksdbActionReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequest,
      com.wxm.rocksdb.RocksdbActionReply> getGetValueMethod() {
    io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequest, com.wxm.rocksdb.RocksdbActionReply> getGetValueMethod;
    if ((getGetValueMethod = RocksdbActionGrpc.getGetValueMethod) == null) {
      synchronized (RocksdbActionGrpc.class) {
        if ((getGetValueMethod = RocksdbActionGrpc.getGetValueMethod) == null) {
          RocksdbActionGrpc.getGetValueMethod = getGetValueMethod = 
              io.grpc.MethodDescriptor.<com.wxm.rocksdb.RocksdbRequest, com.wxm.rocksdb.RocksdbActionReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RocksdbAction", "getValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wxm.rocksdb.RocksdbRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wxm.rocksdb.RocksdbActionReply.getDefaultInstance()))
                  .setSchemaDescriptor(new RocksdbActionMethodDescriptorSupplier("getValue"))
                  .build();
          }
        }
     }
     return getGetValueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequests,
      com.wxm.rocksdb.RocksdbActionKVSReply> getGetValuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getValues",
      requestType = com.wxm.rocksdb.RocksdbRequests.class,
      responseType = com.wxm.rocksdb.RocksdbActionKVSReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequests,
      com.wxm.rocksdb.RocksdbActionKVSReply> getGetValuesMethod() {
    io.grpc.MethodDescriptor<com.wxm.rocksdb.RocksdbRequests, com.wxm.rocksdb.RocksdbActionKVSReply> getGetValuesMethod;
    if ((getGetValuesMethod = RocksdbActionGrpc.getGetValuesMethod) == null) {
      synchronized (RocksdbActionGrpc.class) {
        if ((getGetValuesMethod = RocksdbActionGrpc.getGetValuesMethod) == null) {
          RocksdbActionGrpc.getGetValuesMethod = getGetValuesMethod = 
              io.grpc.MethodDescriptor.<com.wxm.rocksdb.RocksdbRequests, com.wxm.rocksdb.RocksdbActionKVSReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RocksdbAction", "getValues"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wxm.rocksdb.RocksdbRequests.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wxm.rocksdb.RocksdbActionKVSReply.getDefaultInstance()))
                  .setSchemaDescriptor(new RocksdbActionMethodDescriptorSupplier("getValues"))
                  .build();
          }
        }
     }
     return getGetValuesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RocksdbActionStub newStub(io.grpc.Channel channel) {
    return new RocksdbActionStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RocksdbActionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RocksdbActionBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RocksdbActionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RocksdbActionFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class RocksdbActionImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void saveKV(com.wxm.rocksdb.RocksdbRequest request,
        io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveKVMethod(), responseObserver);
    }

    /**
     */
    public void saveKVS(com.wxm.rocksdb.RocksdbRequests request,
        io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveKVSMethod(), responseObserver);
    }

    /**
     */
    public void deleteKey(com.wxm.rocksdb.RocksdbRequest request,
        io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionReply> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteKeyMethod(), responseObserver);
    }

    /**
     */
    public void deleteKeys(com.wxm.rocksdb.RocksdbRequests request,
        io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionReply> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteKeysMethod(), responseObserver);
    }

    /**
     */
    public void getValue(com.wxm.rocksdb.RocksdbRequest request,
        io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetValueMethod(), responseObserver);
    }

    /**
     */
    public void getValues(com.wxm.rocksdb.RocksdbRequests request,
        io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionKVSReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetValuesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSaveKVMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.wxm.rocksdb.RocksdbRequest,
                com.wxm.rocksdb.RocksdbActionReply>(
                  this, METHODID_SAVE_KV)))
          .addMethod(
            getSaveKVSMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.wxm.rocksdb.RocksdbRequests,
                com.wxm.rocksdb.RocksdbActionReply>(
                  this, METHODID_SAVE_KVS)))
          .addMethod(
            getDeleteKeyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.wxm.rocksdb.RocksdbRequest,
                com.wxm.rocksdb.RocksdbActionReply>(
                  this, METHODID_DELETE_KEY)))
          .addMethod(
            getDeleteKeysMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.wxm.rocksdb.RocksdbRequests,
                com.wxm.rocksdb.RocksdbActionReply>(
                  this, METHODID_DELETE_KEYS)))
          .addMethod(
            getGetValueMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.wxm.rocksdb.RocksdbRequest,
                com.wxm.rocksdb.RocksdbActionReply>(
                  this, METHODID_GET_VALUE)))
          .addMethod(
            getGetValuesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.wxm.rocksdb.RocksdbRequests,
                com.wxm.rocksdb.RocksdbActionKVSReply>(
                  this, METHODID_GET_VALUES)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class RocksdbActionStub extends io.grpc.stub.AbstractStub<RocksdbActionStub> {
    private RocksdbActionStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RocksdbActionStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RocksdbActionStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RocksdbActionStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void saveKV(com.wxm.rocksdb.RocksdbRequest request,
        io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveKVMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void saveKVS(com.wxm.rocksdb.RocksdbRequests request,
        io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveKVSMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteKey(com.wxm.rocksdb.RocksdbRequest request,
        io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteKeys(com.wxm.rocksdb.RocksdbRequests request,
        io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteKeysMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getValue(com.wxm.rocksdb.RocksdbRequest request,
        io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetValueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getValues(com.wxm.rocksdb.RocksdbRequests request,
        io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionKVSReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetValuesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class RocksdbActionBlockingStub extends io.grpc.stub.AbstractStub<RocksdbActionBlockingStub> {
    private RocksdbActionBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RocksdbActionBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RocksdbActionBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RocksdbActionBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.wxm.rocksdb.RocksdbActionReply saveKV(com.wxm.rocksdb.RocksdbRequest request) {
      return blockingUnaryCall(
          getChannel(), getSaveKVMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.wxm.rocksdb.RocksdbActionReply saveKVS(com.wxm.rocksdb.RocksdbRequests request) {
      return blockingUnaryCall(
          getChannel(), getSaveKVSMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.wxm.rocksdb.RocksdbActionReply deleteKey(com.wxm.rocksdb.RocksdbRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteKeyMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.wxm.rocksdb.RocksdbActionReply deleteKeys(com.wxm.rocksdb.RocksdbRequests request) {
      return blockingUnaryCall(
          getChannel(), getDeleteKeysMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.wxm.rocksdb.RocksdbActionReply getValue(com.wxm.rocksdb.RocksdbRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetValueMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.wxm.rocksdb.RocksdbActionKVSReply getValues(com.wxm.rocksdb.RocksdbRequests request) {
      return blockingUnaryCall(
          getChannel(), getGetValuesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class RocksdbActionFutureStub extends io.grpc.stub.AbstractStub<RocksdbActionFutureStub> {
    private RocksdbActionFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RocksdbActionFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RocksdbActionFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RocksdbActionFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.wxm.rocksdb.RocksdbActionReply> saveKV(
        com.wxm.rocksdb.RocksdbRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveKVMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.wxm.rocksdb.RocksdbActionReply> saveKVS(
        com.wxm.rocksdb.RocksdbRequests request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveKVSMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.wxm.rocksdb.RocksdbActionReply> deleteKey(
        com.wxm.rocksdb.RocksdbRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteKeyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.wxm.rocksdb.RocksdbActionReply> deleteKeys(
        com.wxm.rocksdb.RocksdbRequests request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteKeysMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.wxm.rocksdb.RocksdbActionReply> getValue(
        com.wxm.rocksdb.RocksdbRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetValueMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.wxm.rocksdb.RocksdbActionKVSReply> getValues(
        com.wxm.rocksdb.RocksdbRequests request) {
      return futureUnaryCall(
          getChannel().newCall(getGetValuesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAVE_KV = 0;
  private static final int METHODID_SAVE_KVS = 1;
  private static final int METHODID_DELETE_KEY = 2;
  private static final int METHODID_DELETE_KEYS = 3;
  private static final int METHODID_GET_VALUE = 4;
  private static final int METHODID_GET_VALUES = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RocksdbActionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RocksdbActionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAVE_KV:
          serviceImpl.saveKV((com.wxm.rocksdb.RocksdbRequest) request,
              (io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionReply>) responseObserver);
          break;
        case METHODID_SAVE_KVS:
          serviceImpl.saveKVS((com.wxm.rocksdb.RocksdbRequests) request,
              (io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionReply>) responseObserver);
          break;
        case METHODID_DELETE_KEY:
          serviceImpl.deleteKey((com.wxm.rocksdb.RocksdbRequest) request,
              (io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionReply>) responseObserver);
          break;
        case METHODID_DELETE_KEYS:
          serviceImpl.deleteKeys((com.wxm.rocksdb.RocksdbRequests) request,
              (io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionReply>) responseObserver);
          break;
        case METHODID_GET_VALUE:
          serviceImpl.getValue((com.wxm.rocksdb.RocksdbRequest) request,
              (io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionReply>) responseObserver);
          break;
        case METHODID_GET_VALUES:
          serviceImpl.getValues((com.wxm.rocksdb.RocksdbRequests) request,
              (io.grpc.stub.StreamObserver<com.wxm.rocksdb.RocksdbActionKVSReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RocksdbActionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RocksdbActionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.wxm.rocksdb.RocksdbProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RocksdbAction");
    }
  }

  private static final class RocksdbActionFileDescriptorSupplier
      extends RocksdbActionBaseDescriptorSupplier {
    RocksdbActionFileDescriptorSupplier() {}
  }

  private static final class RocksdbActionMethodDescriptorSupplier
      extends RocksdbActionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RocksdbActionMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RocksdbActionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RocksdbActionFileDescriptorSupplier())
              .addMethod(getSaveKVMethod())
              .addMethod(getSaveKVSMethod())
              .addMethod(getDeleteKeyMethod())
              .addMethod(getDeleteKeysMethod())
              .addMethod(getGetValueMethod())
              .addMethod(getGetValuesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
