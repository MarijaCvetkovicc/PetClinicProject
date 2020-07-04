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
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Examination other = (Examination) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
	 	 
	 	 
	 	
}
