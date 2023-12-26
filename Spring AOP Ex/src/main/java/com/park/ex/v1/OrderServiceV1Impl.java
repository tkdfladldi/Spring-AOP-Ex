//package com.park.ex.v1;
//
//public class OrderServiceV1Impl implements OrderServiceV1{
//	
//	
//	private final OrderRepositoryV1 orderRepositoryV1;
//	
//	
//	public OrderServiceV1Impl(OrderRepositoryV1 orderRepositoryV1) {
//		this.orderRepositoryV1 = orderRepositoryV1;
//	}
//
//	@Override
//	public void orderItem(String itemId) {
//		try {
//			orderRepositoryV1.save(itemId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
