package com.ssafy.bridge.member;

import java.sql.SQLException;

import com.ssafy.bridge.member.dto.request.MemberAddRequest;
import com.ssafy.bridge.member.dto.request.MemberDeleteRequest;
import com.ssafy.bridge.member.dto.request.MemberLoginRequest;
import com.ssafy.bridge.member.dto.request.MemberModifyRequest;
import com.ssafy.bridge.member.dto.response.MemberLoginResponse;
import com.ssafy.bridge.member.dto.response.MemberResponse;

public interface MemberService {
	/*
	 * add : 추가
	 * modify : 수정
	 * remove : 삭제
	 * search : 검색
	 * display : 출력
	 * is : 검증
	 * login: 로그인
	 */
	
	int addMember(MemberAddRequest member) throws SQLException;

	MemberResponse searchMember(String id) throws SQLException;
	
	boolean isDuplicateByNickName(String nickName) throws SQLException;

	MemberLoginResponse loginMember(MemberLoginRequest member) throws SQLException;

	int modifyMember(MemberModifyRequest member) throws Exception;

	int removeMember(MemberDeleteRequest member) throws SQLException;
	
}