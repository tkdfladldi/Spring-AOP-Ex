package com.park.ex.jdkdynamic;

import java.lang.reflect.Proxy;

public class JdkDynamicProxyTest {

	public static void main(String[] args) {
		
		AInterface target = new AImpl();
		
		TimeInvocationHandler handler = new TimeInvocationHandler(target);
		
		AInterface proxy =  (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader() , new Class[]{AInterface.class} , handler);
		
		proxy.call();
	}

}
