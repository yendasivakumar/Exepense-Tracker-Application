package com.siva.expensetrackerapi.service;

import com.siva.expensetrackerapi.entity.User;
import com.siva.expensetrackerapi.entity.UserModel;

public interface UserService {
	
	public User createUser(UserModel user);
	
	public User readUser(Long id);
	
	public User updateUser(UserModel user,Long id);
	
	public void deleteUser(Long id);
}
