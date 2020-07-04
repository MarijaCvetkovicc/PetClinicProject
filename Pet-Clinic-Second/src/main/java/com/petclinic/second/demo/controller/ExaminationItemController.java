package com.petclinic.second.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petclinic.second.demo.entity.Diagnosis;
import com.petclinic.second.demo.entity.Examination;
import com.petclinic.second.demo.entity.ExaminationItem;
import com.petclinic.second.demo.entity.Treatment;
import com.petclinic.second.demo.service.ExaminationItemService;
import com.petclinic.second.demo.service.ExaminationService;
import com.petclinic.second.demo.service.TreatmentService;

@Controller
public class ExaminationItemController {

	@Autowired
	ExaminationItemService service;
	@Autowired
	ExaminationService examinationService;
	@Autowired
	TreatmentService treatmentService;
	
	
	@ModelAttribute(name = "allTreatments")
    public List<Treatment> allTreatments() {
        return treatmentService.listAllTreatments();
    }
	/*@RequestMapping("/view-items-examination")
	public ModelAndView showExaminationsItems(@RequestParam long id) {
		//System.out.println(id);
		ModelAndView mav=new ModelAndView("examination_items.jsp");
		Examination examination=examinationService.get(id);
		//System.out.println(examination.getId());
		List<ExaminationItem> listExaminationItems=service.listAllExaminationItems(examination);
		
		mav.addObject("listExaminationItems",listExaminationItems);
		
		return mav;
	}*/
	
	@RequestMapping("/view-items-examination")
	public String showExaminationsItems(@RequestParam long id,Model model) {
		//System.out.println(id);
		
		
		Examination examination=examinationService.get(id);
		//System.out.println(examination.getId());
		List<ExaminationItem> listExaminationItems=service.listAllExaminationItems(examination);
		model.addAttribute("listExaminationItems",listExaminationItems);
		model.addAttribute("examination", examination);
		
		return "examination_items.jsp";
	}
	
	@RequestMapping("/delete-examinationitem")
	public String deleteExaminationItem(@RequestParam long id) {
		
		ExaminationItem item=service.get(id);
		Examination examination=service.getExaminationBack(item);
		service.delete(id);
		
		
		System.out.println(examination.getId());
		List<ExaminationItem> listExaminationItems=service.listAllExaminationItems(examination);
		float totalcost= service.updateTotalCost(listExaminationItems);
		examination.setTotalcost(totalcost);
		
		examinationService.save(examination);
		
		
		return "redirect:/examination";
	}
	
	@RequestMapping("/new-examinationitem")
	public String newExaminationItemForm(@RequestParam long idExamination,Map<String, Object> model) {
		ExaminationItem item=new ExaminationItem();
		Examination examination=examinationService.get(idExamination);
		item.setExamination(examination);
		model.put("examinationitem", item);
		return "new_item.jsp";
	}
	@RequestMapping(value="/saveitem", method = RequestMethod.POST)
	public String saveItem(@ModelAttribute("examinationitem") ExaminationItem examinationItem) {
		
		
		
		service.save(examinationItem);
		
		Examination examination=examinationService.get(examinationItem.getExamination().getId());
		
		//System.out.println(examination.getId());
		//System.out.println(examination.getDiagnosis().getId());
		List<ExaminationItem> listExaminationItems=service.listAllExaminationItems(examination);
		//System.out.println(listExaminationItems.size());
		//System.out.println("Printam listu:");
		
		
		float totalcost= service.updateTotalCost(listExaminationItems)+((treatmentService.getPriceFromId(examinationItem.getTreatment().getId()))*examinationItem.getAmount());
		//System.out.println(totalcost);
		examination.setTotalcost(totalcost);
	
		//System.out.println("Totalna cena pre pamcenja"+examination.getId()+" "+examination.getTotalcost());
		examinationService.save(examination);
		
		return "redirect:/examination";
		
	}
	@RequestMapping("/edit-examinationitem")
	public String editExaminationItemForm(@RequestParam long id,Map<String, Object> model) {
		
	
		ExaminationItem examinationItem=service.get(id);
		model.put("examinationitem", examinationItem);
		return "edit_item.jsp";
	}
	@RequestMapping(value="/edititem", method = RequestMethod.POST)
	public String editItem(@ModelAttribute("examinationitem") ExaminationItem examinationItem) {
		
		
		
		service.save(examinationItem);
		
		Examination examination=examinationService.get(examinationItem.getExamination().getId());
		
		//System.out.println(examination.getId());
		//System.out.println(examination.getDiagnosis().getId());
		List<ExaminationItem> listExaminationItems=service.listAllExaminationItems(examination);
		//System.out.println(listExaminationItems.size());
		//System.out.println("Printam listu:");
		
		
		float totalcost= service.updateTotalCost(listExaminationItems);
		//System.out.println(totalcost);
		examination.setTotalcost(totalcost);
	
		//System.out.println("Totalna cena pre pamcenja"+examination.getId()+" "+examination.getTotalcost());
		examinationService.save(examination);
		
		return "redirect:/examination";
		
	}
	
}
