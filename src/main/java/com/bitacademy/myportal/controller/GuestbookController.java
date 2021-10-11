package com.bitacademy.myportal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.myportal.service.GuestbookService;
import com.bitacademy.myportal.vo.GuestbookVo;

//import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	//로거 설정
//	private static final Logger logger=LoggerFactory.getLogger(GuestbookController.class);
	private static final Logger logger=LoggerFactory.getLogger(GuestbookController.class);
	@Autowired
	GuestbookService guestbookServiceImpl;
	
//	@ResponseBody
	@RequestMapping(value={"","/", "/list"},method=RequestMethod.GET)
	public String list(Model model) {
		List<GuestbookVo> list = guestbookServiceImpl.getMessageList();
		logger.debug("Message List:"+list);
		model.addAttribute("list",list);
//		return list.toString();
		return "guestbook/list";
	}
	@RequestMapping(value={"/delete/{no}"},method=RequestMethod.GET)
	public String deleteform(@PathVariable("no")Long no, Model model) {
		model.addAttribute("no",no);
		return "guestbook/deleteform";
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String deleteAction(@ModelAttribute GuestbookVo vo ) {
		System.out.println("FROM:"+vo);
		logger.debug("FORM:"+vo);
		boolean success=guestbookServiceImpl.deleteMessage(vo);
		System.out.println("Delete Result:"+success);
		
		return "redirect:/guestbook";
		
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute GuestbookVo vo) {
		System.out.println("FORM:" + vo);
		logger.debug("FORM:"+vo);
		boolean success=guestbookServiceImpl.writeMessage(vo);
		System.out.println("Write Result:"+success);
		logger.debug("writeResult:"+ success);
		return "redirect:/guestbook";
	}
	
}
