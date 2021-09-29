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
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "client")
	private String client;

	@Column(name = "address")
	private String address;

	@Column(name = "client_phone")
	private String clientPhone;

	@Column(name = "product")
	private String product;

	@Column(name = "productCategory")
	private String productCategory;

	@Column(name = "weight")
	private double weight;

	@Column(name = "cost")
	private double cost;

	
	@Column(name = "payment_method")
	private String paymentMethod;

	@Column(name = "description")
	private String description;

	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "flight", nullable = true)
	private Flight flight;

}
