package com.magazine.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.magazine.backend.model.Register;

@Repository
public interface RegisterRepository extends CrudRepository<Register, Long> {
	
	Register findByUsername(String username);
	
}
