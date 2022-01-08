package com.orderservice.java.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class OrderDto {
	
	private Integer orderId;
	@NotNull
	private String username;
	
	List<MenuList>menuLists;
	
	
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
	public List<MenuList> getMenuLists() {
		return menuLists;
	}
	public void setMenuLists(List<MenuList> menuLists) {
		this.menuLists = menuLists;
	}
	
	
	
	

}
