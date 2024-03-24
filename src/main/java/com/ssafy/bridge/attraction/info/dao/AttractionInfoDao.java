package com.ssafy.bridge.attraction.info.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.bridge.attraction.info.dto.response.AttractionInfoResponse;


public interface AttractionInfoDao {
	/*
	 * insert : 추가
	 * update : 수정
	 * delete : 삭제
	 * select : 조회
	 */
	public List<AttractionInfoResponse> selectAttractionInfoList() throws SQLException;
}
