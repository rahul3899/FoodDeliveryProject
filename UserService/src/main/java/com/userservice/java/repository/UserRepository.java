package com.userservice.java.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userservice.java.model.UserCustomer;




@Repository
public interface UserRepository extends JpaRepository<UserCustomer, Integer>{
	
	Optional<UserCustomer> findByUsername(String username);

}
