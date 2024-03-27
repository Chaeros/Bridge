package com.ssafy.bridge.member.dto.response;

public class MemberLoginResponse {
	String id;
	String name;
	String nickName;
	String region;
	String email;
	
	public MemberLoginResponse(String id, String name, String nickName, String region, String email) {
		super();
		this.id = id;
		this.name = name;
		this.nickName = nickName;
		this.region = region;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNickName() {
		return nickName;
	}

	public String getRegion() {
		return region;
	}

	public String getEmail() {
		return email;
	}
}

