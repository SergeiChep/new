package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.FlightRespository;
import com.example.demo.dao.OrderRespository;
import com.example.demo.model.Flight;
import com.example.demo.model.Order;



@Service("FlightServiceDao")
@Transactional
public class FlightServiceDaoImpl implements FlightServiceDao{
	
	@Autowired
	OrderServiceDao orderService;
	@Autowired
	private FlightRespository flightRespository;

	@Override
	public Flight completeFlight(int id) {
		Flight flight= flightRespository.getById(id);
		List<Order> orders = orderService.findByFlightId(id);
		
		
		return flight;
	
	}
}


