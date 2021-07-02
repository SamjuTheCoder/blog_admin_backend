package com.magazine.backend.service;

import com.magazine.backend.model.User;

public interface UserService {
  
	public User findUserByEmail(String email);
 
	public void saveUser(User user);
}
