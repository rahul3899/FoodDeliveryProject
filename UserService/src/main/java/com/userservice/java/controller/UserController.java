package com.userservice.java.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.userservice.java.DTO.UserDto;
import com.userservice.java.model.UserCustomer;
import com.userservice.java.service.UserService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
public class UserController {
	
	
	protected final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userservice;
	
	@Operation(summary = "Register a specific user") 
	@PostMapping("/users")
	public ResponseEntity<String> saveUser(@Valid @RequestBody UserDto userDto){

		String response=userservice.save(userDto);
		logger.info("Saving Customer Details");
		return new ResponseEntity<String>(response,HttpStatus.CREATED);


	}

	@GetMapping("/users")
	public ResponseEntity<List<UserCustomer>> getUser(){
		List<UserCustomer> userCustomers=userservice.findAll();	
		logger.info("Getting all customer details");
		return new  ResponseEntity<List<UserCustomer>>(userCustomers,HttpStatus.OK);

	}


	@DeleteMapping("/users/{username}")
	public ResponseEntity<String> deleteUser(@PathVariable String username ){
		String response=userservice.delete(username);
		logger.info(username+" Info deleted");
		return new ResponseEntity<String>(response,HttpStatus.ACCEPTED);
	}

	@GetMapping("/users/{username}")
	public ResponseEntity<Long> getUserBalance(@PathVariable String username ){
		Long response=userservice.getuser(username);
		logger.info("Getting user "+username+" balance info");
		return new ResponseEntity<Long>(response,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/users/amt/{amount}/username/{username}")
	public ResponseEntity<Boolean> UpdateUserBalance(@PathVariable Long amount,@PathVariable String username ){
		Boolean response=userservice.updateUser(username,amount);
		logger.info("Getting userinfo by month");
		return new ResponseEntity<Boolean>(response,HttpStatus.ACCEPTED);
	}




}
