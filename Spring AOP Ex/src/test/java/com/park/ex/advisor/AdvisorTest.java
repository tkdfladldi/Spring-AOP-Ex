package com.park.ex.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import com.park.ex.advice.TimeAdvice;
import com.park.ex.cglibTest.ServiceImpl;
import com.park.ex.cglibTest.ServiceInterface;

public class AdvisorTest {

	public static void main(String[] args) {
		
		ServiceInterface target = new ServiceImpl();
		
		ProxyFactory proxyFactory = new ProxyFactory(target);
		
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		pointcut.setMappedName("save");
		
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, new TimeAdvice());
		proxyFactory.addAdvisor(advisor);

		ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
		proxy.save();
		proxy.find();
	}
	
	static class MyPointcut implements Pointcut{

		@Override
		public ClassFilter getClassFilter() {
			return ClassFilter.TRUE;
		}

		@Override
		public MethodMatcher getMethodMatcher() {
			return new MyMethodMatcher();
		}
		
		
		
	}
	
	static class MyMethodMatcher implements MethodMatcher{
		
		private String matchName = "save";

		@Override
		public boolean matches(Method method, Class<?> targetClass) {
			boolean result = method.getName().equals(matchName);
			System.out.println("포인트컷  호출  method =" + method.getName() + "targetClass = " + targetClass);
			System.out.println("포인트컷  결과 result =" + result);
			return result;
		}

		@Override
		public boolean isRuntime() {
			return false;
		}

		@Override
		public boolean matches(Method method, Class<?> targetClass, Object[] args) {
			return false;
		}
		
	}

}
