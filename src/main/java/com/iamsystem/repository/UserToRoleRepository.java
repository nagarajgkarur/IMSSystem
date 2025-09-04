package com.iamsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.iamsystem.domain.UserToRoles;

@Repository
public interface UserToRoleRepository extends JpaRepository<UserToRoles, Long>{

	
	@Query("select ur from UserToRoles ur where ur.loginId=:loginId")
	List<UserToRoles> getByLoginId(@PathVariable String loginId);
	
	@Query("select ur from UserToRoles ur ")
	List<UserToRoles> getByLoginId();

}
