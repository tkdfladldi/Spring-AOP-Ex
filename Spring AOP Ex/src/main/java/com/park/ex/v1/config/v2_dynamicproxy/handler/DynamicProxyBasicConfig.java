//package com.park.ex.v1.config.v2_dynamicproxy.handler;
//
//import java.lang.reflect.Proxy;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.park.ex.v1.OrderControllerV1;
//import com.park.ex.v1.OrderControllerV1Impl;
//import com.park.ex.v1.OrderRepositoryV1;
//import com.park.ex.v1.OrderRepositoryV1Impl;
//import com.park.ex.v1.OrderServiceV1;
//import com.park.ex.v1.OrderServiceV1Impl;
//
//import logtrace.LogTrace;
//
//@Configuration
//public class DynamicProxyBasicConfig {
//	
//	@Bean
//	public OrderControllerV1 orderControllerV1(LogTrace logTrace) {
//		OrderControllerV1 orderServiceV1 = new OrderControllerV1Impl(orderServiceV1(logTrace));
//		return (OrderControllerV1) Proxy.newProxyInstance(OrderControllerV1.class.getClassLoader() , new Class[]{OrderControllerV1.class}, new LogTraceBasicHandler(orderServiceV1, logTrace));
//	}
//	
//	
//	@Bean
//	public OrderServiceV1 orderServiceV1(LogTrace logTrace) {
//		OrderServiceV1 orderServiceV1 = new OrderServiceV1Impl(orderRepositoryV1(logTrace));
//		return (OrderServiceV1) Proxy.newProxyInstance(OrderServiceV1.class.getClassLoader() , new Class[]{OrderServiceV1.class}, new LogTraceBasicHandler(orderServiceV1, logTrace));
//	}
//	
//	
//	@Bean
//	public OrderRepositoryV1 orderRepositoryV1(LogTrace logTrace) {
//		OrderRepositoryV1 orderRepositoryV1 = new OrderRepositoryV1Impl();
//		return (OrderRepositoryV1) Proxy.newProxyInstance(OrderRepositoryV1.class.getClassLoader() , new Class[]{OrderRepositoryV1.class}, new LogTraceBasicHandler(orderRepositoryV1, logTrace));
//	}
//}
