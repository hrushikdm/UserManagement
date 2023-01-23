package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
/**
 * 
 * @author Hrushikesh Kadam
 *
 */

//user controller class
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/id")
	public Optional<User> getUserById(@RequestParam int id) {
		return userService.getById(id);
	}

	@DeleteMapping("/delByUserId/{id}")  
	private String deleteBook(@PathVariable("id") int id)   
	{  try
	{
	userService.deleteById(id);  
	}
	catch (Exception e) {
	e.printStackTrace();
		
	}
	return "User deleted ............";
	}  

	@GetMapping("/getAll")
	public List<User> getAll() {
		return userService.getAll();
	}

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.save(user);
	}

	@PutMapping("/update")
	private User update(@RequestBody User user) {
		return userService.update(user);

	}
}
