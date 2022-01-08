package com.userservice.java.service;

import java.util.List;



import com.userservice.java.DTO.UserDto;
import com.userservice.java.model.UserCustomer;

public interface UserService {

	String save(UserDto userDto);

	List<UserCustomer> findAll();

	String delete(String username);

	Long getuser(String username);

	Boolean updateUser(String username,Long amount);
	

}
