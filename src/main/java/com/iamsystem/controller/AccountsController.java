package com.iamsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamsystem.domain.Accounts;
import com.iamsystem.model.BulkAccountRequestBody;
import com.iamsystem.model.UserAccountRequestBody;
import com.iamsystem.model.User_Account_Response;
import com.iamsystem.service.AccountsService;
import com.iamsystem.service.Hive9Service;

@RestController
@RequestMapping("/account")
public class AccountsController {

	@Autowired
	AccountsService accountsService;
	
	@Autowired
	Hive9Service hive9Service;

	@GetMapping("/")
	public List<Accounts> getAccount() {
		return accountsService.getAllAccounts();
	}

	@PostMapping("/")
	public Accounts createAccount(@RequestBody Accounts account) {
		try {
			return accountsService.createAccounts(account);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@PostMapping("/bulk/")
	public List<Accounts> createBulkAccounts(@RequestBody List<Accounts> accounts){

		return accountsService.createBulkAccount(accounts);
	}

	@GetMapping("/mapping/")
	public List<User_Account_Response> getUserAccount(){
		return accountsService.getAllUserAccountMapping();
	}

	@PostMapping("/mapping/")
	public User_Account_Response createUserAccountMapping(@RequestBody UserAccountRequestBody userAccountRequestBody) {
		return accountsService.createUserToAccountMapping(userAccountRequestBody.getUserName(),userAccountRequestBody.getAccountName());
	}

	@PostMapping("/bulk/mapping/")
	public List<User_Account_Response> createBulkUserAccountMapping(@RequestBody List<BulkAccountRequestBody> bulkAccountRequestBody) {
		return accountsService.createUserToAccountMapping(bulkAccountRequestBody);
	}

}
