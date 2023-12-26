package logtrace;

import com.park.ex.log.TraceStatus;

public interface LogTrace {
	
	TraceStatus begin(String message);
	
	void end(TraceStatus status);
	
	void exception(TraceStatus status, Exception e);

}
