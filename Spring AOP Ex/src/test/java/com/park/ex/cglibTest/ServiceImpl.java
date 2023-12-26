package com.park.ex.cglibTest;

public class ServiceImpl implements ServiceInterface{

	@Override
	public void save() {
		System.out.println("save() 호출");
		
	}

	@Override
	public void find() {
		System.out.println("find() 호출");
	}

}
