package com.ssafy.bridge.attraction.info.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.bridge.attraction.info.dto.response.AttractionInfoResponse;
import com.ssafy.bridge.util.DBUtil;

public class AttractionInfoDaoImpl implements AttractionInfoDao {
	
	private static AttractionInfoDao attractionInfoDao;
	private DBUtil dbUtil;
	private AttractionInfoDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	public static AttractionInfoDao getInstance() {
		if ( attractionInfoDao == null ) {
			attractionInfoDao = new AttractionInfoDaoImpl();
		}
		return attractionInfoDao;
	}
	
	@Override
	public List<AttractionInfoResponse> selectAttractionInfoList() throws SQLException {
		return attractionInfoDao.selectAttractionInfoList();
	}
}
