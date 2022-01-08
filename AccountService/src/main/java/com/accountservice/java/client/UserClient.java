package com.accountservice.java.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient("USER-SERVICE")
public interface UserClient {
	
	@GetMapping("/users/{username}")
	public ResponseEntity<Long> getUserBalance(@PathVariable String username );
	
	@PutMapping("/users/amt/{amount}/username/{username}")
	public ResponseEntity<Boolean> UpdateUserBalance(@PathVariable Long amount,@PathVariable String username );

}
