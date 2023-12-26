package com.park.ex.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RealComponent implements Component{
	
	private static final Logger logger = LoggerFactory.getLogger(RealComponent.class);

	@Override
	public String operation() {
		
		logger.info("RealComponent 실행");
		return "data";
	}
	

}
