package com.bitacademy.myportal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



public class CustomInterceptor implements HandlerInterceptor {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);
	//컨트롤러가 호출되기 이전에 먼저 가로채기 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { 
		// 리턴값이 false면 뒤쪽으로 제어를 넘기지 않음 
		// 리턴값이 true면 뒤쪽으로 요청과 응답객체를 넘김 
		// TODO Auto-generated method stub
		logger.info("CustomInterceptor::preHandle");
		return true;
	}
	//컨트롤러 수행 후 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info("CustomInterceptor::postHandle");
	}
	//컨트롤러 수행이후 뷰작업까지 완료된 이후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("CustomInterceptor:afterCompletion");
	}

}
