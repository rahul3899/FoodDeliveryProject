package com.menuservice.java.service;

import java.util.List;

import com.menuservice.java.model.HotelMenu;

public interface MenuService {

	Long getAmount(Integer id);

	List<HotelMenu> findall();

}