package com.iamsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iamsystem.domain.User_account;

@Repository
public interface UserAccountRepository extends JpaRepository<User_account, Long> {


}
