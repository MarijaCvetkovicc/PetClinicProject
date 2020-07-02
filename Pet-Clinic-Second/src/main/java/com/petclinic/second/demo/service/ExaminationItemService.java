package com.petclinic.second.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.petclinic.second.demo.entity.ExaminationItem;
import com.petclinic.second.demo.repository.ExaminationItemRepository;

@Service
public class ExaminationItemService {


	@Autowired
	ExaminationItemRepository repository;
	
	public List<ExaminationItem> listAllExaminationItems(){
		return repository.findAll();
	}
}
