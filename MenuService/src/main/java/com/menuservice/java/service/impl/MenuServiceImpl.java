package com.menuservice.java.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menuservice.java.model.HotelMenu;
import com.menuservice.java.repository.MenuRepository;
import com.menuservice.java.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {


	@Autowired
	MenuRepository  menuRepository;


	@Override
	public Long getAmount(Integer id) {
		Optional<HotelMenu> savedMenu=menuRepository.findById(id);
		if(savedMenu.isPresent()) {
			return menuRepository.getById(id).getPrice();
		}
		throw new RuntimeException("Item by that ID is not present");
	}


	@Override
	public List<HotelMenu> findall() {
		
		return menuRepository.findAll();
	}
	
	@Override
	public Long findByName(String name) {
		HotelMenu hotelMenu=menuRepository.findByNameContains(name);
		return hotelMenu.getPrice();
	}
}
