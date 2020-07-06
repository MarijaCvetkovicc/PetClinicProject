package com.petclinic.second.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank
	private String petname;
	
	
	@NotBlank
	private String ownername;
	
	
	 @Size(min = 9, message = "Name must be greater than 9 numbers")
	private String number;
	
	@ManyToOne
	@JoinColumn(name="id_veterinarian ", nullable = false)
	private Veterinarian veterinarian;
	
	
	
	public Patient() {
		
	}

	public void setVeterinarian(Veterinarian veterinarian) {
		this.veterinarian = veterinarian;
	}
	
	public Veterinarian getVeterinarian() {
		return veterinarian;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
}
