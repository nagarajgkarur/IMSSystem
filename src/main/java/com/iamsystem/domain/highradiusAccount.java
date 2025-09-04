package com.iamsystem.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class highradiusAccount {
	
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String userName;
	private String firstName;
	private String lastName;
	private String functionalRole;
	private String securityRole;
	private String securityGroupData;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFunctionalRole() {
		return functionalRole;
	}
	public void setFunctionalRole(String functionalRole) {
		this.functionalRole = functionalRole;
	}
	public String getSecurityRole() {
		return securityRole;
	}
	public void setSecurityRole(String securityRole) {
		this.securityRole = securityRole;
	}
	public String getSecurityGroupData() {
		return securityGroupData;
	}
	public void setSecurityGroupData(String securityGroupData) {
		this.securityGroupData = securityGroupData;
	}
	
}

