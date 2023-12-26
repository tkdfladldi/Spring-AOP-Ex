//package com.park.ex.v1.config.v1_proxy.interface_proxy;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.park.ex.log.TraceStatus;
//import com.park.ex.v1.OrderRepositoryV1;
//import com.park.ex.v1.OrderServiceV1;
//
//import logtrace.LogTrace;
//
//public class OrderServiceInterfaceProxy implements OrderServiceV1{
//	
//	private OrderServiceV1 target;
//	private final LogTrace logtrace;
//	
//	@Autowired
//	public OrderServiceInterfaceProxy(OrderServiceV1 orderServiceV1, LogTrace logtrace) {
//		this.target = orderServiceV1;
//		this.logtrace = logtrace;
//	}
//	
//	
//
//
//	@Override
//	public void orderItem(String itemId) {
//		
//		
//		TraceStatus status = null;
//		
//		try {
//			status = logtrace.begin("OrderServiceV1.orderItem()");
//			
//			target.orderItem(itemId);
//
//			logtrace.end(status);
//			
//			
//		} catch (Exception e) {
//			logtrace.exception(status, e);
//			throw e;
//		}
//		
//		
//	}
//
//}
