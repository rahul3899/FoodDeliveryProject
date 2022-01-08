package com.orderservice.java.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.orderservice.java.dto.PaymentDto;



@FeignClient("PAYMENT-SERVICE")
public interface Paymentclient {
	
	
	@PostMapping("/payments")
	public ResponseEntity<Boolean> orderAccepted(@RequestBody PaymentDto paymentDto);
	
	
}
