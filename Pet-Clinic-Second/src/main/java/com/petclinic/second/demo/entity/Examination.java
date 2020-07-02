package com.petclinic.second.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Examination {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	private Date date;
	 	private float totalcost;
	 	
	 	 @ManyToOne
	     @JoinColumn(name = "id_diagnosis", nullable = false)
	 	private Diagnosis diagnosis;
	 	 @ManyToOne
	     @JoinColumn(name = "id_patient", nullable = false)
	 	private Patient patient;
	 	 
	 	 
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public float getTotalcost() {
			return totalcost;
		}
		public void setTotalcost(float totalcost) {
			this.totalcost = totalcost;
		}
		public Diagnosis getDiagnosis() {
			return diagnosis;
		}
		public void setDiagnosis(Diagnosis diagnosis) {
			this.diagnosis = diagnosis;
		}
		public Patient getPatient() {
			return patient;
		}
		public void setPatient(Patient patient) {
			this.patient = patient;
		}
	 	 
	 	 
	 	
}
