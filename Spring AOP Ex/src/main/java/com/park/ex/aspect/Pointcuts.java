package com.park.ex.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

	@Pointcut("execution(* com.park.ex.v2..*(..)) && !execution(* com.park.ex.v*..nolog(..))")
	public void allOrder() {} //pointcut signature
	
	@Pointcut("execution(* *..*Repository*.*(..))")
	public void allService() {} //pointcut signature
	
	
	@Pointcut("allOrder() && allService()")
	public void orderAndService() {} //pointcut signature
	
}
