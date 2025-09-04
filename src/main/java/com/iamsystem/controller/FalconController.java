package com.iamsystem.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamsystem.service.FalconService;

@RestController
@RequestMapping("/flc/api/")
public class FalconController {
	
	
	@Autowired
	FalconService falconService;
	
	
	@GetMapping("user")
	public Map<String,Object> getUserData(){
		return falconService.userData();
	}
	
	
	@GetMapping("userDetails")
	public Map<String,Object> getUserDetailsData(){
		return falconService.userDetailsData();
	}

}
