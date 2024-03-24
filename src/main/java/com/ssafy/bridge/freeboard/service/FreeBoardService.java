package com.ssafy.bridge.freeboard.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.bridge.freeboard.dto.request.FreeBoardAddRequest;
import com.ssafy.bridge.freeboard.dto.request.FreeBoardModifyRequest;
import com.ssafy.bridge.freeboard.dto.response.FreeBoardResponse;

public interface FreeBoardService {
	/*
	 * add : 추가
	 * modify : 수정
	 * remove : 삭제
	 * search : 검색
	 * display : 출력
	 */
	
	public int addFreeBoard(FreeBoardAddRequest board) throws SQLException;
	public int modifyFreeBoard(FreeBoardModifyRequest board) throws SQLException;
	public int removeFreeBoard(int no) throws SQLException;
	public FreeBoardResponse searchByNoFreeBoard(int no) throws SQLException;
	public List<FreeBoardResponse> displayFreeBoardList() throws SQLException;
}
