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
import com.oopsw.member.service.RegisterService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	
	//���ǰ�ȹ�������ȸ ������
	@RequestMapping(value = "/lecturePlan", method = RequestMethod.GET)
	public String lecturePlan() {
		
		
		
		return "lecturePlanList";
	}
	
	//���ǰ�ȹ���󼼳�����ȸ ������
	@RequestMapping(value = "/lecturePlanDetail", method = RequestMethod.GET)
	public String lecturePlanDetail() {
		
		return "lecturePlanDetail";
	}
	
	//������û������
	@RequestMapping(value = "/enrolment", method = RequestMethod.GET)
	public String enrolment() {
		
		//�л����� ��������
		
		//������û ���� ��� ��������
		
		//������û�� ��� ��������
		
		
		return "enrollment";
	}
	
	//������û�ϱ�
	@RequestMapping(value = "/enrolmentAdd", method = RequestMethod.POST)
	public String enrolmentAdd() {

		return "redirect:enrollment";
	}
	
	//������û����ϱ�
	@RequestMapping(value = "/enrolmentDelete", method = RequestMethod.POST)
	public String enrolmentDelete() {
				
		return "redirect:enrollment";
	}
	
	
	
}
