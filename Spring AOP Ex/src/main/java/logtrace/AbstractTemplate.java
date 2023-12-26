package logtrace;

import org.springframework.beans.factory.annotation.Autowired;

import com.park.ex.log.TraceStatus;

public abstract class AbstractTemplate<T> {
	
	private final LogTrace logTrace;
	
	@Autowired
	public AbstractTemplate(LogTrace logTrace) {
		this.logTrace = logTrace;
	}
	
	public T excute(String message) throws Exception {
		
		TraceStatus status = null;
		
		try {
			status = logTrace.begin(message);
			T result = call();
			
			logTrace.end(status);
			return result;
		} catch (Exception e) {
			logTrace.exception(status , e);
			throw e;
		}
	}

	
	
	
	protected abstract T call();
	
}
