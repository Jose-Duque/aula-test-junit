package tests.factory;

import entities.Account;

public class AccountFactory {

	public static Account createAccount(double amount) {
		return new Account(1L, amount); 
	}
}
