package com.bms.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.notice.dao.NoticeDao;
import com.bms.notice.dto.NoticeDto;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public void insertNotice(NoticeDto ndto) throws Exception {
		noticeDao.insertNotice(ndto);
	}

	@Override
	public NoticeDto getOneNotice(int noticeNum) throws Exception {
		noticeDao.increaseReadCount(noticeNum);
		return noticeDao.getOneNotice(noticeNum);
	}

	@Override
	public boolean noticeUpdate(NoticeDto ndto) throws Exception {
		
		boolean isSuccess = false;
		
		if (noticeDao.validateUserCheck(ndto) != null) {
			noticeDao.updateNotice(ndto);
			isSuccess = true;
		}
		
		return isSuccess;
	}

	@Override
	public boolean noticeDelete(NoticeDto ndto) throws Exception {
		
		boolean isSuccess = false;
		
		if (noticeDao.validateUserCheck(ndto) != null) {
			noticeDao.deleteNotice(ndto);
			isSuccess = true;
		}
		
		return isSuccess;
		
	}

	@Override
	public List<NoticeDto> getAllNotice() throws Exception {
		
		return noticeDao.getAllNotice();
		
	}

}
