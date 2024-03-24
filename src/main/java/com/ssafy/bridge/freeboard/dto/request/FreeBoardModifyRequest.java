package com.ssafy.bridge.freeboard.dto.request;

public class FreeBoardModifyRequest {
	private int no;
	private String title;
	private String content;

	public FreeBoardModifyRequest() {
	}

	public FreeBoardModifyRequest(int no, String title, String content) {
		this.no = no;
		this.title = title;
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "FreeBoardModifyRequest [no=" + no + ", title=" + title + ", content=" + content + "]";
	}
}
