package com.park.ex;


import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import callback.TraceCallback;
import callback.TraceTemplate;
import logtrace.LogTrace;

@Controller
public class BoardController {
	
	private final ExDao exdao;
	private final TraceTemplate traceTemplate;
	
	
	@Autowired
	public BoardController(ExDao exdao, LogTrace logTrace) {
		this.exdao = exdao;
		this.traceTemplate = new TraceTemplate(logTrace);
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(HttpServletRequest request , @RequestParam(required = false ,  defaultValue = "1") int rang 
																, @RequestParam(required = false , defaultValue =  "1") int page ) throws Exception {
		
		InputStream  x = getClass().getClassLoader().getResourceAsStream("file.xml");
		Properties po = new Properties();
		po.loadFromXML(x);
		Enumeration<?> enumeration  = po.keys();
		while (enumeration.hasMoreElements()) {
			String object = (String) enumeration.nextElement();
			
		}
		
		
		
		
		traceTemplate.execute("BoardController.board()", new TraceCallback<List<BoardVo>>() {

			@Override
			public List<BoardVo> call() throws Exception {
				List<BoardVo> list = exdao.createBoard();
				List<BoardVo> boardList = new ArrayList<BoardVo>();
				
				for(int i = (page-1) *10; i< page *10 ; i++) {
					if(list.size() <= i) {
						break;
					}
				
				boardList.add(list.get(i));
				Page pageClass = new Page();
				Map<String, Object> map = pageClass.pagenation(rang , page , list.size());
					
				request.setAttribute("Page", map);
				request.setAttribute("Board", boardList);
				}
				return  boardList;
			}
			
			
			
		});
		
//		AbstractTemplate<ArrayList<BoardVo>> st = new AbstractTemplate<ArrayList<BoardVo>>(logTrace) {
//
//			@Override
//			protected ArrayList<BoardVo> call() {
//				List<BoardVo> list = exdao.createBoard();
//				List<BoardVo> boardList = new ArrayList<BoardVo>();
//				
//				for(int i = (page-1) *10; i< page *10 ; i++) {
//					if(list.size() <= i) {
//						break;
//					}
//				
//				boardList.add(list.get(i));
//				Page pageClass = new Page();
//				Map<String, Object> map = pageClass.pagenation(rang , page , list.size());
//					
//				request.setAttribute("Page", map);
//				request.setAttribute("Board", boardList);
//				}
//				return (ArrayList<BoardVo>) boardList;
//			}
//		};
//		
//		st.excute("BoardController.board()");
		
		
		return "board";
	}
	@RequestMapping(value = "/boardContent", method = RequestMethod.GET)
	public String popup(HttpServletRequest request , @RequestParam(required = false ,  defaultValue = "1") int rang 
																, @RequestParam(required = false , defaultValue =  "1") int page ) {
		return "boardContent";
	}
	
	
	@RequestMapping(value = "/nav", method = RequestMethod.GET)
	public String nav(HttpServletRequest request , @RequestParam(required = false ,  defaultValue = "1") int rang 
																, @RequestParam(required = false , defaultValue =  "1") int page ) {
		return "nav";
	}
	
	
	
	public List<BoardVo> createBoard() {
		
		List<BoardVo> list = new ArrayList<BoardVo>();
		Locale locale = new Locale("ko", "KR"); // 한국어, 대한민국
		
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
		
		return list;
	}
}
