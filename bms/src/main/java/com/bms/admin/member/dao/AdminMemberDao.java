package com.bms.admin.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.bms.member.dto.MemberDto;

public interface AdminMemberDao {
	
	public List<MemberDto> listMember(Map<String,Object> condMap) throws DataAccessException;
	public MemberDto memberDetail(String memberId) throws DataAccessException;
	public void modifyMemberInfo(Map<String,String> memberMap) throws DataAccessException;
	
}
