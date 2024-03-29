package com.ssafy.bridge.freeboard.dto.request;

public class FreeBoardAddRequest {
	private String title;
	private String content;
	private String writer;
	
	public FreeBoardAddRequest(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getWriter() {
		return writer;
	}

	@Override
	public String toString() {
		return "FreeBoardAddRequest [title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}
}