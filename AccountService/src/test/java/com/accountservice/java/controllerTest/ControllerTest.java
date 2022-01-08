package com.accountservice.java.controllerTest;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.accountservice.java.client.UserClient;
import com.accountservice.java.controller.PaymentController;
import com.accountservice.java.dto.PaymentDto;
import com.accountservice.java.model.Payment;
import com.accountservice.java.service.PaymentService;









@ExtendWith(MockitoExtension.class)
class ControllerTest {
	
	@Mock
	UserClient userClient;

	@Mock
	PaymentService paymentService;

	@InjectMocks
	PaymentController paymentController;
	
	
	PaymentDto paymentDto;

	@BeforeEach
	public void setUp(){
		paymentDto =new PaymentDto();
		paymentDto.setAmount(100L);
		paymentDto.setOrderId(1);
		paymentDto.setUsername("xyz");

	}
	
	@Test
	@DisplayName(value = "Save Payment")
	void savePayment() {
		

		when(paymentService.savePayment(paymentDto)).thenReturn(true);
		ResponseEntity<Boolean> response=paymentController.orderAccepted(paymentDto);
		assertEquals(true, response.getBody());
		assertEquals(response.getStatusCode(), response.getStatusCode());

	}
	
	@Test
	@DisplayName(value = "All Payments")
	void allPayment() {
		List<Payment> payments=new ArrayList<Payment>();
		Payment payment=new Payment();
		BeanUtils.copyProperties(paymentDto, payment);
		payments.add(payment);

		when(paymentService.findAllPayment("xyz")).thenReturn(payments);
		ResponseEntity<List<Payment>> response=paymentController.allPayments("xyz");
		assertEquals(false, response.getBody().isEmpty());
		assertEquals(response.getStatusCode(), response.getStatusCode());

	}
	
	
	@Test
	@DisplayName(value = "User balance")
	void userbalance() {
		ResponseEntity<Long> balance=new ResponseEntity<Long>(1000L,HttpStatus.ACCEPTED);

		when(userClient.getUserBalance("xyz")).thenReturn(balance);
		ResponseEntity<Long> response=paymentController.getUserBalance("xyz");
		assertEquals(1000L, response.getBody());
		assertEquals(response.getStatusCode(), response.getStatusCode());

	}
	
	
	

	
	
	
	

	}
