package com.example.demo.controllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;

import com.userservice.java.DTO.UserDto;
import com.userservice.java.controller.UserController;
import com.userservice.java.model.UserCustomer;
import com.userservice.java.service.UserService;





@ExtendWith(MockitoExtension.class)
class ControllerTest {

	@Mock
	UserService userService;

	@InjectMocks
	UserController userController;

	UserDto userDTO;

	@BeforeEach
	public void setUp(){
		userDTO=new UserDto();
		userDTO.setName("Rahul");
		userDTO.setAddress("MP");
		userDTO.setBalance(1000L);
		userDTO.setContactNumber("1234567890");
		userDTO.setMail("rairahul");
		userDTO.setUsername("Xyz");
		userDTO.setPassword("Xyz");


	}
	
	@Test
	@DisplayName(value = "Save Account:Positive")
	void testSaveAccount() {

		when(userService.save(userDTO)).thenReturn("User date saved");
		ResponseEntity<String> response=userController.saveUser(userDTO);
		assertEquals("User date saved", response.getBody());
		assertEquals(response.getStatusCode(), response.getStatusCode());

	}
	
	@Test
	@DisplayName(value = "Get all User")
	void testSaveAccountNegative() {

		List<UserCustomer> list =new ArrayList<>();
		UserCustomer customer=new UserCustomer();
		BeanUtils.copyProperties(userDTO, customer);
		customer.setUserId(1);
		list.add(customer);
		when(userService.findAll()).thenReturn(list);
		ResponseEntity<List<UserCustomer>> response=userController.getUser();
		
		assertEquals(list, response.getBody());

	}
	@Test
	@DisplayName(value = "Update User Balance")
	void testUpdateUserBalance() {

		
		
		when(userService.updateUser(userDTO.getUsername(),300L)).thenReturn(true);
		ResponseEntity<Boolean> response=userController.UpdateUserBalance(300L, "Xyz");
		
		assertEquals(true, response.getBody());

	}
	@Test
	@DisplayName(value = "Delete User")
	void testDeleteUser() {

		
		
		when(userService.delete(userDTO.getUsername())).thenReturn("Customer Deleted successfully");
		ResponseEntity<String> response=userController.deleteUser( "Xyz");
		
		assertEquals("Customer Deleted successfully", response.getBody());

	}
	
	@Test
	@DisplayName(value = "GEt User Balance")
	void testGetUserBalance() {

		
		
		when(userService.getuser(userDTO.getUsername())).thenReturn(1000L);
		ResponseEntity<Long> response=userController.getUserBalance( "Xyz");
		
		assertEquals(1000L, response.getBody());

	}
	
	

	}
