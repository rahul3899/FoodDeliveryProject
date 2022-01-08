package com.accountservice.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accountservice.java.client.UserClient;
import com.accountservice.java.dto.PaymentDto;
import com.accountservice.java.model.Payment;
import com.accountservice.java.service.PaymentService;


import java.util.List;

@RestController
public class PaymentController {
	
	
	
	protected final static Logger logger = LoggerFactory.getLogger(PaymentController.class);

	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	UserClient client;
	
	@PostMapping("/payments")
	public ResponseEntity<Boolean> orderAccepted(@RequestBody PaymentDto paymentDto) {
		
		Boolean response= paymentService.savePayment(paymentDto);
		logger.info("Saving Payment Info");
		return new ResponseEntity<Boolean>(response,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/payments/{username}")
	public ResponseEntity<Long> getUserBalance(@PathVariable String username ){
		logger.info("Getting Balance for username "+username);
		return client.getUserBalance(username);
		
	}
	
	
	@GetMapping("/payments/username/{username}")
	public ResponseEntity<List<Payment>> allPayments(@PathVariable String username) {
		
		List<Payment> response= paymentService.findAllPayment(username);
		logger.info("Getting all payment details for user "+username);
		return new ResponseEntity<List<Payment>>(response,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping(value = "/payments/username/{username}/sd/{startDate}/ed/{endDate}")
	public ResponseEntity<List<Payment>> paymentHistory(@PathVariable("username") String username,@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate){
		List<Payment> result= (List<Payment>) paymentService.getByusername(username, startDate, endDate);
		
		return new ResponseEntity<List<Payment>>(result,HttpStatus.ACCEPTED); 
	}
}
