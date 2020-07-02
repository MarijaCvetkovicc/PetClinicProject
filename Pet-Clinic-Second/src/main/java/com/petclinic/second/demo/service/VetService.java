package com.petclinic.second.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.petclinic.second.demo.VetPrincipal;
import com.petclinic.second.demo.entity.Patient;
import com.petclinic.second.demo.entity.Veterinarian;
import com.petclinic.second.demo.repository.VetRepository;

@Service
public class VetService implements UserDetailsService {

	@Autowired
	private VetRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Veterinarian vet=repo.findByUsername(username);
		if(vet==null)
			throw new UsernameNotFoundException("We didnt find that user");
		
		return new VetPrincipal(vet);
		
	}
	public List<Veterinarian> listAllVets(){
		return repo.findAll();
	}

}
