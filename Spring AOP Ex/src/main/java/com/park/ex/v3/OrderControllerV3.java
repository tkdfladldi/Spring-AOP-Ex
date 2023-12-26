package com.park.ex.v3;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class OrderControllerV3 {
	@Autowired
	OrderServiceV3 orderServiceV3;
	
	@ResponseBody
	@RequestMapping( value =  "/v3/request", method = RequestMethod.GET)
	public String request(@RequestParam ("itemId") String itemId) {
		orderServiceV3.orderItem(itemId);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping( value =  "/v3/no-log", method = RequestMethod.GET)
	public String noLog() {
		return "ok";
	}

}
