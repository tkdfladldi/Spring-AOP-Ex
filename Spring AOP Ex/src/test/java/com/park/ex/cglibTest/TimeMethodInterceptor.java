package com.park.ex.cglibTest;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TimeMethodInterceptor implements MethodInterceptor{
	
	private Object target;
	
	public TimeMethodInterceptor(Object target) {
		this.target = target;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		
		System.out.println("TimeProxy 실행");
		long startTime = System.currentTimeMillis();
		
		Object result = methodProxy.invoke(target, args);
		
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		System.out.println("TimeProxy 종료 resultTime = " + resultTime);
		
		return result;
	}

}
