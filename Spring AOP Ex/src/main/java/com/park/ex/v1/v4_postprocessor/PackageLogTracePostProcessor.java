//package com.park.ex.v1.v4_postprocessor;
//
//import org.springframework.aop.Advisor;
//import org.springframework.aop.framework.ProxyFactory;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//
//public class PackageLogTracePostProcessor implements BeanPostProcessor {
//	
//	private final String basePackage;
//	private final Advisor advisor;
//	
//	public PackageLogTracePostProcessor(String basePackage, Advisor advisor) {
//		this.basePackage = basePackage;
//		this.advisor = advisor;
//	}
//	
//	
//
//	@Override
//	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		return bean;
//	}
//
//	@Override
//	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println("pram beanName = " + beanName + " bean= " + bean.getClass());
//		
//		//프록시 적용 대상 여부 체크
//		//프록시 적용 대상이 아니면 원본을 그대로 진행
//		String packageName = bean.getClass().getPackage().getName().toString();
//		System.out.println(packageName);
//		if(!packageName.equals("com.park.ex.v1") ) {
//			return bean;
//		}
//		
//		//프록시 대상이면 프록시를 만들어서 반환
//		ProxyFactory proxyFactory = new ProxyFactory(bean);
//		proxyFactory.addAdvisor(advisor);
//		Object proxy =  proxyFactory.getProxy();
//		
//		System.out.println("create proxy: target= " + bean.getClass() + " proxy= " + proxy.getClass());
//		return proxy;
//	}
//
//}
