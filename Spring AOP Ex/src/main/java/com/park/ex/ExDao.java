package com.park.ex;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.park.ex.log.HelloTraceV1;
import com.park.ex.log.HelloTraceV2;
import com.park.ex.log.TraceId;
import com.park.ex.log.TraceStatus;

import logtrace.AbstractTemplate;
import logtrace.LogTrace;

@Repository
public class ExDao {
	
	
	private final ExService ExService;
	private final LogTrace logTrace;
	
	@Autowired
	public ExDao(ExService ExService, LogTrace logTrace) {
		this.ExService = ExService;
		this.logTrace = logTrace;
	}
	
	public List<BoardVo> createBoard() throws Exception {
		
		
		
		AbstractTemplate<ArrayList<BoardVo>> at = new AbstractTemplate<ArrayList<BoardVo>>(logTrace) {
			
			@Override
			protected ArrayList<BoardVo> call() {
				List<BoardVo> list = new ArrayList<BoardVo>();
				Locale locale = new Locale("ko", "KR"); // 한국어, 대한민국
				
				try {
					ExService.service();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Date date = new Date();
				DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
				String formattedDate = dateFormat.format(date);
				
				for(int i =1; i <= 333; i++) {
					BoardVo boardVo = new BoardVo();
					boardVo.setContent(i + "번째 게시글 내용입니다...");
					boardVo.setTitle(i + "번째 게시글 타이틀 입니다.");
					boardVo.setDate(formattedDate);
					
					list.add(boardVo);
				}
				return (ArrayList<BoardVo>) list;
			}
		};
		return at.excute("ExDao.createBoard()");
		
		
		
		
	}


}
