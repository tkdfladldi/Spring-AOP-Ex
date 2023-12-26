//package com.park.ex.v1.v3_proxyfactory;
//
//import java.lang.reflect.Method;
//
//import org.aopalliance.intercept.MethodInterceptor;
//import org.aopalliance.intercept.MethodInvocation;
//
//import com.park.ex.log.TraceStatus;
//
//import logtrace.LogTrace;
//
//public class LogTraceAdvice implements MethodInterceptor{
//	
//	private final LogTrace logTrace;
//	
//	public LogTraceAdvice(LogTrace logTrace) {
//		this.logTrace = logTrace; 
//	}
//
//	@Override
//	public Object invoke(MethodInvocation invocation) throws Throwable {
//		TraceStatus status = null;
//		
//		Method method = invocation.getMethod();
//		String message = method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()";
//		
//		try {
//			status = logTrace.begin(message);
//			// 로직 호출
//			Object result = invocation.proceed();
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
