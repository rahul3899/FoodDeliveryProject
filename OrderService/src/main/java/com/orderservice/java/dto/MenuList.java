package com.orderservice.java.dto;

import javax.validation.constraints.NotNull;

public class MenuList {
	@NotNull
	private Integer menuId;
	@NotNull
	private Integer quantity;
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

}
