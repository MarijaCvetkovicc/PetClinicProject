package com.petclinic.second.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petclinic.second.demo.entity.Treatment;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

}
