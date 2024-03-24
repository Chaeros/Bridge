package com.ssafy.bridge.member.dao;

import java.sql.SQLException;

import com.ssafy.bridge.member.dto.request.MemberAddRequest;
import com.ssafy.bridge.member.dto.request.MemberDeleteRequest;
import com.ssafy.bridge.member.dto.request.MemberLoginRequest;
import com.ssafy.bridge.member.dto.request.MemberModifyRequest;
import com.ssafy.bridge.member.dto.response.MemberLoginResponse;
import com.ssafy.bridge.member.dto.response.MemberResponse;

public interface MemberDao {
	/*
	 * insert : 추가 update : 수정 delete : 삭제 select : 조회
	 */

	int insertMember(MemberAddRequest member) throws SQLException;

	MemberResponse selectMember(String id) throws SQLException;
	
	boolean isDuplicateByNickName(String nickName) throws SQLException;

	MemberLoginResponse loginMember(MemberLoginRequest member) throws SQLException;

	int updateMember(MemberModifyRequest member) throws SQLException;

	int deleteMember(MemberDeleteRequest member) throws SQLException;
}
