package com.bank.anz.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.anz.controller.AccountDetailsController;
import com.bank.anz.model.Account;
import com.bank.anz.repository.AccountRepository;

@Service
public class AccountDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountDetailsController.class);
	
	@Autowired
	AccountRepository accRepo;
	
	public Set<Account> getAccountDetails(Integer userId) {
		logger.info("Method AccountDetailsService::getAccountDetails started");
		Set<Account> accounts= accRepo.findByUserId(userId);
		logger.info("Method AccountDetailsService::getAccountDetails ended");
		return accounts;
	}
	
	public Account getTransactionDetails(String accNum) {
		logger.info("Method AccountDetailsService::getTransactionDetails started");
		Account account=accRepo.findByAccNum(accNum);
		logger.info("Method AccountDetailsService::getTransactionDetails ended");
		return account;
	}

}
