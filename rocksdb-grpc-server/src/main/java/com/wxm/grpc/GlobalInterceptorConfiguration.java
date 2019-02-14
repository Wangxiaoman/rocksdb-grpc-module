package com.wxm.grpc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.devh.boot.grpc.server.interceptor.GlobalServerInterceptorConfigurer;

@Configuration
public class GlobalInterceptorConfiguration {

    @Bean
    public GlobalServerInterceptorConfigurer globalInterceptorConfigurerAdapter() {
        return registry -> registry.addServerInterceptors(new LogGrpcInterceptor());
    }

}
