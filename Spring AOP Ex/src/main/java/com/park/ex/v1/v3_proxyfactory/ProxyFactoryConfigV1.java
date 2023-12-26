//package com.park.ex.v1.v3_proxyfactory;
//
//import org.aopalliance.aop.Advice;
//import org.springframework.aop.Advisor;
//import org.springframework.aop.framework.ProxyFactory;
//import org.springframework.aop.support.DefaultPointcutAdvisor;
//import org.springframework.aop.support.NameMatchMethodPointcut;
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
//public class ProxyFactoryConfigV1 {
//	
//	@Bean
//	public OrderControllerV1 orderControllerV1(LogTrace logTrace) {
//		OrderControllerV1 orderController = new OrderControllerV1Impl(orderServiceV1(logTrace));
//		ProxyFactory proxyFactory = new ProxyFactory(orderController);
//		proxyFactory.addAdvisor(getAdvisor(logTrace));
//		OrderControllerV1 proxy = (OrderControllerV1) proxyFactory.getProxy();
//		return proxy;
//	}
//	
//	@Bean
//	public OrderServiceV1 orderServiceV1(LogTrace logTrace) {
//		OrderServiceV1 orderService = new OrderServiceV1Impl(orderRepositoryV1(logTrace));
//		ProxyFactory proxyFactory = new ProxyFactory(orderService);
//		proxyFactory.addAdvisor(getAdvisor(logTrace));
//		OrderServiceV1 proxy = (OrderServiceV1) proxyFactory.getProxy();
//		return proxy;
//	}
//	
//	
//	@Bean
//	public OrderRepositoryV1 orderRepositoryV1(LogTrace logTrace) {
//		OrderRepositoryV1 orderRepository = new OrderRepositoryV1Impl();
//		ProxyFactory proxyFactory = new ProxyFactory(orderRepository);
//		proxyFactory.addAdvisor(getAdvisor(logTrace));
//		OrderRepositoryV1 proxy = (OrderRepositoryV1) proxyFactory.getProxy();
//		return proxy;
//	}
//
//	private Advisor getAdvisor(LogTrace logTrace) {
//		NameMatchMethodPointcut pointcot = new NameMatchMethodPointcut();
//		pointcot.setMappedNames(new String[] {"order*" , "request*" , "save*"});
//		LogTraceAdvice logTraceAdvice =  new LogTraceAdvice(logTrace);
//		return new DefaultPointcutAdvisor(pointcot , logTraceAdvice);
//	}
//
//}
