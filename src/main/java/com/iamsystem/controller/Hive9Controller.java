package com.iamsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.iamsystem.hive9.response.RoleList;
import com.iamsystem.hive9.response.TeamList;
import com.iamsystem.hive9.response.Teams1;
import com.iamsystem.hive9.response.UserTeams;
import com.iamsystem.hive9.response.UserTeams1;
import com.iamsystem.hive9.response.Users;
import com.iamsystem.service.Hive9Service;

@RestController
@RequestMapping("/hive9")
public class Hive9Controller {


	@Autowired
	Hive9Service hive9Service;

	@GetMapping("/roles")
	 public RoleList getRole() throws JsonMappingException, JsonProcessingException{
		return hive9Service.getRoles();
	 }
	@GetMapping("/teams")
	 public TeamList getTeams() throws JsonMappingException, JsonProcessingException{
		return hive9Service.getTeams();
	 }
	
	@GetMapping("/users")
	public List<Users> getUsers() throws JsonMappingException, JsonProcessingException{
		return hive9Service.getusers();
	}
	
	@GetMapping("/userTeams")
	public List<Teams1> getUserTeams() {
		return hive9Service.getUserTeams();
	}

}
