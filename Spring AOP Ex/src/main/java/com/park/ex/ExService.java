package com.park.ex;

import java.text.DateFormat;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.park.ex.log.HelloTraceV2;
import com.park.ex.log.TraceId;
import com.park.ex.log.TraceStatus;

import logtrace.AbstractTemplate;
import logtrace.LogTrace;


@Service
public class ExService {
	
	private final LogTrace logTrace;
	
	@Autowired
	public ExService(LogTrace logTrace) {
		this.logTrace = logTrace;
	}
	
	
	public void service() throws Exception {
		
		
		AbstractTemplate<Void> at = new AbstractTemplate<Void>(logTrace) {

			@Override
			protected Void call() {
				return null;
				
			}
		};
		
		at.excute("ExService.service()");
		
		
		
		
		
		
	}
	
	
	
	

}
