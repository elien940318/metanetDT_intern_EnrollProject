package com.oopsw.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HandlerInterceptor implements org.springframework.web.servlet.HandlerInterceptor{
		// controller로 보내기 전에 처리하는 인터셉터
		// 반환이 false라면 controller로 요청을 안함
		// 매개변수 Object는 핸들러 정보를 의미한다. ( RequestMapping , DefaultServletHandler ) 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("studentId") != null){
			return true;
		}
		
		response.sendRedirect("/");
		return false;
	}
}
