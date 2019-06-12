package com.bank.anz.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.anz.model.Account;

public interface AccountRepository extends JpaRepository<Account,Integer>{
	
	public Set<Account> findByUserId(Integer userId);
	
	public Account findByAccNum(String accNum);

}
