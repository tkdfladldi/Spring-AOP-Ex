package com.park.ex.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheProxy implements Subject{
	
	private static final Logger logger = LoggerFactory.getLogger(RealSubject.class);
	
	
	private Subject target;
	private String cacheValue;
	
	public CacheProxy(Subject target) {
		this.target = target;
	}

	@Override
	public String operation() {
		logger.info("프록시 호출");
		if(cacheValue == null) {
			cacheValue = target.operation();
		}
		return cacheValue;
	}

	
	
	
}

