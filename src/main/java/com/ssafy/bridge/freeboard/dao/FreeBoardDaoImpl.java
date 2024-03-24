package com.ssafy.bridge.freeboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.bridge.freeboard.dto.request.FreeBoardAddRequest;
import com.ssafy.bridge.freeboard.dto.request.FreeBoardModifyRequest;
import com.ssafy.bridge.freeboard.dto.response.FreeBoardResponse;
import com.ssafy.bridge.util.DBUtil;

public class FreeBoardDaoImpl implements FreeBoardDao{

	private static FreeBoardDao freeBoardDao;
	private DBUtil dbUtil;
	private FreeBoardDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	public static FreeBoardDao getInstance() {
		if ( freeBoardDao == null ) {
			freeBoardDao = new FreeBoardDaoImpl();
		}
		return freeBoardDao;
	}
	
	@Override
	public int insertFreeBoard(FreeBoardAddRequest board) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("insert into freeboard		");
		sql.append("(title, content)			");
		sql.append("values ( ?, ? ) 			");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		try(con;pstmt){
			int index = 0;
			pstmt.setString(++index, board.getTitle());
			pstmt.setString(++index, board.getContent());
			return pstmt.executeUpdate();
		}
	}
	
	@Override
	public int updateFreeBoard(FreeBoardModifyRequest board) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("update freeboard				");
		sql.append("   set title = ? , content = ?	");
		sql.append(" where no = ?	 				");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		try(con;pstmt){
			int index = 0;
			pstmt.setString(++index, board.getTitle());
			pstmt.setString(++index, board.getContent());
			pstmt.setInt(++index, board.getNo());
			return pstmt.executeUpdate();
		}
	}
	
	@Override
	public int deleteFreeBoard(int no) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("delete from freeboard		");
		sql.append(" where no = ? 				");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		try(con;pstmt){
			int index = 0;
			pstmt.setInt(++index, no);
			return pstmt.executeUpdate();
		}
	}
	
	@Override
	public FreeBoardResponse selectByNoFreeBoard(int no) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select *			");
		sql.append("  from freeboard	");
		sql.append(" where no = ?		");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		try(con;pstmt){
			int index = 0;
			pstmt.setInt(++index, no);
			ResultSet rs = pstmt.executeQuery();
			if ( rs.next() ) {
				return new FreeBoardResponse(
						rs.getInt("no"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("writer"),
						rs.getInt("hit"),
						rs.getString("writeDate")
						);
			}
			return null;
		}
	}
	@Override
	public List<FreeBoardResponse> selectFreeBoardList() throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select *			");
		sql.append("  from freeboard	");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		try(con;pstmt){
			List<FreeBoardResponse> list = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while ( rs.next() ) {
				list.add(new FreeBoardResponse(
						rs.getInt("no"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("writer"),
						rs.getInt("hit"),
						rs.getString("writeDate")
						));
			}
			return list;
		}
	}


}
