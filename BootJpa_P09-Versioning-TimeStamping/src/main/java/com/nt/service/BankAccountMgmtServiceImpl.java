package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.BankAccount;
import com.nt.repository.IBankAccountRepository;

@Service 
public class BankAccountMgmtServiceImpl implements IBankAccountMgmtService {

	@Autowired
	private IBankAccountRepository bankRepo;
	
	@Override
	public String createAccount(BankAccount account) {
		long accNo = bankRepo.save(account).getAccNo();
 		return "Bank Account is opened with Account No :"+accNo;
	}

	@Override
	public String withdrawMoney(long accNo, double amount) {
  		//load the account
		Optional<BankAccount> opt = bankRepo.findById(accNo);
		if(opt.isPresent()) {
			//get the object
			BankAccount bankAccount = opt.get();
			//update the object
			bankAccount.setBalance(bankAccount.getBalance()-amount);
			bankRepo.save(bankAccount);
			return amount+" money is withdrawn from the Bank Account";
		}
		else
		return accNo+" Bank Accont not found";
	}

	@Override
	public String depositMoney(long accNo, double amount) {
  		//load the account
		Optional<BankAccount> opt = bankRepo.findById(accNo);
		if(opt.isPresent()) {
			//get the object
			BankAccount bankAccount = opt.get();
			//update the object
			bankAccount.setBalance(bankAccount.getBalance()+amount);
			bankRepo.save(bankAccount);
			return amount+" money is depositeed to the Bank Account";
		}
		else
		return accNo+" Bank Accont not found";
	}
	
	@Override
	public BankAccount findBankAccountByAccNo(long accNo) {
		BankAccount account = bankRepo.findById(accNo).orElseThrow(()->new IllegalArgumentException("Invalid Bank Account Number"));
 		return account;
	}

}
