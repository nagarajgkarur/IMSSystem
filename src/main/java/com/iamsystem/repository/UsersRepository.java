package com.iamsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iamsystem.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

	Optional<Users> findByName(String names);

}
