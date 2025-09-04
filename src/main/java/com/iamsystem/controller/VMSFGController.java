package com.iamsystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamsystem.service.VMSFGService;

@RestController
@RequestMapping("/vmsfg/api/")
public class VMSFGController {
	
	@Autowired
	VMSFGService vmsfgService;
	
	@GetMapping("userrolemapping")
	public Map<String,List<Map<String,String>>> getUsertoRoleMapping(){
		return vmsfgService.getUsertoRoleMapping();
	}
	
	@GetMapping("roles")
	public Map<String,List<Map<String,String>>> getRoles(){
		return vmsfgService.getRoles();
	}
	
	

}
