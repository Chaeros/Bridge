package com.ssafy.bridge.sido.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.bridge.sido.dto.response.SidoResponse;

public interface SidoService {
	/*
	 * add : 추가
	 * modify : 수정
	 * remove : 삭제
	 * search : 검색
	 * display : 출력
	 */
	
	public List<SidoResponse> displaySidoList() throws SQLException;
}
