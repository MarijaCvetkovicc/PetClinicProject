package com.petclinic.second.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.petclinic.second.demo.entity.Examination;
import com.petclinic.second.demo.entity.Patient;
import com.petclinic.second.demo.repository.ExaminationRepository;

@Service
public class ExaminationService {

	@Autowired
	ExaminationRepository repository;
	
	public List<Examination> listAllExamination(){
		return repository.findAll();
	}
	public List<Examination> searchExamination(String keyword){
		return repository.searchExamination(keyword);
	}
	public void save(Examination examination) {
		repository.save(examination);
	}
	public Examination get(long id) {
		Optional<Examination> result= repository.findById(id);
		return result.get();
	}

}
