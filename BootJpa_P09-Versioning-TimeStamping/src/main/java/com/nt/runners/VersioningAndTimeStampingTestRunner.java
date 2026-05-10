package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.BankAccount;
import com.nt.service.IBankAccountMgmtService;

@Component
public class VersioningAndTimeStampingTestRunner implements CommandLineRunner {

	@Autowired
	private IBankAccountMgmtService bankService;

	@Override
	public void run(String... args) throws Exception {

		// save object(create Bank Account)
		/*		try {
					BankAccount account = new BankAccount("Mahesh", 500000.0, "SBI", "Current");
					String msg = bankService.createAccount(account);
					System.out.println(msg);
		
				} catch (Exception e) {
					e.printStackTrace();
				}*/

				try {
					String msg = bankService.withdrawMoney(100003L, 1000.0);
					System.out.println(msg);
					BankAccount account =  bankService.findBankAccountByAccNo(100003L);
					System.out.println("Account Balance is modified for "+account.getUpdateCount()+" times and opened on "+account.getOpenedDate()+" and lastly operated on "+account.getLastlyUpdatedOn());
					
				}catch(Exception e) {
					e.printStackTrace();
				}
	}

}
