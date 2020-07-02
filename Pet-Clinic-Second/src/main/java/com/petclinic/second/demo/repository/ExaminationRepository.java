package com.petclinic.second.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.petclinic.second.demo.entity.Examination;

public interface ExaminationRepository  extends JpaRepository<Examination, Long>{

	@Query(value = "SELECT e from Examination as e inner join e.patient as p where p.petname like '%' || :keyword || '%' "
					+ "OR p.ownername like '%' || :keyword || '%'")
	public List<Examination> searchExamination(@Param("keyword") String keyword);


}
