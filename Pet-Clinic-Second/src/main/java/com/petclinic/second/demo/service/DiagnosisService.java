package com.petclinic.second.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petclinic.second.demo.entity.Diagnosis;
import com.petclinic.second.demo.repository.DiagnosisRepository;
@Service
public class DiagnosisService {

	@Autowired
	DiagnosisRepository repo;
	
	public List<Diagnosis> listAllDiagnosis(){
		return repo.findAll();
	}

}
