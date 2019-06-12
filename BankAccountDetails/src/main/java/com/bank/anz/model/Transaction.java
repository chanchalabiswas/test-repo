package com.bank.anz.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "TRANSACTION", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID")})
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "VALUE_DT", unique = false, nullable = false, length = 100)
	private Date valueDate;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "DEBIT_AMOUNT", unique = false, nullable = true, length = 100)
	private BigDecimal debitAmount;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "CREDIT_AMOUNT", unique = false, nullable = true, length = 100)
	private BigDecimal creditAmount;
	
	@Column(name = "TRANS_TYPE", unique = false, nullable = false, length = 100)
	private String transType;
	
	@Column(name = "NARRATIVE", unique = false, nullable = true, length = 100)
	private String narrative;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	private Account account;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(BigDecimal debitAmount) {
		debitAmount.setScale(2, BigDecimal.ROUND_UP);
		this.debitAmount = debitAmount;
	}

	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(BigDecimal creditAmount) {
		creditAmount.setScale(2, BigDecimal.ROUND_UP);
		this.creditAmount = creditAmount;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getNarrative() {
		return narrative;
	}

	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
