package com.magazine.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magazine.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);		 	 
}
