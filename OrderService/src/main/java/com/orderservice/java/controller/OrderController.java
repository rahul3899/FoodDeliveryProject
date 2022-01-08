package com.orderservice.java.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.java.dto.OrderDto;
import com.orderservice.java.model.OrderBook;
import com.orderservice.java.service.OrderService;


@RestController
public class OrderController {
	
	protected final static Logger logger = LoggerFactory.getLogger(OrderController.class);

	
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("orders")
	public ResponseEntity<String> placeOrder(@RequestBody OrderDto orderDto){
		String response=orderService.placeOrder(orderDto);
		logger.info("Placing Orders");
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
		
	}
	@GetMapping("orders/{username}")
	public ResponseEntity<List<OrderBook>> getAllOrder(@PathVariable String username){
		List<OrderBook> response=orderService.getAllOrder(username);
		logger.info("Getting all order details for username "+username);
		return new ResponseEntity<List<OrderBook>>(response,HttpStatus.CREATED);
		
	}
	
	

}
