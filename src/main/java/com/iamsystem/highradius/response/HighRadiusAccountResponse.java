package com.iamsystem.highradius.response;

import java.util.List;
import java.util.Map;

import com.iamsystem.domain.highradiusAccount;
import com.iamsystem.hive9.response.HighRadiusResonseResult;

public class HighRadiusAccountResponse {
	
	List<highradiusAccount> users;
	HighRadiusResonseResult result;
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
