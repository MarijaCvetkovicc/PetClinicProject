package com.petclinic.second.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petclinic.second.demo.entity.ExaminationItem;

public interface ExaminationItemRepository  extends JpaRepository<ExaminationItem, Long>{

}
