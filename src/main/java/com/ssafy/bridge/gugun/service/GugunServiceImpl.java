package com.ssafy.bridge.gugun.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.bridge.gugun.dao.GugunDao;
import com.ssafy.bridge.gugun.dao.GugunDaoImpl;
import com.ssafy.bridge.gugun.dto.response.GugunResponse;

public class GugunServiceImpl implements GugunService {

	private static GugunService gugunService;
	private GugunDao gugunDao;
	private GugunServiceImpl() {
		gugunDao = GugunDaoImpl.getInstance();
	}
	public static GugunService getInstance() {
		if ( gugunService == null ) {
			gugunService = new GugunServiceImpl();
		}
		return gugunService;
	}
	
	@Override
	public List<GugunResponse> displayGugunList() throws SQLException {
		return gugunDao.selectGugunList();
	}
	
}
