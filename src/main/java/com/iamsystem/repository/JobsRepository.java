package com.iamsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iamsystem.domain.Jobs;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Long> {

}
