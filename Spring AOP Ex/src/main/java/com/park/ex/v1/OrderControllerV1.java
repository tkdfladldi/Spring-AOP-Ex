//package com.park.ex.v1;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller // 스프링은 @controller 또는 @ requestMapping 이 있어야 스프링 컨트롤러로 인식
//public interface OrderControllerV1 {
//	
//	@ResponseBody
//	@RequestMapping( value = "/v1/request", method = RequestMethod.GET)
//	String request(@RequestParam ("itemId") String itemId);
//	
//	
//	@RequestMapping( value = "/v1/no-log", method = RequestMethod.GET)
//	@ResponseBody
//	String noLog();
//	
//	
//	
//
//}
