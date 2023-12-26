package com.park.ex.aspect;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import logtrace.LogTrace;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

	//com.park.ex.v3 패키지 만 적용
    @Bean
    public LogTraceAspect LogTraceAspect(LogTrace logTrace) {
        return new LogTraceAspect(logTrace);
    }
    //com.park.ex.v2 패키지 만 적용
    @Bean
    public Aspect2 aspect2() {
        return new Aspect2();
    }
}