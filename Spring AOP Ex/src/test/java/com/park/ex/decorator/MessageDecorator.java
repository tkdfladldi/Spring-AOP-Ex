package com.park.ex.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageDecorator implements Component{
	
	private static final Logger logger = LoggerFactory.getLogger(DecoratorPatternClient.class);
	private Component component;
	
	public MessageDecorator(Component component) {
		this.component = component;
	}
	
	@Override
	public String operation() {
		
		logger.info("MessageDecorator 실행");
		String result = component.operation();
		String decoResult = "*****" + result  + "*****";
		logger.info("MessageDecorator 꾸미지 전  ={}  , 꾸미기  후 ={}" , result , decoResult);
		return decoResult;
	}

	
	
}
