package com.park.ex;

public class MemberVo {
	String  userid;
	Integer password;
	String  email;
	String  phoneNum;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Integer getPassword() {
		return password;
	}
	public void setPassword(Integer password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	@Override
	public String toString() {
		return "MemberVo [userid=" + userid + ", password=" + password + ", email=" + email + ", phoneNum=" + phoneNum
				+ "]";
	}
}

