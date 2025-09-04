package com.iamsystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class User_account {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	@OneToOne
    @JoinColumn(name = "Id", nullable = false)
	private Users user;
	@OneToOne
    @JoinColumn(name = "Id", nullable = false)
	private Accounts account;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Accounts getAccount() {
		return account;
	}
	public void setAccount(Accounts account) {
		this.account = account;
	}


}
