package com.petclinic.second.demo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String savePatient(@Valid @ModelAttribute("patient") Patient patient , BindingResult bindingResult,  RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			System.out.println("I got here");
			return "new_patient.jsp";
		}else {
			
			 try {
			  // throw new RuntimeException("System did not saved patient");
			   servicePatient.save(patient);
			   redirectAttributes.addFlashAttribute("message", "Patient is saved");
			return "redirect:/patient";
			}catch (Exception e) {
				throw new RuntimeException("System did not saved patient");
			}
		}
	}
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public String editPatient(@Valid @ModelAttribute("patient") Patient patient , BindingResult bindingResult,  RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			System.out.println("I got here");
			return "edit_patient.jsp";
		}else {
			 try {
		//throw new RuntimeException("System did not saved patient");
			
		servicePatient.save(patient);
		 redirectAttributes.addFlashAttribute("message", "Patient is saved");
		return "redirect:/patient";
			 }catch (Exception e) {
					throw new RuntimeException("System did not saved patient");
				}
		}
	}
	@RequestMapping("/edit-patient")
	public ModelAndView editPatientForm(@RequestParam long id) {
		
		ModelAndView mav=new ModelAndView("edit_patient.jsp");
		Patient patient=servicePatient.get(id);
		mav.addObject("patient",patient);
		
		
		return mav;
	}
	@RequestMapping("/delete-patient")
	public String deletePatient(@RequestParam long id,RedirectAttributes redirectAttributes ) {
		 try {
				//throw new RuntimeException("System did not saved patient");
		servicePatient.delete(id);
		
		  redirectAttributes.addFlashAttribute("message", "Patient is deleted");
        return "redirect:/patient";
		 }catch (Exception e) {
				throw new RuntimeException("System did not delete patient");
			}
	
	}
	  @ExceptionHandler(Exception.class)
		public String exceptionHandler(Exception Exception,RedirectAttributes redirectAttributes) {
			
			System.out.println("====================================================================");
			System.out.println("@ControllerAdvice exception ocured:Exception===========");
			System.out.println("====================================================================");
			
			redirectAttributes.addFlashAttribute("errorMessage", Exception.getMessage());
			//redirectAttributes.addFlashAttribute("errorObj", Exception);
			
			return "redirect:/globalException";
		}
	
}
