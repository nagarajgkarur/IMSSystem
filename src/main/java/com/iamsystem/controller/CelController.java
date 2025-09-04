package com.iamsystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamsystem.payload.CelMembers;
import com.iamsystem.payload.CelPayload;
import com.iamsystem.service.CelService;

import ch.qos.logback.core.util.StringUtil;

@RestController
@RequestMapping("/cel")
public class CelController {
	
	
	@Autowired
	CelService celService;
	
	@GetMapping("/users")
	public Map<String,Object> getUsers(){
		return celService.getUsers();
	}
	
	
	@GetMapping("/groups")
	public Map<String,Object> getGroups(){
		return celService.getGroups();
	}
	
	@PutMapping("/groups/{id}")
	public boolean removeCellGroup(@RequestBody Map<String,Object> celPayload, @PathVariable String id) throws Exception {
		
		Object displayName = celPayload.get("displayName");
		if(displayName == null) {
			System.out.println("Display Name cant be null");
			throw new Exception("Display Name cant be null");
		}

		System.out.println("celPayload ::::: " +celPayload);
		return true;
	}
	
	
	@GetMapping("/groups/{id}")
	public Map<String,Object> getMember(@PathVariable String id) throws Exception {
		Map<String,Object> rem = celService.getMembers(id);	
		System.out.println("rem ::::: "+rem);
		return rem;
	}

}
