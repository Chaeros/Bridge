package com.ssafy.bridge.freeboard.dto.request;

public class FreeBoardAddRequest {
	private String title;
	private String content;

	public FreeBoardAddRequest(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "FreeBoardAddRequest [title=" + title + ", content=" + content + "]";
	}
}