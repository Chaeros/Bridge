package com.ssafy.bridge.bookmark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.bridge.bookmark.dto.request.BookMarkAddRequest;
import com.ssafy.bridge.bookmark.dto.response.BookMarkResponse;
import com.ssafy.bridge.freeboard.dto.response.FreeBoardResponse;
import com.ssafy.bridge.util.DBUtil;

public class BookMarkDaoImpl implements BookMarkDao {

	private static BookMarkDao bookMarkDao;
	private DBUtil dbUtil;
	private BookMarkDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	public static BookMarkDao getInstance() {
		if ( bookMarkDao == null ) {
			bookMarkDao = new BookMarkDaoImpl();
		}
		return bookMarkDao;
	}
	
	@Override
	public int insertBookMark(BookMarkAddRequest bookMark) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("insert into my_attraction										");
		sql.append("(content_id, content_type_id, title, addr1, addr2, "
				+ "zipcode, tel, first_image, first_image2, readcount, "
				+ "sido_code, gugun_code, latitude, longitude, mlevel, "
				+ "description, member_id)											");
		sql.append("values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		try(con;pstmt){
			int index = 0;
			pstmt.setInt(++index, bookMark.getContentId());
			pstmt.setInt(++index, bookMark.getContentTypeId());
			pstmt.setString(++index, bookMark.getTitle());
			pstmt.setString(++index, bookMark.getAddr1());
			pstmt.setString(++index, bookMark.getAddr2());
			pstmt.setString(++index, bookMark.getZipcode());
			pstmt.setString(++index, bookMark.getTel());
			pstmt.setString(++index, bookMark.getFirstImage());
			pstmt.setString(++index, bookMark.getFirstImage2());
			pstmt.setInt(++index, bookMark.getReadCount());
			pstmt.setInt(++index, bookMark.getSidoCode());
			pstmt.setInt(++index, bookMark.getGugunCode());
			pstmt.setDouble(++index, bookMark.getLatitude());
			pstmt.setDouble(++index, bookMark.getLongitude());
			pstmt.setString(++index, bookMark.getMlevel());
			pstmt.setString(++index, bookMark.getDescription());
			pstmt.setString(++index, bookMark.getMemberId());
			return pstmt.executeUpdate();
		}
	}

	@Override
	public int deleteBookMark(int myAttractionId) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("delete from my_attraction		");
		sql.append(" where my_attraction_id = ?		");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		try (con; pstmt) {
			int index = 0;
			pstmt.setInt(++index, myAttractionId);
			return pstmt.executeUpdate();
		}
	}

	@Override
	public BookMarkResponse selectByNoBookMark(int no) throws SQLException {
		return null;
	}

	@Override
	public List<BookMarkResponse> selectBookMarkList(String memberId) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select *					");
		sql.append("  from my_attraction		");
		sql.append(" where member_id = ?		");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		try (con; pstmt) {
			int index = 0;
			pstmt.setString(++index, memberId);
			ResultSet rs = pstmt.executeQuery();
			List<BookMarkResponse> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new BookMarkResponse(
						rs.getInt("my_attraction_id"),
						rs.getInt("content_id"),
						rs.getInt("content_type_id"),
						rs.getString("title"),
						rs.getString("addr1"),
						rs.getString("addr2"),
						rs.getString("zipcode"),
						rs.getString("tel"),
						rs.getString("firstImage"),
						rs.getString("firstImage2"),
						rs.getInt("readcount"),
						rs.getInt("sido_code"),
						rs.getInt("gugun_code"),
						rs.getDouble("latitude"),
						rs.getDouble("longitude"),
						rs.getString("mlevel"),
						rs.getString("description"),
						rs.getString("member_id")
						));
			}
			return list;
		}
	}

}
