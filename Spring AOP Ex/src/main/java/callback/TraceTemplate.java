package callback;

import com.park.ex.log.TraceStatus;

import logtrace.LogTrace;

public class TraceTemplate {
	
	private final LogTrace trace;
	
	
	public TraceTemplate(LogTrace trace) {
		
		this.trace = trace;
	}
	
	public <T> T execute(String message , TraceCallback<T> callback) throws Exception {
		
			
			TraceStatus status = null;
			
			try {
				status = trace.begin(message);
				T result = callback.call();
				
				trace.end(status);
				return result;
			} catch (Exception e) {
				trace.exception(status , e);
				throw e;
			}
		
	}

}
