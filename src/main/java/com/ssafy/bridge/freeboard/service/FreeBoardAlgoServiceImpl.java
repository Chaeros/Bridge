package com.ssafy.bridge.freeboard.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ssafy.bridge.freeboard.dao.FreeBoardDao;
import com.ssafy.bridge.freeboard.dao.FreeBoardDaoImpl;
import com.ssafy.bridge.freeboard.dto.response.FreeBoardResponse;
import com.ssafy.bridge.util.BoardSize;
import com.ssafy.bridge.util.SearchUtil;
import com.ssafy.bridge.util.SortUtil;

public class FreeBoardAlgoServiceImpl {

	static int pageSize = 10;

	private static FreeBoardAlgoServiceImpl freeBoardAlgoService;
	private FreeBoardDao freeBoardDao;
	private SortUtil sortUtil;
	private SearchUtil searchUtil;

	private FreeBoardAlgoServiceImpl() {
		freeBoardDao = FreeBoardDaoImpl.getInstance();
		sortUtil = SortUtil.getInstance();
		searchUtil = SearchUtil.getInstance();
	}

	public static FreeBoardAlgoServiceImpl getInstance() {
		if (freeBoardAlgoService == null) {
			freeBoardAlgoService = new FreeBoardAlgoServiceImpl();
		}
		return freeBoardAlgoService;
	}

	public List<FreeBoardResponse> displayFreeBoardListByHit(Map<String, Object> map) throws SQLException {
		int pgno = (int) map.get("pgno");
		int listSize = BoardSize.LIST.getBoardSize();
		int start = (pgno - 1) * listSize;

		return selectFreeBoardListByHit(start, listSize);
	}

	private List<FreeBoardResponse> selectFreeBoardListByHit(int start, int listSize) throws SQLException {

		List<FreeBoardResponse> list = freeBoardDao.selectFreeBoardList();

		sortUtil.quickSort(list);

		return paging(start, listSize, list);
	}

	private List<FreeBoardResponse> paging(int start, int listSize, List<FreeBoardResponse> list) {
		List<FreeBoardResponse> result = new ArrayList<>();

		for (int i = start; i < Math.min(list.size(), start + listSize); i++) {
			result.add(list.get(i));
		}
		return result;
	}

	public List<FreeBoardResponse> displayFreeBoardListByTitleAndContent(Map<String, Object> map) throws SQLException {
		int pgno = (int) map.get("pgno");
		int listSize = BoardSize.LIST.getBoardSize();
		int start = (pgno - 1) * listSize;
		map.put("start", start);
		map.put("listSize", listSize);

		return selectFreeBoardListByTitleAndContent(map);
	}

	private List<FreeBoardResponse> selectFreeBoardListByTitleAndContent(Map<String, Object> map) throws SQLException {

		List<FreeBoardResponse> list = freeBoardDao.selectFreeBoardList();
		List<FreeBoardResponse> result = new ArrayList<>();

		for (FreeBoardResponse freeBoard : list) {
			if (searchUtil.isEqual(freeBoard.getTitle() + freeBoard.getContent(), (String) map.get("find"))) {
				result.add(freeBoard);
			}
		}
		return paging((int) map.get("start"), (int) map.get("listSize"), result);
	}

}
