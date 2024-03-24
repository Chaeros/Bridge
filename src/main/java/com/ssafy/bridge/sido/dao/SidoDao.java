package com.ssafy.bridge.sido.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.bridge.sido.dto.response.SidoResponse;

public interface SidoDao {
	/*
	 * insert : 추가
	 * update : 수정
	 * delete : 삭제
	 * select : 조회
	 */
//	public int insertSido(FreeBoardAddRequest board) throws SQLException;
//	public int updateSido(FreeBoardModifyRequest board) throws SQLException;
//	public int deleteSido(int no) throws SQLException;
//	public SidoResponse selectByNoSido(int no) throws SQLException;
	public List<SidoResponse> selectSidoList() throws SQLException;
}
