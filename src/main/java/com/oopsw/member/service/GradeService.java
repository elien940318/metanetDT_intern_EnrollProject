package com.oopsw.member.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oopsw.member.dao.GradeDAO;
import com.oopsw.member.dto.GradeDTO;

@Service
public class GradeService {

	@Autowired
	private GradeDAO gradeDAO;
	
	public Collection<GradeDTO> getEvalList(String studentId, int regYear,String regSemester) {
		// TODO Auto-generated method stub
		return gradeDAO.getEvalList(studentId, regYear, regSemester);
	}
	
	
	public boolean setEval(int registerNo, int evalHow, int evalPlanning, int evalGoal, int evalConsider, int evalTest) {
		// TODO Auto-generated method stub
		return gradeDAO.setEval(registerNo, evalHow, evalPlanning, evalGoal, evalConsider, evalTest);
	}

		
	
}
