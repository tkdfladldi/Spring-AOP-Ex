//package com.park.ex.v1.config.v2_dynamicproxy.handler;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//
//import com.park.ex.log.TraceStatus;
//import com.park.ex.v1.OrderRepositoryV1;
//
//import logtrace.LogTrace;
//
//public class LogTraceBasicHandler implements InvocationHandler{
//	private Object target;
//	private LogTrace logTrace;
//	
//
//	public LogTraceBasicHandler(Object target, LogTrace logTrace) {
//		this.target = target;
//		this.logTrace = logTrace;
//		
//	}
//
//
//	@Override
//	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		
//		TraceStatus status = null;
//		
//		String message = method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()";
//		
//		try {
//			status = logTrace.begin(message);
//			
//			// 로직 호출
//			Object result = method.invoke(target, args);
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
//}
