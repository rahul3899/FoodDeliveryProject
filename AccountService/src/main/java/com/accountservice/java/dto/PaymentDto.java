package com.accountservice.java.dto;

import javax.validation.constraints.NotNull;

public class PaymentDto {
	@NotNull
	private Integer orderId;
	@NotNull
	private String username;
	@NotNull
	private Long amount;
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
	public PaymentDto(Integer orderId, String username, Long amount) {
		
		this.orderId = orderId;
		this.username = username;
		this.amount = amount;
	}
	public PaymentDto() {
		
	}
	
	
	
}
