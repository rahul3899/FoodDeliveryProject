package com.orderservice.java.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderservice.java.client.MenuClient;
import com.orderservice.java.client.Paymentclient;
import com.orderservice.java.dto.MenuList;
import com.orderservice.java.dto.OrderDto;
import com.orderservice.java.dto.PaymentDto;
import com.orderservice.java.exception.CustomerNotFoundException;
import com.orderservice.java.model.OrderBook;
import com.orderservice.java.repository.OrderRepository;
import com.orderservice.java.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	MenuClient menuClient;
	
	@Autowired
	Paymentclient paymentclient;
	
	@Autowired
	OrderRepository orderRepository;
	


	@Override
	public String placeOrder(OrderDto orderDto) {
		List<MenuList> list=orderDto.getMenuLists();
		Long amount =0L;
		Integer totalQuantity=0;
		for(MenuList menuList:list) {
			int id=menuList.getMenuId();
			int quantity=menuList.getQuantity();
			totalQuantity+=quantity;
			amount+=(menuClient.getAmount(id).getBody()*quantity);
			
		}
		
		PaymentDto paymentDto=new PaymentDto();
		paymentDto.setAmount(amount);
		paymentDto.setUsername(orderDto.getUsername());
		paymentDto.setOrderId(orderDto.getOrderId());
		
		if(paymentclient.orderAccepted(paymentDto).getBody()) {
		OrderBook orderBook=new OrderBook();
		orderBook.setLocalDate(LocalDate.now());
		orderBook.setLocalTime(LocalTime.now());
		BeanUtils.copyProperties(orderDto, orderBook);
		orderBook.setQuantity(totalQuantity);
		orderBook.setTotalAmount(amount);
			
			orderRepository.save(orderBook);
			return "Order Placed";
		}
		throw new CustomerNotFoundException("Low Balance");
	}



	@Override
	public List<OrderBook> getAllOrder(String username) {
		return orderRepository.findByUsername(username);
		
	}
	
	
}
