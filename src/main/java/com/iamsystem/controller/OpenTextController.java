package com.iamsystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamsystem.domain.Roles;
import com.iamsystem.domain.UserToRoles;
import com.iamsystem.service.OpenTextService;
import com.iamsystem.service.UserToRoleService;

@RestController
@RequestMapping("/opentext")
public class OpenTextController {
	
	@Autowired
	OpenTextService openTextService;
	
	@Autowired
	UserToRoleService userToRoleService;
	
	@GetMapping("/users")
	public List<Map<String,Object>> getUsers(){
		return openTextService.getAllUsers();
	}

	@GetMapping("/users/{userId}")
	public List<Map<String,Object>> getUser(@PathVariable("userId") String userID){
		return openTextService.getUser(userID);
	}
	
	@GetMapping("/roles/{userId}")
	public List<Map<String,Object>> getRoles(@PathVariable String userId){
		return openTextService.getRoles(userId);
	}
	
	@PostMapping("/roles")
	public void savRolesToUser(@RequestBody List<UserToRoles> rolesList) {
		userToRoleService.saveRoles(rolesList);
	}
	
	@GetMapping("/v2/roles/{userId}")
	public Map<String,Object> getRolesv2(@PathVariable String userId){
		return openTextService.getUserToRole(userId);
	}

}
