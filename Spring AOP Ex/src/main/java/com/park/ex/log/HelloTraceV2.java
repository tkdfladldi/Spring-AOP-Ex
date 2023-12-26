package com.park.ex.log;

import java.util.stream.IntStream;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.park.ex.HomeController;

@Component
public class HelloTraceV2 {
	
	private static final String START_PREFIX = "-->";
	private static final String COMPLETE_PREFIX = "<--";
	private static final String EX_PREFIX = "<x-";
	
	
	private static final Logger logger = LoggerFactory.getLogger(HelloTraceV2.class);
	
	
	
	public TraceStatus begin(String message) {
		
		TraceId traceId = new TraceId();
		Long startTimeMs = System.currentTimeMillis();
		logger.info("[" + traceId.getId()+"]"  +  addSpace(START_PREFIX, traceId.getLevel()) + " " + message);
		return new TraceStatus(traceId, startTimeMs , message);
	}
	// v2 에서 추가
	public TraceStatus beginSync(TraceId beforTraceId , String message) {
		
		TraceId nextId =beforTraceId.cereateNextId();
		Long startTimeMs = System.currentTimeMillis();
		logger.info("[" + nextId.getId()+"]"  +  addSpace(START_PREFIX, nextId.getLevel()) + " " + message);
		return new TraceStatus(nextId, startTimeMs , message);
	}

	public void end(TraceStatus status) {
		 complete(status, null);
	}
	public void exception(TraceStatus status , Exception e) {
		complete(status, e);
	}
	private void complete(TraceStatus status, Exception e) {
		Long stopTimeMs = System.currentTimeMillis();
		long resultTimeMs = stopTimeMs - status.getStartTimeMs();
		TraceId traceId = status.getTraceId();
		
		if(e == null) {
			logger.info("["  + traceId.getId() +"]"  +  addSpace(COMPLETE_PREFIX, traceId.getLevel())  +" "+status.getMessage() +" time = " +resultTimeMs+ "ms");
		}else {
			logger.info("["   + traceId.getId() +"]"  +  addSpace(EX_PREFIX, traceId.getLevel())  +" "+status.getMessage() + " time = " +resultTimeMs+ "ms ex = " + e.toString() );
		}
	}
	private String addSpace(String Prefix, int level) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<level; i++) {
			sb.append((i == level -1) ? "|" + Prefix : "|   ");
		}
		
		return sb.toString();
	}

}
