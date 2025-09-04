package com.iamsystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iamsystem.domain.highradiusAccount;
import com.iamsystem.highradius.response.HighRadiusAccountResponse;
import com.iamsystem.hive9.response.HighRadiusResonseResult;
import com.iamsystem.hive9.response.HighRadiusResponse;
import com.iamsystem.hive9.response.Role;
import com.iamsystem.repository.HighRadiusAccountRepository;

@Service
public class HighRadiusAccountService {

	
	@Autowired
	HighRadiusAccountRepository highRadiusAccountRepository;
	
	public ResponseEntity<HighRadiusResponse> createAccount(List<highradiusAccount> highradiusAccounts) {
		HighRadiusResponse highRadiusResponse = new HighRadiusResponse();
		HighRadiusResonseResult result = new HighRadiusResonseResult();
		highradiusAccount highradiusAccount = null;
		try {
			highradiusAccount = highRadiusAccountRepository.save(highradiusAccounts.get(0));
			List<highradiusAccount> highradiusAccountsList = new ArrayList<highradiusAccount>();
			highradiusAccountsList.add(highradiusAccount);
			highRadiusResponse.setUsers(highradiusAccountsList);
			result.setStatusCode(6000);
			result.setStatusMessage("success");
			highRadiusResponse.setResult(result);
			return new ResponseEntity<HighRadiusResponse>(highRadiusResponse, HttpStatus.CREATED);
		}catch (Exception e) {
			highRadiusResponse.setUsers(null);
			result.setStatusCode(6001);
			result.setStatusMessage("failed");
			highRadiusResponse.setResult(result);
			return new ResponseEntity<HighRadiusResponse>(highRadiusResponse, HttpStatus.CREATED);
		}
	}
	
	public ResponseEntity<HighRadiusResponse> createAccountv1(highradiusAccount highradiusAccounts) {
		HighRadiusResponse highRadiusResponse = new HighRadiusResponse();
		HighRadiusResonseResult result = new HighRadiusResonseResult();
		highradiusAccount highradiusAccount = null;
		try {
			highradiusAccount = highRadiusAccountRepository.save(highradiusAccounts);
			List<highradiusAccount> highradiusAccountsList = new ArrayList<highradiusAccount>();
			highradiusAccountsList.add(highradiusAccount);
			highRadiusResponse.setUsers(highradiusAccountsList);
			result.setStatusCode(6000);
			result.setStatusMessage("success");
			highRadiusResponse.setResult(result);
			return new ResponseEntity<HighRadiusResponse>(highRadiusResponse, HttpStatus.CREATED);
		}catch (Exception e) {
			highRadiusResponse.setUsers(null);
			result.setStatusCode(6001);
			result.setStatusMessage("failed");
			highRadiusResponse.setResult(result);
			return new ResponseEntity<HighRadiusResponse>(highRadiusResponse, HttpStatus.CREATED);
		}
	}
	
	public ResponseEntity<HighRadiusResponse> updateUser(List<highradiusAccount> highradiusAccounts){
		highradiusAccount paramsAccount = highradiusAccounts.get(0);
		highradiusAccount hrAccount = highRadiusAccountRepository.findByUserName(paramsAccount.getUserName());
		if(hrAccount != null) {
			hrAccount.setFirstName(paramsAccount.getFirstName());
			hrAccount.setLastName(paramsAccount.getLastName());
			hrAccount.setUserName(paramsAccount.getUserName());
			hrAccount.setFunctionalRole(paramsAccount.getFunctionalRole());
			hrAccount.setSecurityRole(paramsAccount.getSecurityRole());
			hrAccount.setSecurityGroupData(paramsAccount.getSecurityGroupData());
		}
		HighRadiusResponse highRadiusResponse = new HighRadiusResponse();
		HighRadiusResonseResult result = new HighRadiusResonseResult();
		try {
			hrAccount = highRadiusAccountRepository.save(hrAccount);
			List<highradiusAccount> highradiusAccountsList = new ArrayList<highradiusAccount>();
			highradiusAccountsList.add(hrAccount);
			highRadiusResponse.setUsers(highradiusAccountsList);
			result.setStatusCode(6000);
			result.setStatusMessage("success");
			highRadiusResponse.setResult(result);
		}catch (Exception e) {
			result.setStatusCode(6001);
			result.setStatusMessage("failed");
			highRadiusResponse.setResult(result);
			highRadiusResponse.setUsers(null);
		}
		
		return new ResponseEntity<HighRadiusResponse>(highRadiusResponse,HttpStatus.CREATED);
	}

	public List<Map<String, String>> getSecurityRoles() {
		ObjectMapper mapper = new ObjectMapper();
		String rolesData = getRolesString();
		List<Map<String, String>> map= new ArrayList<Map<String, String>>();
		try {
			map = mapper.readValue(rolesData, new TypeReference<List<Map<String,String>>>(){});
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return map;
	}

	

	private String getRolesString() {
		String rolesData = "[\r\n"
				+ "	{\r\n"
				+ "		\"roleName\":\"shell_admin_user\",\r\n"
				+ "		\"roleDescription\" : \"Adming user access\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"roleName\":\"shell_admin_manager\",\r\n"
				+ "		\"roleDescription\" : \"Adming mangaer access\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"roleName\":\"shell_admin_Audit\",\r\n"
				+ "		\"roleDescription\" : \"Adming Audit access\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"roleName\":\"shell_admin_Account\",\r\n"
				+ "		\"roleDescription\" : \"Adming Accounts access\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"roleName\":\"shell_admin_Hr\",\r\n"
				+ "		\"roleDescription\" : \"Adming user hr\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"roleName\":\"shell_enduser\",\r\n"
				+ "		\"roleDescription\" : \"Adming enduser access\"\r\n"
				+ "	}\r\n"
				+ "\r\n"
				+ "]";
		
		return rolesData;
	}

	public List<Map<String, String>> getSecurityGroups() {
		ObjectMapper mapper = new ObjectMapper();
		String rolesData = getSecurityGroupString();
		List<Map<String, String>> map= new ArrayList<Map<String, String>>();
		try {
			map = mapper.readValue(rolesData, new TypeReference<List<Map<String,String>>>(){});
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return map;
	}

	private String getSecurityGroupString() {
		String securitygroupdData = "[\r\n"
				+ "	{\r\n"
				+ "		\"groupName\":\"OM\",\r\n"
				+ "		\"groupDescription\" : \"OM access\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"groupName\":\"PH\",\r\n"
				+ "		\"groupDescription\" : \"PH access\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"groupName\":\"LM\",\r\n"
				+ "		\"groupDescription\" : \"LM access\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"groupName\":\"SS\",\r\n"
				+ "		\"groupDescription\" : \"SS access\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"groupName\":\"FK\",\r\n"
				+ "		\"groupDescription\" : \"FK access\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"groupName\":\"DS\",\r\n"
				+ "		\"groupDescription\" : \"DS access\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"groupName\":\"MM\",\r\n"
				+ "		\"groupDescription\" : \"MM access\"\r\n"
				+ "	}\r\n"
				+ "\r\n"
				+ "]";
		return securitygroupdData;
	}

	public HighRadiusAccountResponse getAllAccount() {
		HighRadiusAccountResponse response = new HighRadiusAccountResponse();
		List<highradiusAccount> users = highRadiusAccountRepository.findAll();
		HighRadiusResonseResult result = new HighRadiusResonseResult();
		result.setStatusCode(6000);
		result.setStatusMessage("success");
		response.setResult(result);
		response.setUsers(users);
		return response;
	}

	public HighRadiusAccountResponse getAccount(String accountName) {
		HighRadiusAccountResponse response = new HighRadiusAccountResponse();
		List<highradiusAccount> account = highRadiusAccountRepository.findByUserNaIn(accountName);
		HighRadiusResonseResult result = new HighRadiusResonseResult();
		result.setStatusCode(6000);
		result.setStatusMessage("success");
		response.setResult(result);
		response.setUsers(account);
		return response;
	}

	public void deleteAccount(String accountName) {
		
		highradiusAccount acc = highRadiusAccountRepository.findByUserName(accountName);
		highRadiusAccountRepository.deleteById(acc.getId());
	}
	
}
