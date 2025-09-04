package com.iamsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iamsystem.domain.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long>{

	Accounts findByName(String accountName);

}
