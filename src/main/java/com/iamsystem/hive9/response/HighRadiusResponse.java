package com.iamsystem.hive9.response;

import java.util.List;
import java.util.Map;

import com.iamsystem.domain.highradiusAccount;

public class HighRadiusResponse {
	
	HighRadiusResonseResult result;
	List<highradiusAccount> users;
	
	public HighRadiusResonseResult getResult() {
		return result;
	}
	public void setResult(HighRadiusResonseResult result) {
		this.result = result;
	}
	public List<highradiusAccount> getUsers() {
		return users;
	}
	public void setUsers(List<highradiusAccount> users) {
		this.users = users;
	}

}
