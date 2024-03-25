package com.ssafy.bridge.attraction.info.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.bridge.attraction.info.dao.AttractionInfoDao;
import com.ssafy.bridge.attraction.info.dao.AttractionInfoDaoImpl;
import com.ssafy.bridge.attraction.info.dto.response.AttractionInfoResponse;

public class AttractionInfoServiceImpl implements AttractionInfoService {
	private static AttractionInfoService attractionInfoService;
	private AttractionInfoDao attractionInfoDao;
	private AttractionInfoServiceImpl() {
		attractionInfoDao = AttractionInfoDaoImpl.getInstance();
	}
	public static AttractionInfoService getInstance() {
		if ( attractionInfoService == null ) {
			attractionInfoService = new AttractionInfoServiceImpl();
		}
		return attractionInfoService;
	}
	@Override
	public AttractionInfoResponse searchAttractionInfo(int contentId) throws SQLException {
		return attractionInfoDao.selectAttractionInfo(contentId);
	}
	
	@Override
	public List<AttractionInfoResponse> displayFreeBoardList() throws SQLException {
		return attractionInfoDao.selectAttractionInfoList();
	}
}
