package com.accountservice.java.service.serviceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountservice.java.client.UserClient;
import com.accountservice.java.dto.PaymentDto;
import com.accountservice.java.model.Payment;
import com.accountservice.java.repository.PaymentRepository;
import com.accountservice.java.service.PaymentService;

@Service
public class AccountServiceImpl implements PaymentService {
	
	@Autowired
	UserClient userClient;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	public Boolean savePayment(PaymentDto paymentDto) {
		if(userClient.getUserBalance(paymentDto.getUsername()).getBody()>paymentDto.getAmount()) {
			Payment payment=new Payment();
			BeanUtils.copyProperties(paymentDto, payment);
			payment.setPaymentDate(LocalDate.now());
			userClient.UpdateUserBalance(paymentDto.getAmount(), paymentDto.getUsername());
			paymentRepository.save(payment);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Payment> getByusername(String username, String startDate, String endDate) {
	
		
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy"); 
			LocalDate startDateTime = LocalDate.parse(startDate, formatter);
			LocalDate endDateTime = LocalDate.parse(endDate, formatter);
			/*
			 * System.out.println("I am here"+startDateTime);
			 * System.out.println(LocalDateTime.now()); System.out.println(startDateTime);
			 */
			List<Payment> txn=paymentRepository.findByPaymentDateAndUsername(startDateTime, username);
			return txn;

		
	}

	@Override
	public List<Payment> findAllPayment(String username) {
		
		return paymentRepository.findByUsername(username);
	}

}
