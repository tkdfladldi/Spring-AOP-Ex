package com.park.ex.advice;

import org.springframework.aop.framework.ProxyFactory;

import com.park.ex.cglibTest.ConcreteService;
import com.park.ex.cglibTest.ServiceImpl;
import com.park.ex.cglibTest.ServiceInterface;

public class ProxyFactoryTest {
	
	void InterfaceProxy() {
		ServiceInterface target = new ServiceImpl();
		
		ProxyFactory proxyFactory = new ProxyFactory(target);
		proxyFactory.addAdvice(new TimeAdvice());
		
		ServiceInterface proxy = (ServiceInterface)proxyFactory.getProxy();
		proxy.save();
	}
	
	void concreteProxy() {
		
		ConcreteService target = new ConcreteService();
		
		ProxyFactory proxyFactory = new ProxyFactory(target);
		proxyFactory.addAdvice(new TimeAdvice());
		
		ConcreteService proxy = (ConcreteService)proxyFactory.getProxy();
		proxy.call();
		
	}
	
	
	void proxyTargetClassProxy() {
		ServiceInterface target = new ServiceImpl();
		
		ProxyFactory proxyFactory = new ProxyFactory(target);
		proxyFactory.addAdvice(new TimeAdvice());
		
		ServiceInterface proxy = (ServiceInterface)proxyFactory.getProxy();
		proxy.save();
	}
}
