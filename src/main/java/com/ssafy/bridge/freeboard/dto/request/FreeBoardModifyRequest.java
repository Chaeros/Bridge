package com.ssafy.bridge.freeboard.dto.request;

public class FreeBoardModifyRequest {
	private int no;
	private String title;
	private String content;
	private String id;

	public FreeBoardModifyRequest() {
	}

	public FreeBoardModifyRequest(int no, String title, String content, String id) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.id = id;
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

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "FreeBoardModifyRequest [no=" + no + ", title=" + title + ", content=" + content + "]";
	}
}
