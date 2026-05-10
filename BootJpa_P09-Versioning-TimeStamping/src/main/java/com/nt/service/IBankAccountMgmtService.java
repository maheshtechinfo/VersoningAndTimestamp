package com.nt.service;

import com.nt.entity.BankAccount;

public interface IBankAccountMgmtService {
	
	public String createAccount(BankAccount account);
	public String withdrawMoney(long accNo, double amount);
	public String depositMoney(long accNo, double amount);
	public BankAccount findBankAccountByAccNo(long accNo);

}
