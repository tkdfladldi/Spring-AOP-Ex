package com.park.ex.v2;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV2 {
	
	
	private ObjectProvider<OrderRepositoryV2> objectProvider;
	
	public void save(String itemId) throws Exception {
		// 저장로직
		
		if(itemId.equals("ex")) {
			throw new Exception("예외 발생 !");
			
		}
		Sleep(1000);
		
	}

	private void Sleep(int i) {
		
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
