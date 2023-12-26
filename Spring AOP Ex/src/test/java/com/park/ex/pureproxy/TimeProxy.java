package com.park.ex.pureproxy;

public class TimeProxy extends ConcreateLogic{

	
	private ConcreateLogic concreateLogic;
	
	public TimeProxy(ConcreateLogic concreateLogic) {
		this.concreateLogic = concreateLogic;
	}
	
	@Override
	public String operation() {
		System.out.println("TimeDecorator  실행");
		
		long startTime = System.currentTimeMillis();
		
		String result = concreateLogic.operation();
		
		long endTime = System.currentTimeMillis();
		
		long resultTime = endTime - startTime;
		System.out.println("TimeDecorator 종료 resultTime = " + resultTime) ;
		 
		return result;
	}
}
