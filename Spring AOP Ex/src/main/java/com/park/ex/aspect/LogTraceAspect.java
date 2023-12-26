package com.park.ex.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.park.ex.log.TraceStatus;

import logtrace.LogTrace;

@Aspect
public class LogTraceAspect {
	private final LogTrace logTrace;
	
	public LogTraceAspect(LogTrace logTrace) {
		this.logTrace = logTrace;
	}
	
	@Around("execution(* com.park.ex.v3..*(..)) && !execution(* com.park.ex.v*..nolog(..))")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
		TraceStatus status = null;
		
		try {
			String message = joinPoint.getSignature().toShortString();
			status = logTrace.begin(message);
			// 로직 호출
			Object result = joinPoint.proceed();

			logTrace.end(status);
			return result;
			
		} catch (Exception e) {
			logTrace.exception(status, e);
			throw e;
		}
	}

}
