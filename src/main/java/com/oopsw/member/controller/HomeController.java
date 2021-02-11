package com.oopsw.member.controller;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oopsw.member.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//�α���������
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		logger.info("���������� ����");
		return "login";
	}
	
	//�α��� ó��
	@RequestMapping(value = "/loginAction", method = RequestMethod.POST)
	public String loginAction(HttpServletRequest request,Model model){
		String loginOK = memberService.login(request.getParameter("id"), request.getParameter("pw"));
		if(loginOK !=null){
			HttpSession session=request.getSession(true);			
			session.setAttribute("loginOK", loginOK);
			//model.addAttribute("loginOK", loginOK); 		
			return "studentInfo";
		}
		return "redirect:/login";
	}
	
	//�α׾ƿ�
	@RequestMapping(value = "/logoutAction", method = RequestMethod.POST)
	public String logoutAction() {
		
		
		return "login";
	}
	
	
	//�л�����������
	@RequestMapping(value = "/studentInfo", method = RequestMethod.POST)
	public String studentInfo() {
		
		
		return "studentInfo";
	}

	
}
