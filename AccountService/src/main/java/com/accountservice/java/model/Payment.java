package com.accountservice.java.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	private Integer orderId;
	private String username;
	private Long amount;
	private LocalDate paymentDate;
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Payment() {
		
	}
	public Payment(Integer paymentId, Integer orderId, String username, Long amount,
			LocalDate paymentDate) {
		
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.username = username;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
	
	
	

}
