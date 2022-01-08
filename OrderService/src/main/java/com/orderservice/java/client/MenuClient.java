package com.orderservice.java.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("Menu-Service")
public interface MenuClient {

	@GetMapping("/menus/{id}")
	public ResponseEntity<Long> getAmount(@PathVariable Integer id);
	
}
