package com.menuservice.java.ControllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;

import com.menuservice.java.cotroller.MenuController;
import com.menuservice.java.model.HotelMenu;
import com.menuservice.java.service.MenuService;








@ExtendWith(MockitoExtension.class)
class ControllerTest {

	@Mock
	MenuService menuService;

	@InjectMocks
	MenuController menuController;
	
	
	List<HotelMenu> hotelMenus;
	

	@BeforeEach
	public void setUp(){
		hotelMenus=new ArrayList<HotelMenu>();
		HotelMenu hotelMenu =new HotelMenu();
		hotelMenu.setMenuId(1);
		hotelMenu.setName("Roti");
		hotelMenu.setPrice(30L);
		hotelMenus.add(hotelMenu);


	}
	
	@Test
	@DisplayName(value = "Menu")
	void menu() {
		

		when(menuService.findall()).thenReturn(hotelMenus);
		ResponseEntity<List<HotelMenu>> response=menuController.getMenu();
		assertEquals(false, response.getBody().isEmpty());
		assertEquals(response.getStatusCode(), response.getStatusCode());

	}
	
	@Test
	@DisplayName(value = "Price")
	void menuAmout() {
		

		when(menuService.getAmount(1)).thenReturn(30L);
		ResponseEntity<Long> response=menuController.getAmount(1);
		assertEquals(30L, response.getBody());
		assertEquals(response.getStatusCode(), response.getStatusCode());

	}
	
	

	
	
	
	

	}
