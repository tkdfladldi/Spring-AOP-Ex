//package com.park.ex.v1;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class OrderControllerV1Impl implements OrderControllerV1{
//	
//	
//	private final OrderServiceV1 orderServiceV1;
//	
//	@Autowired
//	public OrderControllerV1Impl(OrderServiceV1 orderServiceV1) {
//		this.orderServiceV1 = orderServiceV1;
//	}
//	
//
//	@Override
//	public String request(String itemId) {
//		
//		orderServiceV1.orderItem(itemId);
//		System.out.println("들어오냐컨");
//		return "ok";
//	}
//
//	@Override
//	public String noLog() {
//		return "ok";
//	}
//
//}
