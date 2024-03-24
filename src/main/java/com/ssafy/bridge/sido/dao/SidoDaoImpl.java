package com.ssafy.bridge.sido.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.bridge.sido.dto.response.SidoResponse;
import com.ssafy.bridge.util.DBUtil;

public class SidoDaoImpl implements SidoDao{
	
	private static SidoDao sidoDao;
	private DBUtil dbUtil;
	private SidoDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	public static SidoDao getInstance() {
		if ( sidoDao == null ) {
			sidoDao = new SidoDaoImpl();
		}
		return sidoDao;
	}

	@Override
	public List<SidoResponse> selectSidoList() throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select *		");
		sql.append("  from sidodao	");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		try(con;pstmt){
			List<SidoResponse> list = new ArrayList<>();
			ResultSet rs =  pstmt.executeQuery();
			while ( rs.next() ) {
				list.add(new SidoResponse(
						rs.getInt("code"),
						rs.getString("name")
						));
			}
			return list;
		}
	}
	
}
