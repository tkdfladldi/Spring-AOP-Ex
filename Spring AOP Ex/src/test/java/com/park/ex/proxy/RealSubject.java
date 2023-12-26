package com.park.ex.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RealSubject implements Subject{

	private static final Logger logger = LoggerFactory.getLogger(RealSubject.class);
	
	@Override
	public String operation() {
		
		logger.info("실제 객체 호출");
		
		sleep(1000);
		return "data";
	}

	
	public void sleep(int millis)  {
		
		Thread s = Thread.currentThread();
		try {
			s.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
