package com.petclinic.second.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petclinic.second.demo.entity.Examination;
import com.petclinic.second.demo.service.ExaminationService;

@Controller
public class ExaminationController {

	@Autowired
	ExaminationService service;
	
	@RequestMapping("/examination")
	public ModelAndView showExaminations() {
		ModelAndView mav=new ModelAndView("examination.jsp");
		List<Examination> listExamination=service.listAllExamination();
		
		mav.addObject("listExamination",listExamination);
		return mav;
	}
	
	@RequestMapping("/search")
	public ModelAndView searchExamination(@RequestParam String keyword) {
		ModelAndView mav =new ModelAndView("examination_search.jsp");
		List<Examination> listSearchExam=service.searchExamination(keyword);
		mav.addObject("listSearchExam", listSearchExam);
		return mav;
	}
	
}
