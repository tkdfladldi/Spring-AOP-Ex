//package com.park.ex.v1.config.concrete_proxy;
//
//import com.park.ex.log.TraceStatus;
//import com.park.ex.v2.OrderRepositoryV2;
//import com.park.ex.v2.OrderServiceV2;
//
//import logtrace.LogTrace;
//
//public class OrderServiceConcreteProxy extends OrderServiceV2{
//	
//	private final OrderServiceV2 target;
//	private final LogTrace logTrace;
//
//	
//	public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace logTrace) {
//		super(null);
//		this.target = target;
//		this.logTrace = logTrace;
//	}
//
//	@Override
//	public void orderItem(String itemId) {
//		
//		TraceStatus status = null;
//		
//		try {
//			status = logTrace.begin("OrderServiceV1.orderItem()");
//			
//			target.orderItem(itemId);
//
//			logTrace.end(status);
//			
//			
//		} catch (Exception e) {
//			logTrace.exception(status, e);
//			throw e;
//		}
//		
//	}
//}
