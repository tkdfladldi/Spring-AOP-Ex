package com.park.ex;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

@Service
public class RequestParamMethod {
	
	
	public Map<String, Object> requestToMap(HttpServletRequest request){
		
		Enumeration str = request.getParameterNames();
		Map<String , Object> map = new HashMap<String, Object>();
		
		while (str.hasMoreElements()) {
			
			String object = (String) str.nextElement();
			String[] params = request.getParameterValues(object);
			
			if(params.length == 1) {
				map.put(object, params[0]);
			}else {
				List<String> list = new ArrayList<String>();
				for(String param : params) {
					list.add(param);
				}
				map.put(object.replaceAll("\\[\\]", ""), list);
			}
		}
		return map;
		
	}

}
