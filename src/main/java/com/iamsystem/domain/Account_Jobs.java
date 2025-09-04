package com.iamsystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Account_Jobs {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Accounts account;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Jobs job;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public Accounts getAccount() {
		return account;
	}
	public void setAccount(Accounts account) {
		this.account = account;
	}
	public Jobs getJob() {
		return job;
	}
	public void setJob(Jobs job) {
		this.job = job;
	}



}
