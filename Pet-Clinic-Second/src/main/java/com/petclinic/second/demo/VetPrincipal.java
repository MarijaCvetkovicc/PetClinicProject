package com.petclinic.second.demo;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.petclinic.second.demo.entity.Veterinarian;

public class VetPrincipal implements UserDetails{

	
	private Veterinarian vet;
	
	public VetPrincipal(Veterinarian vet) {
		super();
		this.vet = vet;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return vet.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return vet.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
