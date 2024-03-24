package com.ssafy.bridge.member.dto.response;

public class MemberResponse {
	String id;
	String password;
	String name;
	String nickName;
	String region;
	String email;
	
	public MemberResponse(String id, String password, String name, String nickName, String region, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickName = nickName;
		this.region = region;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
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
