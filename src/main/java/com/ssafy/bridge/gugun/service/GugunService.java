package com.ssafy.bridge.gugun.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.bridge.gugun.dto.response.GugunResponse;


public interface GugunService {
	/*
	 * add : 추가
	 * modify : 수정
	 * remove : 삭제
	 * search : 검색
	 * display : 출력
	 */
	public List<GugunResponse> displayGugunList() throws SQLException;
}
