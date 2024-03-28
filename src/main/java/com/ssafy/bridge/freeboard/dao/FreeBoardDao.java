package com.ssafy.bridge.freeboard.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.bridge.freeboard.dto.request.FreeBoardAddRequest;
import com.ssafy.bridge.freeboard.dto.request.FreeBoardModifyRequest;
import com.ssafy.bridge.freeboard.dto.response.FreeBoardResponse;

public interface FreeBoardDao {
	/*
	 * insert : 추가
	 * update : 수정
	 * delete : 삭제
	 * select : 조회
	 */
	public int insertFreeBoard(FreeBoardAddRequest board) throws SQLException;
	public int updateFreeBoard(FreeBoardModifyRequest board) throws SQLException;
	public int deleteFreeBoard(int no) throws SQLException;
	public FreeBoardResponse selectByNoFreeBoard(int no) throws SQLException;
	public List<FreeBoardResponse> selectFreeBoardList(Map<String, Object> map) throws SQLException;
	public int getTotlaArticleCount() throws SQLException;
}
