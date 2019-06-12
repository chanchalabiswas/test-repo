package com.bank.anz.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
public class AccountDetailsResponse extends BaseResponse{
	

	private static final long serialVersionUID = 8026742983833770668L;
	
	@JsonInclude(Include.NON_EMPTY)
	Set<Account> accounts;


	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

}
