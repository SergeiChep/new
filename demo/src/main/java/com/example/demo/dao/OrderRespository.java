package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Order;



@Repository
public interface OrderRespository extends JpaRepository<Order, Integer>{
	
	List<Order> findByClient(String text);
	List<Order> findByFlight(String text);

}
