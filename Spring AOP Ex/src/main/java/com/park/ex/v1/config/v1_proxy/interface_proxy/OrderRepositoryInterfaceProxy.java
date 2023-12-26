//package com.park.ex.v1.config.v1_proxy.interface_proxy;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.park.ex.log.TraceStatus;
//import com.park.ex.v1.OrderRepositoryV1;
//
//import logtrace.LogTrace;
//
//
//public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1{
//
//	private OrderRepositoryV1 target;
//	private final LogTrace logtrace;
//	
//	@Autowired
//	public OrderRepositoryInterfaceProxy(OrderRepositoryV1 orderRepositoryV1, LogTrace logtrace) {
//		this.target = orderRepositoryV1;
//		this.logtrace = logtrace;
//	}
//	
//	
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
//		
//	}
//
//}
