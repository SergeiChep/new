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

import com.example.demo.dao.CarRespository;
import com.example.demo.dao.RoleRespository;
import com.example.demo.dao.UserRespository;
import com.example.demo.model.User;
import com.example.demo.service.SecurityService;
import com.example.demo.service.UserServiceDao;
import com.example.demo.validator.UserValidator;

@Controller
public class UsersController {

	@Autowired
	RoleRespository roleRespository;
	
	@Autowired
	CarRespository carRespository;
	
	@Autowired
	UserRespository userRespository;

	@Autowired
	UserServiceDao userService;
	
	@Autowired
    private SecurityService securityService;
@Autowired
    private UserValidator userValidator;


@RequestMapping(value = {"/registration","/newuser"}, method = RequestMethod.GET)
public String registration(Model model) {
    model.addAttribute("userForm", new User());
    model.addAttribute("roles", roleRespository.findAll());
    model.addAttribute("cars", carRespository.findAll());
return "registration";
}
@RequestMapping(value = {"/registration","/newuser"}, method = RequestMethod.POST)
public String registration(@ModelAttribute("userForm") User userForm, 
 BindingResult bindingResult, Model model) {
    userValidator.validate(userForm, bindingResult);
if (bindingResult.hasErrors()) {
        return "registration";
    }
userService.save(userForm);
securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
return "registrationsuccess";
}

//	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
//	public String newUser(ModelMap model) {
//		model.addAttribute("userForm", new User());
//
//		return "registration";
//	}
//
//	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
//	public String saveUser(User user, BindingResult result, ModelMap model) {
//
//		if (result.hasErrors()) {
//			return "registration";
//		}
//
//		userRespository.save(user);
//
//		model.addAttribute("success",
//				"User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
//
//		// return "success";
//		return "registrationsuccess";
//	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");
		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		return "login";
		
	}
	
	
	
	
	@RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "index";
    }


	@RequestMapping(value = { "/userList" }, method = RequestMethod.GET)
	public String viewUserList(Model model) {

		model.addAttribute("users", userRespository.findAll());

		return "usersList";
	}
	
	@RequestMapping(value = { "/driverList" }, method = RequestMethod.GET)
	public String viewDriverList(Model model) {

		model.addAttribute("users", userService.findAllDrivers());

		return "usersList";
	}
	
	@RequestMapping(value = { "/forwarderList" }, method = RequestMethod.GET)
	public String viewForwarderList(Model model) {

		model.addAttribute("users", userService.findAllForwarders());

		return "usersList";
	}
	
	@RequestMapping(value = { "/controllerList" }, method = RequestMethod.GET)
	public String viewControllerList(Model model) {

		model.addAttribute("users", userService.findAllControllers());

		return "usersList";
	}

	@RequestMapping(value = { "/delete-user-{id}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id) {
		userRespository.deleteById(id);
		return "redirect:/userList";
	}

	@RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable int id, ModelMap model) {
		User user = userRespository.getById(id);
		model.addAttribute("userForm", user);
		model.addAttribute("edit", true);
		 model.addAttribute("roles", roleRespository.findAll());
		 model.addAttribute("cars", carRespository.findAll());


		return "registration";
	}

	@RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.POST)
	public String updateUser(User user, BindingResult result, ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			return "registration";
		}

		user.setUsername(user.getUsername());
		user.setFirstName(user.getFirstName());
		user.setLastName(user.getLastName());
		user.setPhone(user.getPhone());
		user.setRole(user.getRole());
		user.setCar(user.getCar());

		userService.save(user);

		model.addAttribute("success",
				"User " + user.getFirstName() + " " + user.getLastName() + " updated successfully");

		return "registrationsuccess";
	}

	@RequestMapping(value = { "/activate-user-{id}" }, method = RequestMethod.GET)
	public String activateUser(@PathVariable int id) {

		User user = userService.activateUser(id);

		userRespository.save(user);

		return "redirect:/userList";
	}
}
