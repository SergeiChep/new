package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public interface UserServiceDao {
	
	
	
	User activateUser(int id);

	void save(User user);
	
	List<User> findAllDrivers();
	List<User> findAllForwarders();
	List<User> findAllControllers();

	

}
