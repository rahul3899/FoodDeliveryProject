package com.orderservice.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.java.model.OrderBook;

@Repository
public interface OrderRepository extends JpaRepository<OrderBook, Integer> {
	
	List<OrderBook> findByUsername(String username);

}
