package com.ssafy.bridge.bookmark.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.bridge.bookmark.dto.request.BookMarkAddRequest;
import com.ssafy.bridge.bookmark.dto.response.BookMarkResponse;
import com.ssafy.bridge.freeboard.dto.request.FreeBoardAddRequest;
import com.ssafy.bridge.freeboard.dto.request.FreeBoardModifyRequest;
import com.ssafy.bridge.freeboard.dto.response.FreeBoardResponse;

public interface BookMarkDao {
	/*
	 * insert : 추가
	 * update : 수정
	 * delete : 삭제
	 * select : 조회
	 */
	public int insertBookMark(BookMarkAddRequest board) throws SQLException;
	public int deleteBookMark(int attractionId) throws SQLException;
	public int deleteByContentIdBookMark(int contentId) throws SQLException;
	public BookMarkResponse selectByNoBookMark(int no) throws SQLException;
	public List<BookMarkResponse> selectBookMarkList(String memberId) throws SQLException;
	public boolean isInBookMark(int contentId) throws SQLException;
}
