package com.park.ex.ReflectionTest;

import java.lang.reflect.Method;

import com.park.ex.ReflectionTest.ReflectionTest.Hello;

public class ReflectionTest {
	
	public static void main(String[] args) throws Exception {
		
		
		Hello target = new Hello();
		
		// 공통 로직1 시작
//		System.out.println("start");
//		String result1= target.callA();
//		System.out.println(result1);
//		
//		// 공통 로직2 시작
//		System.out.println("start");
//		String result2= target.callB();
//		System.out.println(result2);
		
		
		
		reflection1("callA");
	}
	
	public static void reflection1(String param) throws Exception {
		Class helloClass = Class.forName("com.park.ex.ReflectionTest.ReflectionTest$Hello");
		Method methods = helloClass.getMethod(param);
		
		Hello target = new Hello();
		dynamicCall(methods , target);
	}
	
	public static void dynamicCall(Method method, Object target) throws Exception {
		System.out.println("start");
		Object result = method.invoke(target);
		System.out.println(result);
	}
	
	
	
	
	static class Hello {
		
		public String callA() {
			System.out.println("callA");
			
			return "A";
		}
		
		public String callB() {
			System.out.println("callB");
			return "B";
		}
	}

}
