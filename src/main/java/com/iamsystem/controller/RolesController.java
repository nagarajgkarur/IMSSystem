package com.iamsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamsystem.domain.Roles;
import com.iamsystem.service.RolesService;

@RestController
@RequestMapping("/roles")
public class RolesController {

	@Autowired
	RolesService rolesService;

	@PostMapping("/")
	public Roles createRoles(@RequestBody Roles role) {
		return rolesService.createRoles(role);
	}

	@GetMapping("/")
	public List<Roles> getAllRoles(){
		return rolesService.getAllRoles();
	}

	@PostMapping("/bulk/")
	public List<Roles> createBulkRoles(@RequestBody List<Roles> roles){
		return rolesService.createBulkRoles(roles);
	}

}
