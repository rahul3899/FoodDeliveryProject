package com.userservice.java.service.impl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.java.DTO.UserDto;
import com.userservice.java.exception.CustomerNotFoundException;
import com.userservice.java.model.UserCustomer;

import com.userservice.java.repository.UserRepository;
import com.userservice.java.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public String save(UserDto userDto) {
		Optional<UserCustomer> userCustomer=repository.findByUsername(userDto.getUsername());
		if(userCustomer.isEmpty()) {
			UserCustomer user=new UserCustomer();


			BeanUtils.copyProperties(userDto, user);
			repository.save(user);
			return "User date saved";
		}
		throw new CustomerNotFoundException("User by that username "+userDto.getUsername()+" already exist");


	}

	@Override
	public List<UserCustomer> findAll() {
		
		return repository.findAll();
	}

	@Override
	public String delete(String username) {

		Optional<UserCustomer> userCustomer =repository.findByUsername(username);
		if(userCustomer.isEmpty())
			throw new CustomerNotFoundException("Customer by this username "+username+" not exist");
		else {
			repository.delete(userCustomer.get());
			return "Customer Deleted successfully";
		}


	}

	@Override
	public Long getuser(String username) {
		Optional<UserCustomer> user=repository.findByUsername(username);
		if(user.isPresent()) {
		
		return repository.findByUsername(username).get().getBalance();
		}
		throw new CustomerNotFoundException("Customer by this username "+username+" not exist");
	}

	@Override
	public Boolean updateUser(String username,Long amount) {
		Optional<UserCustomer> customer=repository.findByUsername(username);
		if(customer.isPresent()) {
			Long updatedAmount=customer.get().getBalance()-amount;
			UserCustomer userCustomer=customer.get();
			repository.delete(userCustomer);
			userCustomer.setBalance(updatedAmount);
			repository.save(userCustomer);
			return true;
		}
		return false;
	}

}
