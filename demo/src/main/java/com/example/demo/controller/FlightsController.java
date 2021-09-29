package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.FlightRespository;
import com.example.demo.dao.OrderRespository;
import com.example.demo.dao.UserRespository;
import com.example.demo.model.Flight;
import com.example.demo.model.Order;
import com.example.demo.service.OrderServiceDao;
import com.example.demo.service.UserServiceDao;

@Controller
public class FlightsController {

	@Autowired
	FlightRespository flightRespository;
	@Autowired
	OrderServiceDao orderService;
	@Autowired
	UserRespository userRespository;
	@Autowired
	UserServiceDao userService;
	@Autowired
	OrderRespository orderRepository;

	@RequestMapping(value = { "/addorders-{id}" }, method = RequestMethod.GET)
	public String addOrders(ModelMap model, @PathVariable int id, List<Order> orders) {

		model.addAttribute("flightId", id);
		model.addAttribute("orders", orderRepository.findAll());
		model.addAttribute("edit", false);

		return "addOrders";

	}

	@RequestMapping(value = { "/addorders-{id}" }, method = RequestMethod.POST)
	public String saveOrders(@PathVariable int id, BindingResult result, ModelMap model,
			@ModelAttribute("orders") List<Order> orders) {

		if (result.hasErrors()) {
			return "addOrders";
		}

		orderRepository.saveAll(orders);

		// model.addAttribute("success", "User " + user.getFirstName() + " "+
		// user.getLastName() + " registered successfully");

		// return "success";
		return "flightsList";
	}

	@RequestMapping(value = { "/newflight" }, method = RequestMethod.GET)
	public String newFlight(ModelMap model) {
		Flight flight = new Flight();
		model.addAttribute("flightForm", flight);
		model.addAttribute("drivers", userService.findAllDrivers());
		model.addAttribute("forwarders", userService.findAllForwarders());
		model.addAttribute("edit", false);

		return "newFlight";

	}

	@RequestMapping(value = { "/newflight" }, method = RequestMethod.POST)
	public String saveFlight(Flight flight, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "newFlight";
		}

		flightRespository.save(flight);
		model.addAttribute("flights", flightRespository.findAll());

		// model.addAttribute("success", "User " + user.getFirstName() + " "+
		// user.getLastName() + " registered successfully");

		// return "success";
		return "flightsList";
	}

	@RequestMapping(value = { "/flightList" }, method = RequestMethod.GET)
	public String viewFlightList(Model model) {

		model.addAttribute("flights", flightRespository.findAll());

		return "flightsList";
	}

	@RequestMapping(value = { "/delete-flight-{id}" }, method = RequestMethod.GET)
	public String deleteFlight(@PathVariable int id) {
		flightRespository.deleteById(id);
		return "redirect:/flightList";
	}

	@RequestMapping(value = { "/edit-flight-{id}" }, method = RequestMethod.GET)
	public String editFlight(@PathVariable int id, ModelMap model) {
		Flight flight = flightRespository.getById(id);
		model.addAttribute("flight", flight);
		model.addAttribute("edit", true);

		return "newFlight";
	}

	@RequestMapping(value = { "/edit-flight-{id}" }, method = RequestMethod.POST)
	public String updateFlight(Flight flight, BindingResult result, ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			return "newFlight";
		}

		flight.setDriver(flight.getDriver());
		flight.setForwarder(flight.getForwarder());
		flight.setDate(flight.getDate());

		flightRespository.save(flight);

		return "flightsList";
	}

	@RequestMapping(value = { "/flight-{id}" }, method = RequestMethod.GET)
	public String viewFlight(ModelMap model, @PathVariable int id) {

		model.addAttribute("flight", flightRespository.findById(id));
		model.addAttribute("orders", orderService.findByFlightId(id));

		return "flight";
	}

	@RequestMapping(value = { "/add-orders-{id}" }, method = RequestMethod.GET)
	public String addOrders(@PathVariable int id, ModelMap model, HttpServletRequest req) {
	
		model.addAttribute("flightId", id);
		model.addAttribute("orders", orderRepository.findAll());
		model.addAttribute("edit", true);
		req.getParameter("orders");
		return "addOrders";
	}

//	@RequestMapping(value = { "/add-orders-{id}" }, method = RequestMethod.POST)
//	public String addOrders(BindingResult result, ModelMap model, @PathVariable int id, HttpServletRequest req) {
//		
//		if (result.hasErrors()) {
//			return "addOrders";
//		}
//		String [] orders =req.getParameterValues("orders[]");
//		for (Order order: orders) {
//			order.getFlight().setId(id);
//			
//		}
//		orderRepository.saveAll(orders);
//		flightRespository.findAll();
//		
//		
//
//		return "flightsList";
//	}
	
	
	
	@RequestMapping(value = { "/complete-flight-{id}" }, method = RequestMethod.GET)
	public String comleteFlight(@PathVariable int id, ModelMap model) {
	
		return null;
	}

}
