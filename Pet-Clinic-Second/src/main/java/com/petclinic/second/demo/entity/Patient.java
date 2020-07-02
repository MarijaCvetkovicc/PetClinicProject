package com.petclinic.second.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String petname;
	private String ownername;
	private String number;
	@ManyToOne
	@JoinColumn(name="id_veterinarian ", nullable = false)
	private Veterinarian veterinarian;
	
	
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
