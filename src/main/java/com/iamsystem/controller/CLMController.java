package com.iamsystem.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamsystem.service.CLMService;
@RestController
@RequestMapping("/clm/api/")
public class CLMController {
	
	@Autowired
	CLMService clmService;
	
	@GetMapping("user")
	public Map<String,Object> getUserData(){
		return clmService.getUserData();
	}

}
