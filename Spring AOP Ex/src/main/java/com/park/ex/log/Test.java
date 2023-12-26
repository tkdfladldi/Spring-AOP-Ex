package com.park.ex.log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.park.ex.log.HelloTraceV1;

import com.park.ex.log.TraceStatus;

import abstractTemplate.AbstractTemplate;
import abstractTemplate.SubClassLogic1;
import abstractTemplate.SubClassLogic2;

public class Test {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloTraceV2.class);
	
	public static void main(String[] args) {
		
		//templateMethodV1();
		templateMethodV2();
	}
	
	public static void logic1() {
		long startTime = System.currentTimeMillis();
		
		logger.info("비지니스 로직1 실행");
		
		long endTime = System.currentTimeMillis();
		
		long resultTime = endTime -  startTime;
		
		logger.info("resultTime = {}" , resultTime);
		
	
	}
	
	public static void logic2() {
		long startTime = System.currentTimeMillis();
		
		logger.info("비지니스 로직2 실행");
		
		long endTime = System.currentTimeMillis();
		
		long resultTime = endTime -  startTime;
		
		logger.info("resultTime = {}" , resultTime);
		
	
	}
	
	static void templateMethodV1() {
		AbstractTemplate template1 = new SubClassLogic1();
		template1.execute();
		
		AbstractTemplate template2 = new SubClassLogic2();
		template2.execute();
	}
	
	static void templateMethodV2() {
		
		AbstractTemplate  ab = new AbstractTemplate(){

			@Override
			protected void call() {
				System.out.println("비즈니스 로직 1 실행");
				
			}
			
		};
		ab.execute();
		System.out.println(ab.getClass());
		AbstractTemplate  ab2 = new AbstractTemplate(){

			@Override
			protected void call() {
				System.out.println("비즈니스 로직 2 실행");
				
			}
			
		};
		ab2.execute();
		System.out.println(ab2.getClass());
	}
}
