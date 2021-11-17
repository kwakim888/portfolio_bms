package com.bms.notice.dao;

import java.util.List;

import com.bms.notice.dto.NoticeDto;

public interface NoticeDao {

	public void insertNotice(NoticeDto ndto) throws Exception;
	public void increaseReadCount(int noticeNum) throws Exception;
	public NoticeDto getOneNotice(int noticeNum) throws Exception;
	public NoticeDto validateUserCheck(NoticeDto ndto) throws Exception;
	public void updateNotice(NoticeDto ndto) throws Exception;
	public void deleteNotice(NoticeDto ndto) throws Exception;
	public List<NoticeDto> getAllNotice() throws Exception;
	
}
