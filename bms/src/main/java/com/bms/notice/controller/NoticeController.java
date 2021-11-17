package com.bms.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bms.member.dto.MemberDto;
import com.bms.notice.dto.NoticeDto;
import com.bms.notice.service.NoticeService;

@Controller
@RequestMapping(value="/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/noticeList.do")
	public String noticeList(Model model, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto)session.getAttribute("memberInfo");
		String memberId = member.getMemberId(); 	
		
		model.addAttribute("memberId" , memberId);
		model.addAttribute("noticeList" , noticeService.getAllNotice());
		
		return "/notice/noticeList";
	}
	
	@RequestMapping(value="/noticeWrite.do" , method=RequestMethod.GET)
	public String noticeWrite() throws Exception {
		return "/notice/noticeWrite";
	}
	
	@RequestMapping(value="/noticeWrite.do" , method=RequestMethod.POST)
	public String noticeWrite(NoticeDto ndto) throws Exception {
		noticeService.insertNotice(ndto);
		return "redirect:/notice/noticeList.do";
	}
	
	@RequestMapping(value="/noticeInfo.do" , method=RequestMethod.GET)
	public String noticeInfo(@RequestParam("noticeNum") int noticeNum , Model model, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto)session.getAttribute("memberInfo");
		String memberId = member.getMemberId(); 	
		
		model.addAttribute("memberId" , memberId);
		
		model.addAttribute("ndto" , noticeService.getOneNotice(noticeNum));
		
		return "/notice/noticeInfo";
	}
	
	@RequestMapping(value="/noticeUpdate.do" , method=RequestMethod.GET)
	public String noticeUpdate(@RequestParam("noticeNum") int noticeNum , Model model) throws Exception {
		
		model.addAttribute("ndto" , noticeService.getOneNotice(noticeNum));
		
		return "/notice/noticeUpdate";
	}
	
	@RequestMapping(value="/noticeUpdate.do" , method=RequestMethod.POST)
	public ResponseEntity<Object> noticeUpdate(HttpServletRequest request , NoticeDto ndto , Model model) throws Exception {
		
		String message = "";
		
		if (noticeService.noticeUpdate(ndto)) {
			message = "<script>";
			message += "alert('업데이트를 완료했습니다.');";
			message += "location.href='" + request.getContextPath() + "/notice/noticeList.do';";
			message += "</script>";
		}
		else {
			message = "<script>";
			message += "alert('비밀번호를 확인해주세요');";
			message += "history.back(-1);";
			message += "</script>";
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message , responseHeaders , HttpStatus.OK);
	}
	
	@RequestMapping(value="/noticeDelete.do" , method=RequestMethod.GET)
	public String noticeDelete(@RequestParam("noticeNum") int noticeNum , Model model) throws Exception {
		
		model.addAttribute("ndto" , noticeService.getOneNotice(noticeNum));
		
		return "/notice/noticeDelete";
	}
	
	@RequestMapping(value="/noticeDelete.do" , method=RequestMethod.POST)
	public ResponseEntity<Object> noticeDelete(HttpServletRequest request , NoticeDto ndto , Model model) throws Exception {
		
		String message = "";
		
		if (noticeService.noticeDelete(ndto)) {
			message = "<script>";
			message += "alert('삭제를 완료했습니다.');";
			message += "location.href='" + request.getContextPath() + "/notice/noticeList.do';";
			message += "</script>";
		}
		else {
			message = "<script>";
			message += "alert('비밀번호를 확인해주세요');";
			message += "history.back(-1);";
			message += "</script>";
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message , responseHeaders , HttpStatus.OK);
	}
	
}
