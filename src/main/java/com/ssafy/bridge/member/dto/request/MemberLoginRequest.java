package com.ssafy.bridge.member.dto.request;

public class MemberLoginRequest {
	String id;
	String password;
	
	public MemberLoginRequest(String id, String password) {
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
