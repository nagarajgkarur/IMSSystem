package com.iamsystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SEOPSController {

	
	@GetMapping("api/users")
	public List<Map<String,String>> getUsers(@RequestParam String $filter){
		// $filter=(domainname eq 'abcd/dsfew')
		System.out.println("$filter ::: "+$filter);
		return null;
	}
}
