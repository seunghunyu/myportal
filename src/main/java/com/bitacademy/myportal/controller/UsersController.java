package com.bitacademy.myportal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.myportal.exception.UserDaoException;
import com.bitacademy.myportal.service.UserService;
import com.bitacademy.myportal.vo.UserVo;

@Controller
@RequestMapping("/users")
public class UsersController {
   @Autowired
   private UserService userServiceImpl;
   private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
   @RequestMapping(value="/join",method=RequestMethod.GET)
   public String join(@ModelAttribute UserVo vo) {
      return "users/joinform";
   }
   @RequestMapping(value = "/join",method=RequestMethod.POST)
   public String joinAction(@ModelAttribute @Valid UserVo vo, BindingResult result, Model model) {
      // 가입 처리
      logger.debug("회원 가입 액션");
      logger.debug("회원 가입 정보 : " + vo);
      // 오류체크
      if (result.hasErrors()) {
         // 검증 실패
         List<ObjectError> errors = result.getAllErrors();
         for (ObjectError e: errors) {
            logger.error("ERROR : "+ e);
         }
         model.addAllAttributes(result.getModel());
         return "users/joinform";
      }
      // 성공화면 /users/joinsuccess로 리다이렉트
      // 실패화면 /users/join (GET)으로 리다이렉트
//      System.out.println("FROM :"+vo);
      boolean success = false; 
      try {
         success = userServiceImpl.join(vo);
      } catch(UserDaoException e) {
         System.err.println("ERROR VO:" + e.getVo());
         e.printStackTrace();
      }

      if(success)
         return "redirect:/users/joinsuccess";
      else
         return "redirect:/users/join";
   }
   @RequestMapping(value="/joinsuccess")
   public String joinSuccess() {
      return "users/joinsuccess";
   }

   // 로그인 관련
   @RequestMapping(value="/login",method=RequestMethod.GET)
   public String loginform() {
      return "users/loginform";
   }

   @RequestMapping(value="/login",method=RequestMethod.POST)
   public String loginAction(
         @RequestParam(value="email",required=false) String email,
         @RequestParam(value="password",required=false) String password,
         HttpSession session) {
      // email, password가 전송되지 않았을 경우
      // -> /users/login으로 리다이렉트
      if (email.length() == 0 || password.length() ==0) {
         System.err.println("email, password 없음");
         return "redirect:/users/login";
      }
      UserVo authUser = userServiceImpl.getUser(email, password);

      // authUser != null -> 사용자가 있다 -> session에 authUser을 삭제
      if (authUser != null) {
         session.setAttribute("authUser", authUser);
         return "redirect:/";
      } else {
         return "redirect:/users/login";
      }

   }

   // 로그아웃
   @RequestMapping(value = "/logout", method=RequestMethod.GET)
   public String logout(HttpSession session) {
      // 로그인 정보 삭제
      session.removeAttribute("authUser");
      // 세션 무효화
      session.invalidate();

      return "redirect:/";
   }
   // 중복 이메일 체크
   @ResponseBody
   @RequestMapping(value="/emailcheck",method=RequestMethod.GET)
   public Object exists(@RequestParam(value="email",required=true,defaultValue="") String email) {
      UserVo vo = userServiceImpl.getUser(email);
      System.out.println(vo.toString());
      Map<String, Object> map = new HashMap<>();
      map.put("result","success");
      map.put("data",vo != null? "exists":"not exists");
      return map;
      
   }

}
