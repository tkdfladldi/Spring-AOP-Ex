package strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.park.ex.log.HelloTraceV2;

// 필드에 전략을 보관하는 방식

public class ContextV1 {
	private static final Logger logger = LoggerFactory.getLogger(HelloTraceV2.class);

	private Strategy strategy;
	
	
	public ContextV1(Strategy strategy) {
		this.strategy = strategy;
	}
	
	
	public void execute() {
		long startTime = System.currentTimeMillis();
		
		strategy.call(); //  ** 
		
		long endTime = System.currentTimeMillis();
		
		long resultTime = endTime -  startTime;
		
		logger.info("resultTime = {}" , resultTime);
	}
	
}
