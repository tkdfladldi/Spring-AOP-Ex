package com.park.ex.cglibTest;

import net.sf.cglib.proxy.Enhancer;

public class Main {

	public static void main(String[] args) {
		
		ConcreteService target = new ConcreteService();
		
		Enhancer enhancer = new Enhancer();
		
		enhancer.setSuperclass(ConcreteService.class);
		enhancer.setCallback(new TimeMethodInterceptor(target));
		ConcreteService  proxy = (ConcreteService) enhancer.create();
		
		proxy.call();
	}

}
