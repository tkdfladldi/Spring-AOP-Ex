package template;

import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.park.ex.log.HelloTraceV2;

import callback.TraceCallback;

public class TimeLogTemplate {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloTraceV2.class);
	
	public void execute(Callback callback ) {
		
		long startTime = System.currentTimeMillis();
		
		callback.call(); //  ** 
		
		long endTime = System.currentTimeMillis();
		
		long resultTime = endTime -  startTime;
		
		logger.info("resultTime = {}" , resultTime);
	}
}
