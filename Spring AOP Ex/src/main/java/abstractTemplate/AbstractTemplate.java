package abstractTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.park.ex.log.HelloTraceV2;

public abstract class AbstractTemplate {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloTraceV2.class);
	
	public void execute() {
		long startTime = System.currentTimeMillis();
		
		call();
		
		long endTime = System.currentTimeMillis();
		
		long resultTime = endTime -  startTime;
		
		logger.info("resultTime = {}" , resultTime);
	}
	
	
	protected abstract void call();

}
