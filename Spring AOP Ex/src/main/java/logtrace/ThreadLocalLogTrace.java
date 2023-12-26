package logtrace;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import com.park.ex.log.HelloTraceV2;
import com.park.ex.log.TraceId;
import com.park.ex.log.TraceStatus;

public class ThreadLocalLogTrace implements LogTrace {
	
	private static final String START_PREFIX = "-->";
	private static final String COMPLETE_PREFIX = "<--";
	private static final String EX_PREFIX = "<x-";

	private static final Logger logger = LoggerFactory.getLogger(HelloTraceV2.class);
	
	private ThreadLocal<TraceId> traceIdHolder = new ThreadLocal<>();
	
	private void syncTraceId() {
		TraceId traceId = traceIdHolder.get();
		if(traceId == null) {
			traceIdHolder.set(new TraceId());
		}else {
			traceIdHolder.set(traceId.cereateNextId());
		}
	}
	
	@Override
	public TraceStatus begin(String message) {
		syncTraceId();
		
		TraceId traceId = traceIdHolder.get();
		Long startTimeMs = System.currentTimeMillis();
		logger.info("[" + traceId.getId()+"]"  +  addSpace(START_PREFIX, traceId.getLevel()) + " " + message);
		
		return new TraceStatus(traceId, startTimeMs , message);
	}

	@Override
	public void end(TraceStatus status) {
		complete(status, null);
	}

	@Override
	public void exception(TraceStatus status, Exception e) {
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
		
		releaseTraceId();
	}
	private void releaseTraceId() {
		TraceId traceId = traceIdHolder.get();
		if(traceId == null) {
			traceIdHolder.remove();
		}else {
			traceId.cereateNextId();
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
