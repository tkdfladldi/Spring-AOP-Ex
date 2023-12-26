package com.park.ex.aop;

import org.junit.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.park.ex.v3.OrderRepositoryV3;
import com.park.ex.v3.OrderServiceV3;

public class AopTest {
	@Autowired
	OrderServiceV3 orderServiceV3;
	
	@Autowired
	OrderRepositoryV3 orderRepositoryV3;
	
	@Test
	public static void main(String[] args) {
		
		
		
		//AopUtils.isAopProxy(orderServiceV3);
		
		

	}

}
