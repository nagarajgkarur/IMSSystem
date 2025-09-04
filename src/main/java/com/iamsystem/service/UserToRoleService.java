package com.iamsystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamsystem.domain.UserToRoles;
import com.iamsystem.repository.UserToRoleRepository;

@Service
public class UserToRoleService {
	
	
	
	@Autowired
	UserToRoleRepository userToRoleRepository;
	
	
	public UserToRoles save(UserToRoles userToRoles) {
		return userToRoleRepository.save(userToRoles);
	}

	public void saveRoles(List<UserToRoles> rolesList) {
		rolesList.stream().forEach(it->userToRoleRepository.save(it));
	}

	public Map<String, Object> getUserToroles(String loginId) {
		List<UserToRoles> userToRoles = userToRoleRepository.getByLoginId(loginId);
		List<Map<String,String>> rolesList = new ArrayList<Map<String,String>>();
		userToRoles.stream().forEach(it->{
			Map<String,String> eachMap = new HashMap<String, String>();
			eachMap.put("roleName", it.getRoleName());
			eachMap.put("isSubscribed", it.getIsSubscribed());
			eachMap.put("roleDisplayName", it.getRoleDisplayName());
			rolesList.add(eachMap);
		});
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("loginId", loginId);
		result.put("roles", rolesList);
		return result;
	}

	public List<Map<String, String>> getUserRoles(String userId) {
		List<UserToRoles> userToRoles = userToRoleRepository.getByLoginId(userId);
		List<Map<String,String>> result = new ArrayList<Map<String,String>>();
		userToRoles.forEach(it->{
			Map<String,String> eachRoles = new HashMap<String, String>();
			eachRoles.put("roleName",it.getRoleName());
			result.add(eachRoles);
		});
		
		return result;
	}

}
