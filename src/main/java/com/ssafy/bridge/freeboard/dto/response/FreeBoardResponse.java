package com.ssafy.bridge.freeboard.dto.response;

public class FreeBoardResponse {
	private int no;
	private String title;
	private String content;
	private String writer;
	private int hit;
	private String writeDate;

	public FreeBoardResponse(int no, String title, String content, String writer, int hit, String writeDate) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hit = hit;
		this.writeDate = writeDate;
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

	public String getWriter() {
		return writer;
	}

	public int getHit() {
		return hit;
	}

	public String getWriteDate() {
		return writeDate;
	}

	@Override
	public String toString() {
		return "FreeBoardResponse [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", hit=" + hit + ", writeDate=" + writeDate + "]";
	}
}
