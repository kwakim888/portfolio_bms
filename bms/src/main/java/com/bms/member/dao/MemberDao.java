package com.bms.member.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.bms.member.dto.MemberDto;

public interface MemberDao {
	
	public MemberDto login(Map<String,String> loginMap) throws DataAccessException;
	public void insertNewMember(MemberDto memberDTO) throws DataAccessException;
	public String selectOverlappedID(String id) throws DataAccessException;

}
