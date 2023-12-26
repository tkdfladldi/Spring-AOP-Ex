package template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.park.ex.log.HelloTraceV2;

public class TemplateCallbackTest {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloTraceV2.class);
	
	public static void main(String[] args) {
		
		// 템플릿 콜백 패턴
		TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
		
		// 람다 
		timeLogTemplate.execute( () -> System.out.println("비즈니스 서비스 호출 1 "));
		
		//익명 내부 클래스 
		timeLogTemplate.execute(new Callback() {
			
			@Override
			public void call() {
				System.out.println(" 비즈니스 서비스 호출 2");
			}
		});
		
		// Callback 파라미터 
		timeLogTemplate.execute(new CallbackIm());
		
		
	}

}
