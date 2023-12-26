//package com.park.ex.v1.config.v1_proxy.interface_proxy;
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
//public class InterfaceProxyConfig {
//	
//	
//	@Bean
//	public OrderControllerV1 orderController(LogTrace logTrace) {
//		
//		OrderControllerV1Impl  controllerV1Impl = new OrderControllerV1Impl(orderService(logTrace));
//		
//		return new OrderControllerInterfaceProxy(controllerV1Impl, logTrace);
//		
//	}
//	
//	@Bean
//	public OrderServiceV1 orderService(LogTrace logTrace) {
//		
//		OrderServiceV1Impl orderServiceV1Impl = new OrderServiceV1Impl(orderRepository(logTrace));
//		
//		return new OrderServiceInterfaceProxy(orderServiceV1Impl , logTrace);
//	}
//	
//	@Bean
//	public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
//		
//	 	OrderRepositoryV1Impl orderRepositoryV1Impl = new OrderRepositoryV1Impl();
//		
//		return new OrderRepositoryInterfaceProxy(orderRepositoryV1Impl , logTrace);
//	}
//}
