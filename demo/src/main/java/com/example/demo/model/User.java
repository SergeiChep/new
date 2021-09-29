package com.example.demo.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "password")
	private String password;
	@Column(name = "password_confirm")
	private String passwordConfirm;
	@Column(name = "phone")
	private String phone;
	@ManyToOne
	@JoinColumn(name = "role", nullable = false)
	private Role role;
	@ManyToOne
	@JoinColumn(name = "car", nullable = true)
	private Car car;
	@Column(name = "status", nullable = true)
	private String status;
	
//	@Transient
//    public String getPasswordConfirm() {
//        return passwordConfirm;
//    }
//public void setPasswordConfirm(String passwordConfirm) {
//        this.passwordConfirm = passwordConfirm;
//    }
	
	
	

}
