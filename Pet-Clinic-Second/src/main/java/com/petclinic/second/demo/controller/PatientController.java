package com.petclinic.second.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petclinic.second.demo.entity.Patient;
import com.petclinic.second.demo.entity.Veterinarian;
import com.petclinic.second.demo.service.PatientService;
import com.petclinic.second.demo.service.VetService;

@Controller
public class PatientController {

	@Autowired
	private PatientService servicePatient;
	
	@Autowired
	private VetService serviceVetenerian;
	
	@RequestMapping("/patient")
	public ModelAndView showPatient() {
		ModelAndView mav=new ModelAndView("patient.jsp");
		List<Patient> listPatient=servicePatient.listAll();
		
		mav.addObject("listPatient",listPatient);
		return mav;
	}
	
	 @ModelAttribute(name = "allVeterinarian")
	    public List<Veterinarian> allVetenerians() {
	        return serviceVetenerian.listAllVets();
	    }

	@RequestMapping("/new")
	public String newPatientForm(Map<String, Object> model) {
		model.put("patient", new Patient());
		return "new_patient.jsp";
	}
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String savePatient(@ModelAttribute("patient") Patient patient) {
		
		servicePatient.save(patient);
		
		return "redirect:/patient";
		
	}
	
	@RequestMapping("/edit-patient")
	public ModelAndView editPatientForm(@RequestParam long id) {
		ModelAndView mav=new ModelAndView("edit_patient.jsp");
		Patient patient=servicePatient.get(id);
		mav.addObject("patient",patient);
		
		
		return mav;
	}
	@RequestMapping("/delete-patient")
	public String deletePatient(@RequestParam long id) {
		servicePatient.delete(id);
		
		return "redirect:/patient";
	}
	
	
}
