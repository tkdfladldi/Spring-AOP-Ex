package com.park.ex.pureproxy;

public class ConcreateClient {
	
	private ConcreateLogic concreateLogic;
	
	
	public ConcreateClient(ConcreateLogic concreateLogic) {
		this.concreateLogic = concreateLogic;
	}
	
	public void execute() {
		concreateLogic.operation();
	}
}
