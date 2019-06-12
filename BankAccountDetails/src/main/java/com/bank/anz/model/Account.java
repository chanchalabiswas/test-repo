package com.bank.anz.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ACCOUNT", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID")})
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "ACC_NUMBER", unique = true, nullable = false, length = 100)
	private String accNum;
	
	@Column(name = "ACC_NAME", unique = false, nullable = false, length = 100)
	private String accName;
	
	@Column(name = "ACC_TYPE", unique = false, nullable = false, length = 100)
	private String accType;
	
	@Column(name = "BAL_DATE", unique = false, nullable = false, length = 100)
	private Date balanceDate;
	
	@Column(name = "CURRENCY", unique = false, nullable = false, length = 100)
	private String currency;
	
	@Column(name = "AVAIL_BALANCE", unique = false, nullable = false, length = 100)
	private BigDecimal availBalance;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "account")
	private Set<Transaction> transactions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public Date getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getAvailBalance() {
		return availBalance;
	}

	public void setAvailBalance(BigDecimal availBalance) {
		availBalance.setScale(2, BigDecimal.ROUND_UP);
		this.availBalance = availBalance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JsonIgnore
	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	@Override
	public String toString() {
		return "Account: { id: "+id 
									+ ",\naccNum: "+accNum
									+ ",\naccName: "+accName
									+ ",\naccType: "+accType
									+ ",\nbalanceDate: "+balanceDate
									+ ",\ncurrency: "+currency
									+ ",\navailBalance: "+availBalance
									+"}";
	}

}
