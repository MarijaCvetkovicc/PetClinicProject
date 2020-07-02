package com.petclinic.second.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petclinic.second.demo.entity.Veterinarian;

public interface VetRepository  extends JpaRepository<Veterinarian, Long>{

	Veterinarian findByUsername(String username);
}
