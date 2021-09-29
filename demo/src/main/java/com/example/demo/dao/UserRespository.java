package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRespository extends JpaRepository<User, Integer> {

	User findByLastName(String text);
	User findByUsername(String text);
	
	

}
