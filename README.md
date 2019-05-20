# grpc-springboot

利用github上 yidongnan/grpc-spring-boot-starter 来实现

https://github.com/yidongnan/grpc-spring-boot-starter

# 1、PB（protobuf)

安装：
github：https://github.com/protocolbuffers/protobuf

下载路径：https://github.com/protocolbuffers/protobuf/releases

cd到protobuf-x.x.x目录
* $./configure
* $make
* $make check
* $sudo make install 
* $which protoc
* $protoc —version

代码生成：
https://developers.google.com/protocol-buffers/docs/javatutorial

protoc -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/addressbook.proto

e.g.

protoc -I=/grcCodegen --java_out=/grcCodegen /grcCodegen/helloworld.proto

# 2、GRPC
github：https://github.com/grpc/grpc-java

grpc代码生成（基于protoc文件）
https://github.com/grpc/grpc-java/tree/master/compiler


protoc --plugin=protoc-gen-grpc-java=build/exe/java_plugin/protoc-gen-grpc-java --grpc-java_out="$OUTPUT_FILE" --proto_path="$DIR_OF_PROTO_FILE" "$PROTO_FILE”


e.g.

cd /workspace/grpc-java/compiler

protoc --plugin=protoc-gen-grpc-java=build/exe/java_plugin/protoc-gen-grpc-java --grpc-java_out="/grcCodegen" --proto_path="/grcCodegen" "helloworld.proto"


# 3、rocksdb的整合
pom中集成lib
```
  <dependency>
    <groupId>org.rocksdb</groupId>
    <artifactId>rocksdbjni</artifactId>
    <version>5.13.3</version>
  </dependency>
```
java代码实例如下：https://github.com/facebook/rocksdb/wiki/RocksJava-Basics
