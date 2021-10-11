package com.bitacademy.myportal.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(
			HttpServletRequest req, Exception e) {
		// 1. 로깅
		System.err.println("===========");
		System.err.println("ControllerAdvice에 의한 예외처리");
		e.printStackTrace();
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", e.getClass().getSimpleName());
		mav.setViewName("exception/exception");
		
		return mav;
	}
}
