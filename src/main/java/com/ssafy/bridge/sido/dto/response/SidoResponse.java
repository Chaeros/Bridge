package com.ssafy.bridge.sido.dto.response;

public class SidoResponse {
	private int code;
	private String name;

	public SidoResponse(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "SidoResponse [code=" + code + ", name=" + name + "]";
	}
	
}
