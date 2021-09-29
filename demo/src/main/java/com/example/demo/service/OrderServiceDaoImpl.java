package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.OrderRespository;
import com.example.demo.model.Order;


@Service("OrderServiceDao")
@Transactional
public class OrderServiceDaoImpl implements OrderServiceDao{
	
	@Autowired
	OrderRespository orderRespository;

	@Override
	public List<Order> findByFlightId(int id) {
		List<Order> orders= orderRespository.findAll();
		List<Order> flightOrders = new ArrayList<>();
		
		for (Order order : orders) {
			try {
				int c = order.getFlight().getId();
			if(c == id) {
				flightOrders.add(order);
			}
			} catch (NullPointerException e) {
			
			}
						
		}
		return flightOrders;
	}

	@Override
	public Order completeOrder(int id) {
		Order entity = orderRespository.getById(id);
		if(entity!=null){
			entity.setStatus("Completed");
		}
		return entity;
	}

	

}
