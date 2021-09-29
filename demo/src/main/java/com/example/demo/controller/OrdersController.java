package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.OrderRespository;
import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.service.OrderServiceDao;

@Controller
public class OrdersController {

	@Autowired
	OrderRespository orderRespository;

	@Autowired
	OrderServiceDao orderService;

	@RequestMapping(value = { "/neworder" }, method = RequestMethod.GET)
	public String newOrder(ModelMap model) {
		Order order = new Order();
		model.addAttribute("order", order);
		model.addAttribute("edit", false);

		return "newOrder";
	}

	@RequestMapping(value = { "/neworder" }, method = RequestMethod.POST)
	public String saveOrder(@ModelAttribute("order")Order order, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "newOrder";
		}

		orderRespository.save(order);
		model.addAttribute("orders", orderRespository.findAll());

		return "ordersList";
	}

	@RequestMapping(value = { "/orderList" }, method = RequestMethod.GET)
	public String viewOrdersList(Model model) {

		model.addAttribute("orders", orderRespository.findAll());

		return "ordersList";
	}

	@RequestMapping(value = { "/delete-order-{id}" }, method = RequestMethod.GET)
	public String deleteOrder(@PathVariable int id) {
		orderRespository.deleteById(id);
		return "redirect:/orderList";
	}

	@RequestMapping(value = { "/edit-order-{id}" }, method = RequestMethod.GET)
	public String editOrder(@PathVariable int id, ModelMap model) {
		Order order = orderRespository.getById(id);
		model.addAttribute("order", order);
		model.addAttribute("edit", true);

		return "newOrder";
	}

	@RequestMapping(value = { "/edit-order-{id}" }, method = RequestMethod.POST)
	public String updateOrder(Order order, BindingResult result, ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			return "newOrder";
		}

		order.setClient(order.getClient());
		order.setAddress(order.getAddress());
		order.setClientPhone(order.getClientPhone());
		order.setProduct(order.getProduct());
		order.setProductCategory(order.getProductCategory());
		order.setWeight(order.getWeight());
		order.setCost(order.getCost());
		order.setPaymentMethod(order.getPaymentMethod());
		order.setDescription(order.getDescription());
		order.setStatus(order.getStatus());

		orderRespository.save(order);
		model.addAttribute("orders", orderRespository.findAll());

		return "ordersList";
	}
	
	@RequestMapping(value = { "/complete-order-{id}" }, method = RequestMethod.GET)
	public String completeOrder(@PathVariable int id) {

		Order order = orderService.completeOrder(id);

		orderRespository.save(order);

		return "redirect:/flight";
	}
	
	
	

}
