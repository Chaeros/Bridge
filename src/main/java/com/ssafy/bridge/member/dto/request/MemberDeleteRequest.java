package com.ssafy.bridge.member.dto.request;

public class MemberDeleteRequest {
	String id;
	String password;
	
	public MemberDeleteRequest(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
}
