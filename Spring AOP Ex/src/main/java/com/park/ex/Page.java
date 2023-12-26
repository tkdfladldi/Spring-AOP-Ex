package com.park.ex;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Page{
	
	
	
	public Map<String, Object> pagenation(int rang , int page , int boardCount) {
		
		Map<String, Object> map = new HashMap<String, Object>();
	
		int totalPage = (int) Math.ceil((double)boardCount / 10);
		int startPage = ((rang-1) * 10) +1;
		int lastPage = rang * 10;
		boolean nextBool = true;
		
		if(lastPage > totalPage) {
			lastPage = totalPage;
			nextBool = false;
		}
		
		map.put("startPage", startPage);
		map.put("lastPage", lastPage);
		map.put("rang", rang);
		map.put("page", page);
		map.put("nextBool", nextBool);
		
		return map;
	}


}
