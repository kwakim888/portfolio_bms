package com.bms.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bms.notice.dto.NoticeDto;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertNotice(NoticeDto ndto) throws Exception {
		sqlSession.insert("mapper.notice.insertNotice" , ndto);
	}

	@Override
	public void increaseReadCount(int noticeNum) throws Exception {
		sqlSession.update("mapper.notice.increaseReadCount" , noticeNum);
	}

	@Override
	public NoticeDto getOneNotice(int noticeNum) throws Exception {
		return sqlSession.selectOne("mapper.notice.getOneNotice" , noticeNum);
	}

	@Override
	public NoticeDto validateUserCheck(NoticeDto ndto) throws Exception {
		return sqlSession.selectOne("mapper.notice.validateUserCheck" , ndto);
	}

	@Override
	public void updateNotice(NoticeDto ndto) throws Exception {
		sqlSession.update("mapper.notice.updateNotice" , ndto);
	}

	@Override
	public void deleteNotice(NoticeDto ndto) throws Exception {
		sqlSession.delete("mapper.notice.deleteNotice" , ndto);
	}

	@Override
	public List<NoticeDto> getAllNotice() throws Exception {
		return sqlSession.selectList("mapper.notice.getAllNotice");
	}

}
