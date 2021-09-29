package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Order;

@Service
public interface OrderServiceDao {
	
	List<Order> findByFlightId(int id);
	
	Order completeOrder(int id);
	
	
	
	

}
