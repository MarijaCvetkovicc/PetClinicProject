package com.petclinic.second.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petclinic.second.demo.entity.Patient;
import com.petclinic.second.demo.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository repo;
	
	public List<Patient> listAll(){
		return repo.findAll();
	}
	
	public void save(Patient patient) {
		repo.save(patient);
	}
	
	public Patient get(long id) {
		Optional<Patient> result= repo.findById(id);
		return result.get();
	}
	public void delete(long id) {
		repo.deleteById(id);
	}
}
