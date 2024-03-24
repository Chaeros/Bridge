package com.ssafy.bridge.attraction.info.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.bridge.attraction.info.dto.response.AttractionInfoResponse;

public interface AttractionInfoService {
	/*
	 * add : 추가
	 * modify : 수정
	 * remove : 삭제
	 * search : 검색
	 * display : 출력
	 */
	
	public List<AttractionInfoResponse> displayFreeBoardList() throws SQLException;
}
