package com.ssafy.bridge.freeboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ssafy.bridge.freeboard.dto.request.FreeBoardAddRequest;
import com.ssafy.bridge.freeboard.dto.request.FreeBoardModifyRequest;
import com.ssafy.bridge.freeboard.dto.request.FreeBoardRemoveRequest;
import com.ssafy.bridge.freeboard.dto.response.FreeBoardResponse;
import com.ssafy.bridge.util.DBUtil;

public class FreeBoardDaoImpl implements FreeBoardDao {

	private static FreeBoardDao freeBoardDao;
	private DBUtil dbUtil;

	private FreeBoardDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	public static FreeBoardDao getInstance() {
		if (freeBoardDao == null) {
			freeBoardDao = new FreeBoardDaoImpl();
		}
		return freeBoardDao;
	}

	@Override
	public int insertFreeBoard(FreeBoardAddRequest board) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("insert into freeboard		");
		sql.append("(title, content, writer)	");
		sql.append("values ( ?, ?, ? ) 			");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		try (con; pstmt) {
			int index = 0;
			pstmt.setString(++index, board.getTitle());
			pstmt.setString(++index, board.getContent());
			pstmt.setString(++index, board.getWriter());
			return pstmt.executeUpdate();
		}
	}

	@Override
	public int updateFreeBoard(FreeBoardModifyRequest board) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("update freeboard				");
		sql.append("   set title = ? , content = ?	");
		sql.append(" where no = ? and writer = ?		");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		try (con; pstmt) {
			int index = 0;
			pstmt.setString(++index, board.getTitle());
			pstmt.setString(++index, board.getContent());
			pstmt.setInt(++index, board.getNo());
			pstmt.setString(++index, board.getId());
			return pstmt.executeUpdate();
		}
	}

	@Override
	public int deleteFreeBoard(FreeBoardRemoveRequest board) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("delete from freeboard		");
		sql.append(" where no = ? and writer = ?	");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		try (con; pstmt) {
			int index = 0;
			pstmt.setInt(++index, board.getNo());
			pstmt.setString(++index, board.getId());
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

		try (con; pstmt) {
			int index = 0;
			pstmt.setInt(++index, no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new FreeBoardResponse(rs.getInt("no"), rs.getString("title"), rs.getString("content"),
						rs.getString("writer"), rs.getInt("hit"), rs.getString("write_Date"));
			}
			return null;
		}
	}

	@Override
	public List<FreeBoardResponse> selectFreeBoardList(Map<String, Object> map) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select *					");
		sql.append("  from freeboard			");
		sql.append("  order by write_date desc 	");
		sql.append("  limit ?, ? 				");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		try (con; pstmt) {
			List<FreeBoardResponse> list = new ArrayList<>();

			int index = 0;
			pstmt.setInt(++index, (int) map.get("start"));
			pstmt.setInt(++index, (int) map.get("listSize"));

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new FreeBoardResponse(rs.getInt("no"), rs.getString("title"), rs.getString("content"),
						rs.getString("writer"), rs.getInt("hit"), rs.getString("write_Date")));
			}
			return list;
		}
	}

	@Override
	public int getTotlaArticleCount() throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select count(no) cnt	");
		sql.append("  from freeboard		");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		try (con; pstmt) {
			int cnt = 0;
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
			return cnt;
		}
	}
}
