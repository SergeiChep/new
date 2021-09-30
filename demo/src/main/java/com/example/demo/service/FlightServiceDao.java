package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Flight;

@Service
public interface FlightServiceDao {
	Flight completeFlight(int id);
	

}
