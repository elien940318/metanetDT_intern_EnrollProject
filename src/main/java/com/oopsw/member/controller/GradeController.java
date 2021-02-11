package com.oopsw.member.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oopsw.member.dto.GradeDTO;
import com.oopsw.member.service.GradeService;

@Controller
public class GradeController {

	@Autowired
	private GradeService gradeService;
	
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	
	@RequestMapping(value = "/evaluationList", method = RequestMethod.POST)
	public String evaluationList(HttpServletRequest request){
		// �й�, �̹��⵵, �̹��б� �����ֱ�.
		Collection<GradeDTO> loginData = gradeService.getEvalList(request.getParameter("id"), 2020, new String("1"));
		
		return "evaluationList";
	}
	@RequestMapping(value = "/evaluationDetail", method = RequestMethod.POST)
	public String evaluationDetail(HttpServletRequest request){ 
		// ���ǿ� registerNo set���ֱ�.
		
		
		return "evaluationDetail";
	}
	/*@RequestMapping(value = "/evaluationDetailAction", method = RequestMethod.POST)
	public String evaluationDetailAction(HttpServletRequest request){
		// if ( üũ ��� �� ������?) {
		//HttpSession session = request.getSession(true);
	
		gradeService.setEvalList(40003);
		
		return "evaluationList";
	}	*/
	
}
