package com.siva.expensetrackerapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siva.expensetrackerapi.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	 public Boolean existsByEmail(String email);
	 
	 Optional<User> findByEmail(String email);
}
