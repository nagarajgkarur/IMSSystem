package com.iamsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.iamsystem.domain.Users;
import com.iamsystem.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public Users createUser(Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return usersRepository.save(user);
	}

	public List<Users> getAllUsers(){
		return usersRepository.findAll();
	}

	public List<Users> createBulkUsers(List<Users> users){
		List<Users> result = new ArrayList<>();
		users.stream().forEach(e-> {
			e.setPassword(passwordEncoder.encode(e.getPassword()));
			result.add(usersRepository.save(e));
		});
		return result;

	}

}
