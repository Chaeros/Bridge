package com.ssafy.bridge.gugun.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.bridge.gugun.dto.response.GugunResponse;

public interface GugunDao {
	/*
	 * insert : 추가
	 * update : 수정
	 * delete : 삭제
	 * select : 조회
	 */
	public List<GugunResponse> selectGugunList() throws SQLException;
}
