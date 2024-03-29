package com.ssafy.bridge.gugun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.bridge.gugun.dto.response.GugunResponse;
import com.ssafy.bridge.util.DBUtil;

public class GugunDaoImpl implements GugunDao {

	private static GugunDao gugunDao;
	private DBUtil dbUtil;
	private GugunDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	public static GugunDao getInstance() {
		if ( gugunDao == null ) {
			gugunDao = new GugunDaoImpl();
		}
		return gugunDao;
	}
	
	@Override
	public List<GugunResponse> selectGugunList(int sidoCode) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select *			");
		sql.append("from gugun			");
		sql.append("where sido_code = ?	");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		try(con;pstmt){
			int index = 0;
			pstmt.setInt(++index, sidoCode);
			ResultSet rs = pstmt.executeQuery();
			List<GugunResponse> guguns = new ArrayList<>();
			while ( rs.next() ) {
				guguns.add(new GugunResponse(
						rs.getInt("gugun_code"),
						rs.getString("gugun_name"),
						rs.getInt("sido_code")
						));
			}
			return guguns;
		}
	}

}
