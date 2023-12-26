package com.park.ex.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeInvocationHandler implements InvocationHandler{
	
	private final Object target;
	
	public TimeInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("TimeProxy 실행");
		long startTime = System.currentTimeMillis();
		
		Object result =method.invoke(target, args);
		
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		System.out.println("TimeProxy 종료 resultTime = " + resultTime);
		
		return result;
	}

}
