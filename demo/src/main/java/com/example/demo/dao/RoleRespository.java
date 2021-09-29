package com.example.demo.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Role;



@Repository
public interface RoleRespository extends JpaRepository<Role, Integer>{
	
	

}
