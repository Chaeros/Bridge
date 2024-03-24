package com.ssafy.bridge.freeboard.service;

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
	
	public void addFreeBoard(FreeBoardAddRequest board);
	public void modifyFreeBoard(FreeBoardModifyRequest board);
	public void removeFreeBoard(int no);
	public FreeBoardResponse searchByNoFreeBoard(int no);
	public List<FreeBoardResponse> displayFreeBoardList();
}
