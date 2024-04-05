package com.ssafy.bridge.member;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;

import com.ssafy.bridge.member.dao.MemberDao;
import com.ssafy.bridge.member.dao.MemberDaoImpl;
import com.ssafy.bridge.member.dto.request.MemberAddRequest;
import com.ssafy.bridge.member.dto.request.MemberDeleteRequest;
import com.ssafy.bridge.member.dto.request.MemberLoginRequest;
import com.ssafy.bridge.member.dto.request.MemberModifyRequest;
import com.ssafy.bridge.member.dto.response.MemberLoginResponse;
import com.ssafy.bridge.member.dto.response.MemberResponse;
import com.ssafy.bridge.util.EncryptUtil;

public class MemberServiceImpl implements MemberService {

	private static MemberService memberService;
	private MemberDao memberDao;
	private EncryptUtil encrpytUtil;

	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getInstance();
		encrpytUtil = EncryptUtil.getInstance();
	}

	public static MemberService getInstance() {
		if (memberService == null) {
			memberService = new MemberServiceImpl();
		}
		return memberService;
	}

	@Override
	public int addMember(MemberAddRequest member) throws Exception {
		if (isDuplicateByNickName(member.getNickName()) || isDuplicateById(member.getId())) {
			return -1;
		}
		String salt = encrpytUtil.getSalt();
		member.changePasswordToEncryptHash(encrpytUtil.getEncrypt(member.getPassword(), salt));
		return memberDao.insertMember(member);
	}

	@Override
	public MemberResponse searchMember(String id) throws SQLException {
		return memberDao.selectMember(id);
	}

	@Override
	public boolean isDuplicateByNickName(String nickName) throws SQLException {
		return memberDao.isDuplicateByNickName(nickName);
	}

	@Override
	public Optional<MemberLoginResponse> loginMember(MemberLoginRequest member) throws SQLException {
		Optional<String> hashOptional = memberDao.selectHashById(member.getId());
		if ( !hashOptional.isPresent() ) throw new IllegalArgumentException();
		String salt = hashOptional.get().split("\\.")[0];
		member.changePasswordToEncryptHash(encrpytUtil.getEncrypt(member.getPassword(), salt));
		MemberLoginResponse memberLoginResponse = memberDao.loginMember(member);
		return Optional.ofNullable(memberLoginResponse);
	}

	@Override
	public int modifyMember(MemberModifyRequest member) throws Exception {
		if (isDuplicateByNickName(member.getNickName())) {
			return -1;
		}
		return memberDao.updateMember(member);
	}

	@Override
	public int removeMember(MemberDeleteRequest member) throws SQLException {
		return memberDao.deleteMember(member);
	}

	@Override
	public boolean isDuplicateById(String id) throws Exception {
		return memberDao.isDuplicateById(id);
	}

}
