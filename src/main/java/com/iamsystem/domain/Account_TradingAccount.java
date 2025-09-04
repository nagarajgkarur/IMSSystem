package com.iamsystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Account_TradingAccount {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Accounts account;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Trading trading;
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
	public Trading getTradingAccount() {
		return trading;
	}
	public void setTradingAccount(Trading tradingAccou) {
		this.trading = trading;
	}


}
