package com.park.ex.pureproxy;

public class TestMain {

	public static void main(String[] args) {
		
		
		ConcreateClient concreateClient = new ConcreateClient(new TimeProxy(new ConcreateLogic()));
		concreateClient.execute();

	}

}
