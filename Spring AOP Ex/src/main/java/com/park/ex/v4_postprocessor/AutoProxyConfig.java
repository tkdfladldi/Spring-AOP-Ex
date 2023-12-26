//package com.park.ex.v4_postprocessor;
//
//import org.springframework.aop.Advisor;
//import org.springframework.aop.aspectj.AspectJExpressionPointcut;
//import org.springframework.aop.support.DefaultPointcutAdvisor;
//import org.springframework.aop.support.NameMatchMethodPointcut;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//
//import com.park.ex.v1.v3_proxyfactory.LogTraceAdvice;
//
//import logtrace.LogTrace;
//
//@Configuration
//@EnableAspectJAutoProxy
//public class AutoProxyConfig {
//	
////	@Bean 
////	public Advisor advisor1(LogTrace logTrace) {
////		NameMatchMethodPointcut pointcot = new NameMatchMethodPointcut();
////		pointcot.setMappedNames(new String[] {"order*" , "request*" , "save*"});
////		LogTraceAdvice logTraceAdvice =  new LogTraceAdvice(logTrace);
////		return new DefaultPointcutAdvisor(pointcot , logTraceAdvice);
////	}
//	
////	@Bean
////	public Advisor advisor2(LogTrace logTrace) {
////		//pointcut 
////		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
////		pointcut.setExpression("execution(* com.park.ex.v*..*(..)) && !execution(* com.park.ex.v*..nolog(..))");
////		
////		//advice
////		LogTraceAdvice logTraceAdvice =  new LogTraceAdvice(logTrace);
////		return new DefaultPointcutAdvisor(pointcut , logTraceAdvice);
////	}
//
//}
