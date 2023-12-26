package abstractTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.park.ex.log.HelloTraceV2;

public class SubClassLogic2 extends AbstractTemplate{

	private static final Logger logger = LoggerFactory.getLogger(HelloTraceV2.class);
	
	@Override
	protected void call() {
		
		logger.info("비즈니스 로직 2 실행");
		
	}

}
