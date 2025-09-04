package com.iamsystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iamsystem.domain.highradiusAccount;
import com.iamsystem.highradius.response.HighRadiusAccountResponse;
import com.iamsystem.hive9.response.HighRadiusResponse;
import com.iamsystem.service.HighRadiusAccountService;

@RestController
@RequestMapping("/hradius/api")
public class HighRadiusController {
	
	@Autowired
	HighRadiusAccountService highRadiusAccountService;
	
	@PostMapping(value= "/user",produces = {"application/xml","application/json"}, consumes = {"application/xml","application/json"})
	public ResponseEntity<HighRadiusResponse> CreateAccount(@RequestBody List<highradiusAccount> highradiusAccounts) {
		return highRadiusAccountService.createAccount(highradiusAccounts);
	}
	
	@PostMapping(value= "/user/v1",produces = {"application/xml","application/json"}, consumes = {"application/xml","application/json"})
	public ResponseEntity<HighRadiusResponse> CreateAccountv1(@RequestBody highradiusAccount highradiusAccounts) {
		return highRadiusAccountService.createAccountv1(highradiusAccounts);
	}
	
	@PutMapping("/user")
	public ResponseEntity<HighRadiusResponse> UpdateAccount(@RequestBody List<highradiusAccount> highradiusAccounts) {
		return highRadiusAccountService.updateUser(highradiusAccounts);
	}
	
	
	@GetMapping("/security/roles")
	public List<Map<String,String>> getSecurityRoles(){
		return highRadiusAccountService.getSecurityRoles();
	}
	
	@GetMapping("/security/groups")
	public List<Map<String,String>> getSecurityGroups(){
		return highRadiusAccountService.getSecurityGroups();
	}
	
	@GetMapping("/accounts")
	public HighRadiusAccountResponse getAccounts(){
		return highRadiusAccountService.getAllAccount();
	}
	
	@GetMapping("/account/{accountName}")
	public HighRadiusAccountResponse getAccount(@PathVariable String accountName) {
		return highRadiusAccountService.getAccount(accountName);
	}
	
	@GetMapping("/account")
	public HighRadiusAccountResponse getAccount1(@RequestParam String accountName) {
		return highRadiusAccountService.getAccount(accountName);
	}
	
	
	@DeleteMapping("/account/delete/{accountName}")
	public void deleteAccount(@PathVariable String accountName) {
		
		highRadiusAccountService.deleteAccount(accountName);
		
	}

}
