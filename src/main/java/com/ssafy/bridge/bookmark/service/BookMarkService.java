package com.ssafy.bridge.bookmark.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.bridge.bookmark.dto.response.BookMarkResponse;

public interface BookMarkService {
	/*
	 * add : 추가
	 * modify : 수정
	 * remove : 삭제
	 * search : 검색
	 * display : 출력
	 */
	
	public int addBookMark(int contentId, String memberId) throws SQLException;
	public int removeBookMark(int attractionId) throws SQLException;
	public List<BookMarkResponse> displayBookMarkList(String memberId) throws SQLException;
}