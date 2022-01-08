package com.orderservice.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orderservice.java.dto.OrderDto;
import com.orderservice.java.model.OrderBook;

@Service
public interface OrderService {

	String placeOrder(OrderDto orderDto);

	List<OrderBook> getAllOrder(String username);

}
