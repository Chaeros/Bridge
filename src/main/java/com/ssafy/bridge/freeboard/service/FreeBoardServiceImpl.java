package com.ssafy.bridge.freeboard.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.bridge.freeboard.dao.FreeBoardDao;
import com.ssafy.bridge.freeboard.dao.FreeBoardDaoImpl;
import com.ssafy.bridge.freeboard.dto.request.FreeBoardAddRequest;
import com.ssafy.bridge.freeboard.dto.request.FreeBoardModifyRequest;
import com.ssafy.bridge.freeboard.dto.response.FreeBoardResponse;

public class FreeBoardServiceImpl implements FreeBoardService{

	private static FreeBoardService freeBoardService;
	private FreeBoardDao freeBoardDao;
	private FreeBoardServiceImpl() {
		freeBoardDao = FreeBoardDaoImpl.getInstance();
	}
	public static FreeBoardService getInstance() {
		if ( freeBoardService == null ) {
			freeBoardService = new FreeBoardServiceImpl();
		}
		return freeBoardService;
	}
	
	@Override
	public int addFreeBoard(FreeBoardAddRequest board) throws SQLException {
		return freeBoardDao.insertFreeBoard(board);
	}
	@Override
	public int modifyFreeBoard(FreeBoardModifyRequest board) throws SQLException {
		return freeBoardDao.updateFreeBoard(board);
	}
	@Override
	public int removeFreeBoard(int no) throws SQLException {
		return freeBoardDao.deleteFreeBoard(no);
	}
	@Override
	public FreeBoardResponse searchByNoFreeBoard(int no) throws SQLException {
		return freeBoardDao.selectByNoFreeBoard(no);
	}
	@Override
	public List<FreeBoardResponse> displayFreeBoardList() throws SQLException {
		return freeBoardDao.selectFreeBoardList();
	}

}
