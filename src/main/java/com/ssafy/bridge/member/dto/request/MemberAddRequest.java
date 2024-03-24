package com.ssafy.bridge.member.dto.request;

public class MemberAddRequest {
	String id;
	String password;
	String name;
	String nickName;
	String region;
	String email;
	
	public MemberAddRequest(String id, String password, String name, String nickName, String region, String email) {
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
