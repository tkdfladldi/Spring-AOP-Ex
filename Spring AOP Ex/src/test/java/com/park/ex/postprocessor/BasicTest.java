package com.park.ex.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BasicTest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanPostProcessorConfig.class);
		
		B a = applicationContext.getBean("beanA" , B.class);
		a.helloB();
		
		
	}
	
	@Configuration
	static class BeanPostProcessorConfig{
		@Bean(name = "beanA")
		public A a() {
			return new A();
		}
		
		@Bean
		AToBPostProcessor helloPostProcessor() {
			return new AToBPostProcessor();
		}
	}
	
	static class A {
		public void helloA() {
			System.out.println("hello A");
		}
	}
	
	static class B {
		public void helloB() {
			System.out.println("hello B");
		}
	}
	
	
	
	static class AToBPostProcessor implements BeanPostProcessor{

		@Override
		public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
			System.out.println("beanName = " + beanName +" bean= " +bean);
			if(bean instanceof A) {
				return new B();
			}
			return bean;
		}

		@Override
		public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
			return bean;
		}
	}

}
