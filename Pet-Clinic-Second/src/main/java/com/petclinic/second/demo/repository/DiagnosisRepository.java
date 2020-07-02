package com.petclinic.second.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petclinic.second.demo.entity.Diagnosis;

public interface DiagnosisRepository   extends JpaRepository<Diagnosis, Long>{

}
