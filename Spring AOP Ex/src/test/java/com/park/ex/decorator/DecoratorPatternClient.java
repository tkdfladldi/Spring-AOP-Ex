package com.park.ex.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DecoratorPatternClient {
	private static final Logger logger = LoggerFactory.getLogger(DecoratorPatternClient.class);

	private Component component;
	
	public DecoratorPatternClient(Component component) {
		this.component = component;
	}
	
	
	public void excute() {
		
		String result = component.operation();
		
		logger.info("result = {} " , result);
	}
	
}
