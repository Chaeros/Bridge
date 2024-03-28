package com.ssafy.bridge.freeboard.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.bridge.freeboard.dao.FreeBoardDao;
import com.ssafy.bridge.freeboard.dao.FreeBoardDaoImpl;
import com.ssafy.bridge.freeboard.dto.request.FreeBoardAddRequest;
import com.ssafy.bridge.freeboard.dto.request.FreeBoardModifyRequest;
import com.ssafy.bridge.freeboard.dto.request.FreeBoardRemoveRequest;
import com.ssafy.bridge.freeboard.dto.response.FreeBoardResponse;
import com.ssafy.bridge.util.BoardSize;
import com.ssafy.bridge.util.PageNavigation;

public class FreeBoardServiceImpl implements FreeBoardService {

	static int pageSize = 10;

	private static FreeBoardService freeBoardService;
	private FreeBoardDao freeBoardDao;

	private FreeBoardServiceImpl() {
		freeBoardDao = FreeBoardDaoImpl.getInstance();
	}

	public static FreeBoardService getInstance() {
		if (freeBoardService == null) {
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
	public int removeFreeBoard(FreeBoardRemoveRequest board) throws SQLException {
		return freeBoardDao.deleteFreeBoard(board);
	}

	@Override
	public FreeBoardResponse searchByNoFreeBoard(int no) throws SQLException {
		return freeBoardDao.selectByNoFreeBoard(no);
	}

	@Override
	public List<FreeBoardResponse> displayFreeBoardList(Map<String, Object> map) throws SQLException {
		int pgno = (int) map.get("pgno");
		int listSize = BoardSize.LIST.getBoardSize();
		int start = (pgno - 1) * listSize;
		map.put("start", start);
		map.put("listSize", listSize);
		return freeBoardDao.selectFreeBoardList(map);
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, Object> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int currentPage = (int) map.get("pgno");
		int naviSize = BoardSize.NAVIGATION.getBoardSize();
		int listSize = BoardSize.LIST.getBoardSize();

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNavSize(naviSize);
		int totalCount = freeBoardDao.getTotlaArticleCount();
		pageNavigation.setTotalPageCount(totalCount);
		int totalPageCount = (totalCount - 1) / listSize + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

}
