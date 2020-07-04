package com.petclinic.second.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petclinic.second.demo.entity.Examination;
import com.petclinic.second.demo.entity.ExaminationItem;
import com.petclinic.second.demo.entity.Patient;
import com.petclinic.second.demo.repository.ExaminationItemRepository;

@Service
public class ExaminationItemService {


	@Autowired
	ExaminationItemRepository repository;
	
	public List<ExaminationItem> listAllExaminationItems(Examination examination){
	
		
		List<ExaminationItem> allItems= repository.findAll();
		List<ExaminationItem> result=new ArrayList<>();
		for (ExaminationItem examinationItem : allItems) {
			if(examinationItem.getExamination().equals(examination)) {
				result.add(examinationItem);
			}
		}
		return result;
		
	}
	public void delete(long id) {
		repository.deleteById(id);
	}
	
	public void save(ExaminationItem examinationItem) {
		repository.save(examinationItem);
	
	}
	
	public ExaminationItem get(long id) {
		Optional<ExaminationItem> result= repository.findById(id);
		return result.get();
	}
	public float updateTotalCost(List<ExaminationItem> listExaminationItems) {
		float toatalCost=0;
		for (ExaminationItem examinationItem : listExaminationItems) {
			 toatalCost= toatalCost+(examinationItem.getAmount()*examinationItem.getTreatment().getPrice());
		}
		return toatalCost;
	}
	public Examination getExaminationBack(ExaminationItem item) {
		Examination examination=item.getExamination();
		return examination;
	}
	
}
