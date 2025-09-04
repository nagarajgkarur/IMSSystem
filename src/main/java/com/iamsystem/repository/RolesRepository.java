package com.iamsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iamsystem.domain.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>{

}
