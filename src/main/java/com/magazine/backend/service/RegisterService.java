package com.magazine.backend.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.magazine.backend.model.Material;
import com.magazine.backend.model.Register;
import com.magazine.backend.model.Role;
import com.magazine.backend.repository.RegisterRepository;
import com.magazine.backend.repository.RoleRespository;

@Service
public class RegisterService {

	@Autowired
	private RegisterRepository registerRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private RoleRespository roleRespository;
	
	public Register findByUsername(String username)
	{
		return registerRepository.findByUsername(username);
	}
	
	public List<Register> findAll() {
		return (List<Register>) registerRepository.findAll();
	}
	
	public void saveRegister(Register register)
	{
		 register.setPassword(bCryptPasswordEncoder.encode(register.getPassword()));
		 register.setActive(1);
		 Role userRole = roleRespository.findByRole("USER");
		 register.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		  
		 registerRepository.save(register);
	}
	
}
