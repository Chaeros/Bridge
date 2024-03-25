package com.ssafy.bridge.attraction.info.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.bridge.attraction.info.dto.response.AttractionInfoResponse;
import com.ssafy.bridge.freeboard.dto.response.FreeBoardResponse;
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
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select *				");
		sql.append("  from attractionInfo	");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		try(con;pstmt){
			List<AttractionInfoResponse> list = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while ( rs.next() ) {
				list.add(new AttractionInfoResponse(
						rs.getInt("content_id"),
						rs.getInt("content_type_id"),
						rs.getString("title"),
						rs.getString("addr1"),
						rs.getString("addr2"),
						rs.getString("zipcode"),
						rs.getString("tel"),
						rs.getString("first_image"),
						rs.getString("first_image2"),
						rs.getInt("readCount"),
						rs.getInt("sido_code"),
						rs.getInt("gugun_code"),
						rs.getDouble("latitude"),
						rs.getDouble("longitude"),
						rs.getString("mlevel")));
			}
			return list;
		}
	}
	
	@Override
	public AttractionInfoResponse selectAttractionInfo(int contentId) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select *			");
		sql.append("  from attractionInfo	");
		sql.append(" where content_id = ?		");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		try(con;pstmt){
			int index = 0;
			pstmt.setInt(++index, contentId);
			ResultSet rs = pstmt.executeQuery();
			if ( rs.next() ) {
				return (new AttractionInfoResponse(
						rs.getInt("content_id"),
						rs.getInt("content_type_id"),
						rs.getString("title"),
						rs.getString("addr1"),
						rs.getString("addr2"),
						rs.getString("zipcode"),
						rs.getString("tel"),
						rs.getString("first_image"),
						rs.getString("first_image2"),
						rs.getInt("readCount"),
						rs.getInt("sido_code"),
						rs.getInt("gugun_code"),
						rs.getDouble("latitude"),
						rs.getDouble("longitude"),
						rs.getString("mlevel")));
			}
			return null;
		}
	}
}
