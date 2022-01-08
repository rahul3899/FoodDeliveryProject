package com.menuservice.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotelMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer menuId;
	private String name;
	private Long price;
	
	public HotelMenu() {
		
	}
	public HotelMenu(Integer menuId, String name, Long price) {
	
		this.menuId = menuId;
		this.name = name;
		this.price = price;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	

}
