package com.accountservice.java.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accountservice.java.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
	List<Payment> findByPaymentDateAndUsername(LocalDate paymentDate,String username);
	
	List<Payment> findByUsername(String username);

}
