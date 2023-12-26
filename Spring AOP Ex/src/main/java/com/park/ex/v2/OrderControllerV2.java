package com.park.ex.v2;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderControllerV2 {
	
	@Autowired
	OrderServiceV2 orderServiceV2;
	
	
	@ResponseBody
	@RequestMapping( value =  "/v2/request", method = RequestMethod.GET)
	public String request(@RequestParam ("itemId") String itemId) {
		
		orderServiceV2.orderItem(itemId);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping( value =  "/v2/no-log", method = RequestMethod.GET)
	public String noLog() {
		return "ok";
	}

}
