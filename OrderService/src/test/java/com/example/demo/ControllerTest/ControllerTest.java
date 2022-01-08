package com.example.demo.ControllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;

import com.orderservice.java.controller.OrderController;
import com.orderservice.java.dto.MenuList;
import com.orderservice.java.dto.OrderDto;
import com.orderservice.java.model.OrderBook;
import com.orderservice.java.service.OrderService;







@ExtendWith(MockitoExtension.class)
class ControllerTest {

	@Mock
	OrderService orderService;

	@InjectMocks
	OrderController orderController;

	OrderDto orderDto;

	@BeforeEach
	public void setUp(){
		MenuList menu=new MenuList();
		menu.setMenuId(1);
		menu.setQuantity(1);
		List<MenuList> menuLists=new ArrayList<MenuList>();
		menuLists.add(menu);
		orderDto=new OrderDto();
		orderDto.setMenuLists(menuLists);
		orderDto.setOrderId(1);
		orderDto.setUsername("xyz");
	


	}
	
	@Test
	@DisplayName(value = "Placing order")
	void testPlaceOrder() {
		

		when(orderService.placeOrder(orderDto)).thenReturn("Order Placed");
		ResponseEntity<String> response=orderController.placeOrder(orderDto);
		assertEquals("Order Placed", response.getBody());
		assertEquals(response.getStatusCode(), response.getStatusCode());

	}
	

	@Test
	@DisplayName(value = "Getting all order list of user")
	void getAllOrders() {
		List<OrderBook> orderBooks=new ArrayList<OrderBook>();
		OrderBook orderBook =new OrderBook();
		BeanUtils.copyProperties(orderDto, orderBook);
		orderBook.setLocalDate(LocalDate.now());
		orderBook.setLocalTime(LocalTime.now());
		orderBook.setTotalAmount(100L);
		orderBooks.add(orderBook);
		when(orderService.getAllOrder("xyz")).thenReturn(orderBooks);
		ResponseEntity<List<OrderBook>> response=orderController.getAllOrder("xyz");
		assertEquals(false, response.getBody().isEmpty());
		assertEquals(response.getStatusCode(), response.getStatusCode());

	}
	@Test
	@DisplayName(value = "Getting all order list of user:Negative")
	void getAllOrdersNegative() {
		List<OrderBook> orderBooks=new ArrayList<OrderBook>();
		
		when(orderService.getAllOrder("xyz")).thenReturn(orderBooks);
		
		ResponseEntity<List<OrderBook>> response=orderController.getAllOrder("xyz");
		assertEquals(true, response.getBody().isEmpty());
		assertEquals(response.getStatusCode(), response.getStatusCode());

	}
	
	
	
	

	}
