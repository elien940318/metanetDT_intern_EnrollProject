package com.oopsw.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HandlerInterceptor implements org.springframework.web.servlet.HandlerInterceptor{
		// controller�� ������ ���� ó���ϴ� ���ͼ���
		// ��ȯ�� false��� controller�� ��û�� ����
		// �Ű����� Object�� �ڵ鷯 ������ �ǹ��Ѵ�. ( RequestMapping , DefaultServletHandler ) 
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
