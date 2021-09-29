package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.RoleRespository;
import com.example.demo.dao.UserRespository;

import com.example.demo.model.User;


@Service("UserServiceDao")
@Transactional
public class UserServiceDaoImpl implements UserServiceDao {

	@Autowired
	private UserRespository userRespository;
	
	@Autowired
    private RoleRespository roleRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
	 public void save(User user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        userRespository.save(user);
	}

	@Override
	public User activateUser(int id) {
		User entity = userRespository.getById(id);
		if(entity!=null){
			entity.setStatus("Active");
		}
		return entity;
	}

	@Override
	public List<User> findAllDrivers() {
		List<User> allUsers= userRespository.findAll();
		List<User> drivers = new ArrayList<>();
		for (User user : allUsers) {
			int c = user.getRole().getId();
			if(c == 2) {
				drivers.add(user);
			}
		}
		return drivers;
	}

	@Override
	public List<User> findAllForwarders() {
		List<User> allUsers= userRespository.findAll();
		List<User> forwarders = new ArrayList<>();
		for (User user : allUsers) {
			int c = user.getRole().getId();
			if(c == 3) {
				forwarders.add(user);
			}
		}
		return forwarders;
	}

	@Override
	public List<User> findAllControllers() {
		List<User> allUsers= userRespository.findAll();
		List<User> controllers = new ArrayList<>();
		for (User user : allUsers) {
			int c = user.getRole().getId();
			if(c == 4) {
				controllers.add(user);
			}
		}
		return controllers;
	}

	
}
