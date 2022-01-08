package com.orderservice.java.model;


import java.time.LocalDate;
import java.time.LocalTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class OrderBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Orderpri;
	
	private Integer orderId;
	private String username;
	private Integer quantity;

	private LocalDate localDate;
	private LocalTime localTime;
	private Long totalAmount;
	
	
	public Integer getOrderpri() {
		return Orderpri;
	}
	public void setOrderpri(Integer orderpri) {
		Orderpri = orderpri;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	
	public Long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	public LocalTime getLocalTime() {
		return localTime;
	}
	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public OrderBook(Integer orderId, String username, Integer quantity, LocalDate localDate,
			LocalTime localTime, Long totalAmount) {
	
		this.orderId = orderId;
		this.username = username;
		this.quantity = quantity;
		this.localDate = localDate;
		this.localTime = localTime;
		this.totalAmount = totalAmount;
	}
	public OrderBook() {
		
	}
	
	
	

	
	
}
