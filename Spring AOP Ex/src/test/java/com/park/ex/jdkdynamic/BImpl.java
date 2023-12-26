package com.park.ex.jdkdynamic;

public class BImpl implements AInterface{

	@Override
	public String call() {
		System.out.println("B 호출");
		return "B";
	}
	
	

}
