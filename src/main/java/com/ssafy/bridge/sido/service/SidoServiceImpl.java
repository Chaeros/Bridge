package com.ssafy.bridge.sido.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.bridge.sido.dao.SidoDao;
import com.ssafy.bridge.sido.dao.SidoDaoImpl;
import com.ssafy.bridge.sido.dto.response.SidoResponse;

public class SidoServiceImpl implements SidoService {

	private static SidoService sidoService;
	private SidoDao sidoDao;
	private SidoServiceImpl() {
		sidoDao = SidoDaoImpl.getInstance();
	}
	public static SidoService getInstance() {
		if ( sidoService == null ) {
			sidoService = new SidoServiceImpl();
		}
		return sidoService;
	}
	
	@Override
	public List<SidoResponse> displaySidoList() throws SQLException {
		return sidoDao.selectSidoList();
	}

}
