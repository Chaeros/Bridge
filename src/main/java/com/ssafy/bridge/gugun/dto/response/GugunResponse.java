package com.ssafy.bridge.gugun.dto.response;

public class GugunResponse {
	private int code;
	private String name;
	private int sidoCode;

	public GugunResponse(int code, String name, int sidoCode) {
		this.code = code;
		this.name = name;
		this.sidoCode = sidoCode;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public int getSidoCode() {
		return sidoCode;
	}

	@Override
	public String toString() {
		return "GugunResponse [code=" + code + ", name=" + name + ", sidoCode=" + sidoCode + "]";
	}
}
