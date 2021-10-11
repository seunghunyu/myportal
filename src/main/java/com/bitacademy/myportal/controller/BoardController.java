package com.bitacademy.myportal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal.service.BoardService;
import com.bitacademy.myportal.vo.BoardVo;
import com.bitacademy.myportal.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {
   @Autowired
   private BoardService boardServiceImpl;
   //리스트 페이지
   @RequestMapping({"","/","/list"})
   public String list(Model model)
   {
      //게시물 목록 받아오기
      List<BoardVo> list = boardServiceImpl.getList();
      model.addAttribute("list",list);
      System.out.println("Board list:"+list);
      return "board/list";
   }
   
   //   작성 폼
   @RequestMapping(value="/write",method=RequestMethod.GET)
   public String writeform()
   {
      return "board/write";
   }
   
   //   게시물 작성
   //로그인사용자인지 작성자인지
   @RequestMapping(value="/write", method=RequestMethod.POST)
   public String write(@ModelAttribute BoardVo boardVo, HttpSession session)
   {	
      //만약에 세션에 authUser라고 설정된 UserVo가 없다면 
      // -> 로그인 하지않은 상태이므로 -> 로그인폼으로 리다이렉트 해줘야함
      UserVo authUser = (UserVo)session.getAttribute("authUser");
      if (authUser == null)
      {
         System.err.println("로그인 사용자 아님!");
         return "redirect:/users/login";
      }
      else {
	      boardVo.setUserNo(authUser.getNo());
	      boolean success = boardServiceImpl.write(boardVo);
	      System.out.println("글쓰기 성공유무:"+success);
	     
      }
      return "redirect:/board/list";
      
   }
   
}