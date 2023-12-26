package callback;

import org.apache.poi.ss.formula.functions.T;

public interface TraceCallback<T> {
	
	T call() throws Exception;

}
