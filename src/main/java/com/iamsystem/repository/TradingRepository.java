package com.iamsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iamsystem.domain.Trading;

@Repository
public interface TradingRepository extends JpaRepository<Trading, Long>{

}
