package com.iamsystem.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamsystem.service.HighRadiusDevService;

@RestController
@RequestMapping("/highradius/dev/api")
public class HighRadiusDevContrller {

	@Autowired
	HighRadiusDevService highRadiusDevService;
	
	@GetMapping(value = "/account")
	public Map<String,Object> getAccounts(){
		
		return highRadiusDevService.getPage1Accounts();
	}
}
