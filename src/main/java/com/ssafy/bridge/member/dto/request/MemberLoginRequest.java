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
	
	public void changePasswordToEncryptHash(String hash) {
		this.password = hash;
	}

	@Override
	public String toString() {
		return "MemberLoginRequest [id=" + id + ", password=" + password + "]";
	}
}
