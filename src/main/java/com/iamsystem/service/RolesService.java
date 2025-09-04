package com.iamsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamsystem.domain.Roles;
import com.iamsystem.repository.RolesRepository;

@Service
public class RolesService {


	@Autowired
	RolesRepository rolesRepository;

	public Roles createRoles(Roles role) {
		return rolesRepository.save(role);
	}

	public List<Roles> getAllRoles(){
		return rolesRepository.findAll();
	}

	public List<Roles> createBulkRoles(List<Roles> roles){
		List<Roles> resultList = new ArrayList<>();
		roles.forEach(e->{
			resultList.add(rolesRepository.save(e));
		});
		return resultList;
	}

}
