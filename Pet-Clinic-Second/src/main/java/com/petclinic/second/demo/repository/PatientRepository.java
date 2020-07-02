package com.petclinic.second.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petclinic.second.demo.entity.Patient;

public interface PatientRepository  extends JpaRepository<Patient, Long> {

}
