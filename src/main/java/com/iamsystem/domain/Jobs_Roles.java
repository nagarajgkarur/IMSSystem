package com.iamsystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Jobs_Roles {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Jobs job;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Roles role;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public Jobs getJob() {
		return job;
	}
	public void setJob(Jobs job) {
		this.job = job;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}



}
