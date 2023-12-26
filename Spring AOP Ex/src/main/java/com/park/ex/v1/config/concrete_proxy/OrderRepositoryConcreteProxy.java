//package com.park.ex.v1.config.concrete_proxy;
//
//import com.park.ex.log.TraceStatus;
//import com.park.ex.v2.OrderRepositoryV2;
//
//import logtrace.LogTrace;
//
//public class OrderRepositoryConcreteProxy extends OrderRepositoryV2{
//	
//	private final OrderRepositoryV2 target;
//	private final LogTrace logtrace;
//	
//	
//	public OrderRepositoryConcreteProxy(OrderRepositoryV2 target , LogTrace logtrace) {
//		this.target = target;
//		this.logtrace = logtrace;
//	}
//	
//	@Override
//	public void save(String itemId) throws Exception {
//		
//		TraceStatus status = null;
//		
//		try {
//			status = logtrace.begin("OrderRepository.request()");
//			
//			target.save(itemId);
//
//			logtrace.end(status);
//			
//			
//		} catch (Exception e) {
//			logtrace.exception(status, e);
//			throw e;
//		}
//	}
//}
