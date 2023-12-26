package com.park.ex.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class TimeAdvice implements MethodInterceptor {


	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("TimeProxy 실행");
		long startTime = System.currentTimeMillis();
		
		Object result = invocation.proceed();
		
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		System.out.println("TimeProxy 종료 resultTime = " + resultTime);
		
		return result;
	}

}
