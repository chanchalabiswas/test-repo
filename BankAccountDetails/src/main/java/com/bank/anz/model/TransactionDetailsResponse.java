package com.bank.anz.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class TransactionDetailsResponse extends BaseResponse {

	private static final long serialVersionUID = 718387100033043746L;
	
	@JsonInclude(Include.NON_EMPTY)
	Set<Transaction> transactions;
	
	@JsonInclude(Include.NON_EMPTY)
	private String accNum;
	
	@JsonInclude(Include.NON_EMPTY)
	private String accName;
	
	@JsonInclude(Include.NON_EMPTY)
	private String currency;

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
