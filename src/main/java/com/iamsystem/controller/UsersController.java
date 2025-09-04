package com.iamsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamsystem.domain.Users;
import com.iamsystem.service.UsersService;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	UsersService usersService;

	@PostMapping("/")
	public Users createUser(@RequestBody Users user) {
		return usersService.createUser(user);
	}


	@GetMapping("/")
	public List<Users> getAllUser(){
		return usersService.getAllUsers();
	}

	@PostMapping("/bulk/")
	public List<Users> createBulkUsers(@RequestBody List<Users> users){
		return usersService.createBulkUsers(users);
	}

}
