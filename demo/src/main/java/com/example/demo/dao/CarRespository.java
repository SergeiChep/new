package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Car;

@Repository
public interface CarRespository extends JpaRepository<Car, Integer> {
	Car findByNumber(String number);
}
