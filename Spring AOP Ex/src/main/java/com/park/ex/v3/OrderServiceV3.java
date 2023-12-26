package com.park.ex.v3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceV3 {

	@Autowired
	OrderRepositoryV3 orderRepositoryV3;
	

	public void orderItem(String itemId) {
		try {
			orderRepositoryV3.save(itemId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
