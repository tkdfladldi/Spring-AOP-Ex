package com.park.ex.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeDecorator implements Component{
	
	private static final Logger logger = LoggerFactory.getLogger(DecoratorPatternClient.class);
	private Component component;
	
	public TimeDecorator(Component component) {
		this.component = component;
	}
	
	@Override
	public String operation() {
		
		
		logger.info("TimeDecorator 실행");
		
		long startTime = System.currentTimeMillis();
		
		String result = component.operation();
		 
		long endTime = System.currentTimeMillis();
		
		long resultTime =  endTime - startTime;
		
		logger.info("TimeDecorator 종료  resultTime = {}ms" , resultTime);
		
		return result;
	}

}
