//package com.park.ex.v1.config.v1_proxy.interface_proxy;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.park.ex.log.TraceStatus;
//import com.park.ex.v1.OrderControllerV1;
//
//import logtrace.LogTrace;
//
//public class OrderControllerInterfaceProxy implements OrderControllerV1{
//
//	private final OrderControllerV1 target;
//	
//	private final LogTrace logTrace;
//	
//	@Autowired
//	public OrderControllerInterfaceProxy(OrderControllerV1 target , LogTrace logTrace) {
//		this.target = target;
//		this.logTrace = logTrace;
//	}
//	
//	@Override
//	public String request(String itemId) {
//		
//		
//		TraceStatus status = null;
//		
//		try {
//			status = logTrace.begin("OrderControllerV1.request()");
//			
//			String result = target.request(itemId);
//
//			logTrace.end(status);
//			return result;
//			
//		} catch (Exception e) {
//			logTrace.exception(status, e);
//			throw e;
//		}
//	}
//
//	@Override
//	public String noLog() {
//		// TODO Auto-generated method stub
//		return target.noLog();
//	}
//
//}
