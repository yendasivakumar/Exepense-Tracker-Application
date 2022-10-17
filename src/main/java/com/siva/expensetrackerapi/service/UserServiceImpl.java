package com.siva.expensetrackerapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
	private PasswordEncoder bcryptPasswordEncoder;

	@Override
	public User createUser(UserModel user) {
		if(userRepository.existsByEmail(user.getEmail()))
			throw new ItemAlreadyExistsException("User Already Registered With This Email");
		User newUser = new User();
		BeanUtils.copyProperties(user, newUser);
		newUser.setPassword(bcryptPasswordEncoder.encode(newUser.getPassword()));
		
		return userRepository.save(newUser);		
	}

	@Override
	public User readUser() {
		Long id = getLoggedInUser().getId();
		return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User does not exists with this id : "+id));	
	}

	@Override
	public User updateUser(UserModel user) {
		User existingUser = readUser();
		existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
		existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
		existingUser.setPassword(user.getPassword() != null ? bcryptPasswordEncoder.encode(user.getPassword()) : existingUser.getPassword());
		existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());
		return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser() {
		User existingUser = readUser();
		userRepository.delete(existingUser);
	}

	@Override
	public User getLoggedInUser() {
		Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found for the email "+email));
	}

}
