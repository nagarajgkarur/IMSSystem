package com.iamsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iamsystem.domain.highradiusAccount;

@Repository
public interface HighRadiusAccountRepository extends JpaRepository<highradiusAccount, Long>{

	@Query("select a from highradiusAccount a where a.userName=:accountName")
	highradiusAccount findByUserName(String accountName);

	@Query("select a from highradiusAccount a where a.userName=:accountName")
	List<highradiusAccount> findByUserNaIn(String accountName);

}
