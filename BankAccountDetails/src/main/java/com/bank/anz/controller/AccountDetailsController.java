package com.bank.anz.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.anz.model.Account;
import com.bank.anz.model.AccountDetailsResponse;
import com.bank.anz.model.TransactionDetailsResponse;
import com.bank.anz.service.AccountDetailsService;
import com.bank.anz.util.AccDtlsConstants;

@RestController
@RequestMapping("/api/bank/")
public class AccountDetailsController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountDetailsController.class);
	
	@Autowired 
	private AccountDetailsService service;

	@GetMapping("{userId}/accounts")
	public ResponseEntity<AccountDetailsResponse> getAccountDetails(@PathVariable Integer userId){
		logger.info("Method AccountDetailsController::getAccountDetails started for User Id: "+userId);
		Set<Account> accounts=service.getAccountDetails(userId);
		AccountDetailsResponse resp=new AccountDetailsResponse();
		if(CollectionUtils.isEmpty(accounts)) {
			resp.setStatus(HttpStatus.BAD_REQUEST);
			resp.setMessage(AccDtlsConstants.FAILURE_STRING);
			resp.setDesc("Please provide valid User Id");

		} else {
			resp.setAccounts(accounts);
			resp.setStatus(HttpStatus.OK);
			resp.setMessage(AccDtlsConstants.SUCCESS_STRING);
			resp.setDesc("Account details fetched successfully");
		}
		logger.info("Method AccountDetailsController::getAccountDetails ended");
		return new ResponseEntity<AccountDetailsResponse>(resp,HttpStatus.OK);											
		
	}
	@GetMapping("{accNum}/transactions")
	public ResponseEntity<TransactionDetailsResponse> getTransactionDetails(@PathVariable String accNum){
		logger.info("Method AccountDetailsController::getAccountDetails started for Account Num: "+accNum);
		Account account=service.getTransactionDetails(accNum);
		logger.info("Account: "+account);
		TransactionDetailsResponse resp=new TransactionDetailsResponse();
		if(account==null) {
			resp.setStatus(HttpStatus.BAD_REQUEST);
			resp.setMessage(AccDtlsConstants.FAILURE_STRING);
			resp.setDesc("Please provide valid account number");

		}else if(CollectionUtils.isEmpty(account.getTransactions())) {
			resp.setStatus(HttpStatus.BAD_REQUEST);
			resp.setMessage(AccDtlsConstants.FAILURE_STRING);
			resp.setDesc("No transaction found for this account");
		}
		else {
			resp.setTransactions(account.getTransactions());
			resp.setAccName(account.getAccName());
			resp.setAccNum(account.getAccNum());
			resp.setCurrency(account.getCurrency());
			resp.setStatus(HttpStatus.OK);
			resp.setMessage(AccDtlsConstants.SUCCESS_STRING);
			resp.setDesc("Transaction details fetched successfully");
		}
		logger.info("Method AccountDetailsController::getAccountDetails ended");
		return new ResponseEntity<TransactionDetailsResponse>(resp,HttpStatus.OK);											
		
	}

}
