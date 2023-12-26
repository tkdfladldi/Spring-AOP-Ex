package com.park.ex.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import com.park.ex.advice.TimeAdvice;
import com.park.ex.cglibTest.ServiceImpl;
import com.park.ex.cglibTest.ServiceInterface;


public class MultiAdvisorTest {

	public static void main(String[] args) {
		//하나의 프록시 여러 어드바이저 
		//client -> proxy -> advisor2 -> advisor1 -> target
		DefaultPointcutAdvisor advisor1 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice1());
		DefaultPointcutAdvisor advisor2 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice2());
		
		ServiceInterface target = new ServiceImpl();
		ProxyFactory proxyFactory1 = new ProxyFactory(target);
		
		proxyFactory1.addAdvisor(advisor2);
		proxyFactory1.addAdvisor(advisor1);
		ServiceInterface proxy1 = (ServiceInterface) proxyFactory1.getProxy();
		
		proxy1.save();
		
		//client -> proxy2(advisor2) -> proxy1(advisor1) -> target
		//프록시1 생성
//		ServiceInterface target = new ServiceImpl();
//		ProxyFactory proxyFactory1 = new ProxyFactory(target);
//		DefaultPointcutAdvisor advisor1 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice1());
//		proxyFactory1.addAdvisor(advisor1);
//		ServiceInterface proxy1 = (ServiceInterface) proxyFactory1.getProxy();
//		
//		//프록시2 생성
//		ProxyFactory proxyFactory2 = new ProxyFactory(proxy1);
//		DefaultPointcutAdvisor advisor2 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice2());
//		proxyFactory2.addAdvisor(advisor2);
//		ServiceInterface proxy2 = (ServiceInterface) proxyFactory2.getProxy();
//		
//		//실행
//		proxy2.save();
	}
	
	static class  Advice1 implements MethodInterceptor{

		@Override
		public Object invoke(MethodInvocation invocation) throws Throwable {
			System.out.println("advice1 호출");
			return invocation.proceed();
		}
	}
	
	static class  Advice2 implements MethodInterceptor{

		@Override
		public Object invoke(MethodInvocation invocation) throws Throwable {
			System.out.println("advice2 호출");
			return invocation.proceed();
		}
	}


}
