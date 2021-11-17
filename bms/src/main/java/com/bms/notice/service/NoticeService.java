package com.bms.notice.service;

import java.util.List;

import com.bms.notice.dto.NoticeDto;

public interface NoticeService {

	public void insertNotice(NoticeDto ndto) throws Exception;
	public NoticeDto getOneNotice(int noticeNum) throws Exception;
	public boolean noticeUpdate(NoticeDto ndto) throws Exception;
	public boolean noticeDelete(NoticeDto ndto) throws Exception;
	public List<NoticeDto> getAllNotice() throws Exception;
	
}
