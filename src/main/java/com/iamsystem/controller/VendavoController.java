package com.iamsystem.controller;

import java.awt.PageAttributes.MediaType;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iamsystem.service.VendavoService;

@RestController
@RequestMapping("/vendavo")
public class VendavoController {
	
	@Autowired
	VendavoService vendavoService;
	
	
	//@GetMapping("/accounts")
	@GetMapping(value = "/accounts", produces = {"application/xml","application/json"})
	public Map<String,Object> getAccounts(){
		return vendavoService.getProdAccounts();
	}
	
	@GetMapping("/roles")
	public Map<String,Object> getRoles(){
		return vendavoService.getRoles();
	}
	

	@GetMapping("/privileges")
	public Map<String,Object> getPrivileges(){
		return vendavoService.getPrivileges();
	}
	
	@GetMapping("/mapping")
	public Map<String,Object>  getRolesToPrivilegesMapping (){
		return vendavoService.getRolesToPrivilegesMapping();
	}
}
