package com.siva.expensetrackerapi.service;

import com.siva.expensetrackerapi.entity.User;
import com.siva.expensetrackerapi.entity.UserModel;

public interface UserService {
	
	public User createUser(UserModel user);
	
	public User readUser();
	
	public User updateUser(UserModel user);
	
	public void deleteUser();
	
	public User getLoggedInUser();
}
