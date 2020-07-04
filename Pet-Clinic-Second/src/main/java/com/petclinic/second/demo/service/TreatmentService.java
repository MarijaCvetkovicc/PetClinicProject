package com.petclinic.second.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petclinic.second.demo.entity.Treatment;
import com.petclinic.second.demo.repository.TreatmentRepository;

@Service 
public class TreatmentService {

	@Autowired
	TreatmentRepository repo;
	
	
	
	public List<Treatment> listAllTreatments(){
		return repo.findAll();
	}



	public float getPriceFromId(Long id) {
		Optional<Treatment> t=repo.findById(id);
		return t.get().getPrice();
	}
	
	
}
