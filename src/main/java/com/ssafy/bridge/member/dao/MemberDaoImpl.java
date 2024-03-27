package com.ssafy.bridge.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.bridge.member.dto.request.MemberAddRequest;
import com.ssafy.bridge.member.dto.request.MemberDeleteRequest;
import com.ssafy.bridge.member.dto.request.MemberLoginRequest;
import com.ssafy.bridge.member.dto.request.MemberModifyRequest;
import com.ssafy.bridge.member.dto.response.MemberLoginResponse;
import com.ssafy.bridge.member.dto.response.MemberResponse;
import com.ssafy.bridge.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	private static MemberDao memberDao;
	private DBUtil dbUtil;

	private MemberDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	public static MemberDao getInstance() {
		if (memberDao == null) {
			memberDao = new MemberDaoImpl();
		}
		return memberDao;
	}

	@Override
	public int insertMember(MemberAddRequest member) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("	insert into member								");
		sql.append("	(id, password, name, nick_name, region, email) 	");
		sql.append("	values ( ?, ?, ?, ?, ?, ? ) 					");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		try (con; pstmt) {
			int index = 0;
			pstmt.setString(++index, member.getId());
			pstmt.setString(++index, member.getPassword());
			pstmt.setString(++index, member.getName());
			pstmt.setString(++index, member.getNickName());
			pstmt.setString(++index, member.getRegion());
			pstmt.setString(++index, member.getEmail());
			return pstmt.executeUpdate();
		}
	}

	@Override
	public MemberResponse selectMember(String id) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select *			");
		sql.append("	from member 	");
		sql.append("	where id = ? 	");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		try (con; pstmt) {
			int index = 0;
			pstmt.setString(++index, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new MemberResponse(rs.getString("id"), rs.getString("password"), rs.getString("name"),
						rs.getString("nick_name"), rs.getString("region"), rs.getString("email"));
			}
		}
		return null;
	}

	@Override
	public boolean isDuplicateByNickName(String nickName) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select nick_name		");
		sql.append("	from member			");
		sql.append(" where nick_name = ?	");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		try (con; pstmt) {
			int index = 0;
			pstmt.setString(++index, nickName);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;
		}
	}

	@Override
	public MemberLoginResponse loginMember(MemberLoginRequest member) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select * 							");
		sql.append("	from member						");
		sql.append("	where id = ? and password = ? 	");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		try (con; pstmt) {
			int index = 0;
			pstmt.setString(++index, member.getId());
			pstmt.setString(++index, member.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new MemberLoginResponse(rs.getString("id"), rs.getString("name"), rs.getString("nick_name"),
						rs.getString("region"), rs.getString("email"));
			}
		}
		return null;
	}

	@Override
	public int updateMember(MemberModifyRequest member) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("update member 											");
		sql.append(" 	set name = ?, nick_name = ?, region = ?, email = ? 	");
		sql.append("	where id = ? and password = ? 						");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		try (con; pstmt) {
			int index = 0;
			pstmt.setString(++index, member.getName());
			pstmt.setString(++index, member.getNickName());
			pstmt.setString(++index, member.getRegion());
			pstmt.setString(++index, member.getEmail());
			return pstmt.executeUpdate();
		}
	}

	@Override
	public int deleteMember(MemberDeleteRequest member) throws SQLException {
		Connection con = dbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("delete from member 				");
		sql.append(" where id = ? and password = ? 	");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		try (con; pstmt) {
			int index = 0;
			pstmt.setString(++index, member.getId());
			pstmt.setString(++index, member.getPassword());
			return pstmt.executeUpdate();
		}
	}

}
