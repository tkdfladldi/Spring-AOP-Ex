package com.park.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller 
public class LoadController {

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public String loadget(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
		return "load";
	}
	
	@ResponseBody
	@RequestMapping(value = "/load", method = RequestMethod.POST)
	public List<MemberVo> load(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
		
		List<MemberVo> list = new ArrayList<>();
		
		for(int i =0; i<200; i++) {
			MemberVo memberVo = new MemberVo();
			memberVo.setUserid(i+ " 아이디");
			memberVo.setPassword(i);
			memberVo.setEmail(i+ " 이 메 일 ");
			memberVo.setPhoneNum(i+ "폰 넘 버 ");
			
			list.add(memberVo);
		}
		
		
		
		
		
//		List<BoardVo> list = new ArrayList<>();
//		
//		
//		
//		for(int i =0; i<200; i++) {
//			BoardVo boardVo = new BoardVo();
//			boardVo.setContent( i + " 컨텐츠입니다.");
//			boardVo.setDate(i + " 날짜 입니다.");
//			boardVo.setTitle(i + " 타이틀 입니다.");
//			
//			list.add(boardVo);
//		}
		
		  System.out.println(list);

		/*
		 * // JSON 형식으로 응답 반환 ObjectMapper mapper = new ObjectMapper(); String json =
		 * mapper.writeValueAsString(list); PrintWriter out = response.getWriter();
		 * out.print(json);
		 */
		  
		return list;
	}
	

}
