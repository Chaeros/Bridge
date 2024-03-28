package com.ssafy.bridge.freeboard.dto.request;

public class FreeBoardRemoveRequest {
	int no;
	String id;

	public FreeBoardRemoveRequest(int no, String id) {
		super();
		this.no = no;
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public String getId() {
		return id;
	}

}
