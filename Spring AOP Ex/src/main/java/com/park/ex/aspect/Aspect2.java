package com.park.ex.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class Aspect2 {
	
	
	@Around("com.park.ex.aspect.Pointcuts.allOrder()")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("[log] {" + joinPoint.getSignature() + "}");
		return joinPoint.proceed();
	}
	
	
	@Around("com.park.ex.aspect.Pointcuts.orderAndService()")
	public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
		
		try {
			System.out.println("[트랜잭션 시작] {" + joinPoint.getSignature() + "}");
			
			Object result=joinPoint.proceed();
			
			System.out.println("[트랜잭션 커밋] {" + joinPoint.getSignature() + "}");
			return result;
		}catch (Exception e) {
			System.out.println("[트랜잭션 롤백] {" + joinPoint.getSignature() + "}");
			throw e;
		} finally {
			System.out.println("[리소스 릴리즈] {" + joinPoint.getSignature() + "}");
		}
	}
	
	
	
}
