package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dao.UserRespository;
import com.example.demo.model.User;

import java.util.List;


//@RestController
public class UserRestController {
//
//	@Autowired
//	UserRespository userRespository;
//
//	@GetMapping("/users")
//	public List<User> index() {
//		return userRespository.findAll();
//	}
//
//	@GetMapping("/user/{id}")
//	public User show(@PathVariable String id) {
//		int userId = Integer.parseInt(id);
//		return userRespository.getById(userId);
//	}
//
//	@PostMapping("/user/search")
//	public List<User> search(@RequestBody String body) {
//		return userRespository.findByLastName(body);
//	}
//
//	@PostMapping("/user")
//	public User create(@RequestBody User body) {
//		User user = new User();
//		user = body;
//		return userRespository.save(user);
//	}
//
//	@PostMapping("/add-users")
//	public List<User> createAll(@RequestBody List<User> users) {
//
//		return userRespository.saveAll(users);
//	}
//
//	@PutMapping("/user/{id}")
//	public User update(@PathVariable String id) {
//		int userId = Integer.parseInt(id);
//		// getting user
//		User user = userRespository.getById(userId);
//		
//		return userRespository.save(user);
//	}
//
//	@DeleteMapping("user/{id}")
//	public boolean delete(@PathVariable String id) {
//		int userId = Integer.parseInt(id);
//		userRespository.deleteById(userId);
//		return true;
//	}

}
