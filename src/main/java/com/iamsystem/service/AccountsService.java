package com.iamsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamsystem.domain.Accounts;
import com.iamsystem.domain.User_account;
import com.iamsystem.domain.Users;
import com.iamsystem.model.BulkAccountRequestBody;
import com.iamsystem.model.User_Account_Response;
import com.iamsystem.repository.AccountRepository;
import com.iamsystem.repository.UserAccountRepository;
import com.iamsystem.repository.UsersRepository;

import ch.qos.logback.core.util.StringUtil;


@Service
public class AccountsService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	UserAccountRepository userAccountRepository;

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	Hive9Service hive9Service;


	public Accounts createAccounts(Accounts account) throws Exception {
		/*
		 * if(StringUtil.isNullOrEmpty(account.getRoleName())) { throw new
		 * Exception("Role name cant be null"); } List<String> roleNameList =
		 * hive9Service.getRoleNameList();
		 */
		/*
		 * if(!roleNameList.contains(account.getName())) { throw new
		 * Exception("cant find Role name "); }
		 */
		return accountRepository.save(account);
	}

	public List<Accounts> getAllAccounts(){
		return accountRepository.findAll();
	}

	public List<Accounts> createBulkAccount(List<Accounts> accounts){
		List<Accounts> result = new ArrayList<>();
		accounts.forEach(e-> {
			result.add(accountRepository.save(e));
		});
		return result;
	}

	public User_Account_Response createUserToAccountMapping(String userName, String accountName) {
		Optional<Users> userOpt = usersRepository.findByName(userName);
		User_Account_Response userAccountResponse = new User_Account_Response();
		Users user = null;
		if(userOpt.isPresent()) {
			user = userOpt.get();
			Accounts accounts = accountRepository.findByName(accountName);
			User_account user_account = new User_account();
			user_account.setAccount(accounts);
			user_account.setUser(user);
			userAccountRepository.save(user_account);
			userAccountResponse.setAccountName(user_account.getAccount().getName());
			userAccountResponse.setUserName(user_account.getUser().getName());
		}
		return userAccountResponse;
	}

	public List<User_Account_Response> createUserToAccountMapping(List<BulkAccountRequestBody> bulkAccountRequestBody) {
		List<User_Account_Response> user_Account_ResponsesList = new ArrayList<>();
		bulkAccountRequestBody.forEach(e->{
			User_Account_Response userAccountResponse = new User_Account_Response();
			Optional<Users> userOpt = usersRepository.findByName(e.getUserName());
			Users user = null;
			if(userOpt.isPresent()) {
				user = userOpt.get();
				userAccountResponse.setUserName(user.getName());
			}
			Accounts accounts = accountRepository.findByName(e.getAccountName());
			userAccountResponse.setAccountName(accounts.getName());
			user_Account_ResponsesList.add(userAccountResponse);
		});
		return user_Account_ResponsesList;
	}

	public List<User_Account_Response> getAllUserAccountMapping() {
		List<User_Account_Response> user_Account_ResponsesList = new ArrayList<>();
		userAccountRepository.findAll().forEach(e->{
			User_Account_Response user_Account_Response = new User_Account_Response();
			user_Account_Response.setAccountName(e.getAccount().getName());
			user_Account_Response.setUserName(e.getUser().getName());
			user_Account_ResponsesList.add(user_Account_Response);
		});
		return user_Account_ResponsesList;
	}

}
