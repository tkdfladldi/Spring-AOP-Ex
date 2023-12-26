//package com.park.ex.v1.v4_postprocessor;
//
//import org.springframework.aop.Advisor;
//import org.springframework.aop.support.DefaultPointcutAdvisor;
//import org.springframework.aop.support.NameMatchMethodPointcut;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.park.ex.v1.v3_proxyfactory.LogTraceAdvice;
//
//import logtrace.LogTrace;
//
//@Configuration
//public class BeanPostProcessorConfig {
//	
//	
//	@Bean
//	public PackageLogTracePostProcessor logTracePostProcessor(LogTrace logTrace) {
//		return new PackageLogTracePostProcessor("com.park.ex.v1", getAdvisor(logTrace));
//	}
//
//	private Advisor getAdvisor(LogTrace logTrace) {
//		NameMatchMethodPointcut pointcot = new NameMatchMethodPointcut();
//		pointcot.setMappedNames(new String[] {"order*" , "request*" , "save*"});
//		LogTraceAdvice logTraceAdvice =  new LogTraceAdvice(logTrace);
//		return new DefaultPointcutAdvisor(pointcot , logTraceAdvice);
//	}
//
//}
