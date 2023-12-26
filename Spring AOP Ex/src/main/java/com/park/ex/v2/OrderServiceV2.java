package com.park.ex.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV2 {
	@Autowired
	OrderRepositoryV2 orderRepositoryV2;

	public void orderItem(String itemId) {
		try {
			orderRepositoryV2.save(itemId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
