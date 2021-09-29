package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Flight;


public interface FlightRespository extends JpaRepository<Flight, Integer> {
	
	

}
