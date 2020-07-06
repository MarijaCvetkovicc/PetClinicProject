package com.petclinic.second.demo.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petclinic.second.demo.entity.Diagnosis;
import com.petclinic.second.demo.entity.Examination;
import com.petclinic.second.demo.entity.Patient;
import com.petclinic.second.demo.entity.Veterinarian;
import com.petclinic.second.demo.service.DiagnosisService;
import com.petclinic.second.demo.service.ExaminationService;
import com.petclinic.second.demo.service.PatientService;

@Controller
public class ExaminationController {

	@Autowired
	ExaminationService service;
	@Autowired
	DiagnosisService serviceDiagnosis;
	@Autowired
	PatientService servicePatient;
	
	/*@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		 dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}*/
	 @ModelAttribute(name = "allDiagnosis")
	    public List<Diagnosis> allDiagnosis() {
	        return serviceDiagnosis.listAllDiagnosis();
	    }
	 @ModelAttribute(name = "allPatients")
	    public List<Patient> allPatients() {
	        return servicePatient.listAll();
	    }
	
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
	
	@RequestMapping("/new-examination")
	public String newExaminationForm(Map<String, Object> model) {
		Examination examination=new Examination();
		
		model.put("examination", examination);
		return "new_examination.jsp";
	}
	
	@RequestMapping(value="/saveexamination", method = RequestMethod.POST)
	public String saveExamination(@Valid @ModelAttribute("examination") Examination examination,BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			return "new_examination.jsp";
		} try {
		//throw new RuntimeException("System did not save examination");
		service.save(examination);
		 redirectAttributes.addFlashAttribute("message", "Examination is saved");
		
		return "redirect:/examination";
		}catch (Exception e) {
			throw new RuntimeException("System did not save examination");
		}
	}
	@RequestMapping(value="/editexamination", method = RequestMethod.POST)
	public String editExamination(@Valid @ModelAttribute("examination") Examination examination,BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			return "edit_examination.jsp";
		}else {
			try {
			
			//throw new RuntimeException("System did not save examination");
		service.save(examination);
		 redirectAttributes.addFlashAttribute("message", "Examination is saved");
		return "redirect:/examination";
			}catch (Exception e) {
				throw new RuntimeException("System did not save examination");
			}
		}
	}
	@RequestMapping("/edit-examination")
	public ModelAndView editexaminationForm(@RequestParam long id) {
		ModelAndView mav=new ModelAndView("edit_examination.jsp");
		Examination examination=service.get(id);
		mav.addObject("examination",examination);
		
		
		return mav;
	}
	
	 @ExceptionHandler(Exception.class)
		public String exceptionHandler(Exception Exception,RedirectAttributes redirectAttributes) {
			
			System.out.println("====================================================================");
			System.out.println("@ControllerAdvice exception ocured: NullPointerException===========");
			System.out.println("====================================================================");
			
			redirectAttributes.addFlashAttribute("errorMessage", Exception.getMessage());
			redirectAttributes.addFlashAttribute("errorObj", Exception);
			
			return "redirect:/globalException";
		}
	
}
