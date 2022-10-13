package com.siva.expensetrackerapi.entity;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserModel {
	
	@NotBlank(message="Name should not be empty !")
	private String name;
	
	@NotNull(message="Name should not be empty !")
	@Email(message = "Enter valid email !")
	private String email;
	
	@NotNull(message="Name should not be empty !")
	@Size(min=5,message="Password should contain atleast 5 characters")
	private String password;
	
	private Long age = 0L;
	
}
