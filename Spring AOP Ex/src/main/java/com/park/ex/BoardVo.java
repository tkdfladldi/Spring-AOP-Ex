package com.park.ex;

public class BoardVo {
	
	private String title;
	private String date;
	private String content;
	
	
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BoardVo [title=" + title + ", date=" + date + ", content=" + content + "]";
	}
	

}
