package com.accountservice.java.service;

import java.util.List;

import com.accountservice.java.dto.PaymentDto;
import com.accountservice.java.model.Payment;

public interface PaymentService {
	
	public Boolean savePayment(PaymentDto paymentDto);

	public List<Payment> getByusername(String username, String startDate, String endDate);

	public List<Payment> findAllPayment(String username);

}
