//package com.park.ex.v1.config.concrete_proxy;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.park.ex.log.TraceStatus;
//import com.park.ex.v2.OrderControllerV2;
//
//import logtrace.LogTrace;
//public class OrderControllerConcreteProxy extends OrderControllerV2{
//	
//	private final OrderControllerV2 target;
//	private final LogTrace logTrace;
//	
//	public OrderControllerConcreteProxy(OrderControllerV2 target, LogTrace logTrace) {
//		super(null);
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
