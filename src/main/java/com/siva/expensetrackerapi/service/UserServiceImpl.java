package com.siva.expensetrackerapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siva.expensetrackerapi.entity.User;
import com.siva.expensetrackerapi.entity.UserModel;
import com.siva.expensetrackerapi.exceptions.ItemAlreadyExistsException;
import com.siva.expensetrackerapi.exceptions.ResourceNotFoundException;
import com.siva.expensetrackerapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(UserModel user) {
		if(userRepository.existsByEmail(user.getEmail()))
			throw new ItemAlreadyExistsException("User Already Registered With This Email");
		User newUser = new User();
		BeanUtils.copyProperties(user, newUser);
		
		return userRepository.save(newUser);		
	}

	@Override
	public User readUser(Long id) {
		return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User does not exists with this id : "+id));	
	}

	@Override
	public User updateUser(UserModel user, Long id) {
		User existingUser = readUser(id);
		existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
		existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
		existingUser.setPassword(user.getPassword() != null ? user.getPassword() : existingUser.getPassword());
		existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());
		return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser(Long id) {
		User existingUser = readUser(id);
		userRepository.delete(existingUser);
	}

}
