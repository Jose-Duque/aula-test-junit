package testa.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	@Test
	public void deposiShouldIncreaseBalanceWhenPositiveAmount() {
		
		double amount = 200.0;
		double expectedValue = 196.0;
		
		Account acc = AccountFactory.createAccount(0.0);
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void depositNegativo() {
		
		double expectedValue = 100.0;
		double amount = -200.0;
		
		Account acc = AccountFactory.createAccount(expectedValue);
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void saquetudoShouldClearBalance() {
		
		double expectedValue = 0.0;
		
		Account acc = AccountFactory.createAccount(200.0);
		acc.saqueTudo();
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void saqueShouldDecrementBalanceWhenNegativeAmount() {
		
		Account acc = AccountFactory.createAccount(500.0);
		acc.saque(450.0);
		Assertions.assertEquals(50.0, acc.getBalance());
	}
	
	@Test
	public void saqueShouldToThrowWhenAmountNegative() {
		
		Assertions.assertThrows(IllegalAccessError.class, () -> {
			Account acc = AccountFactory.createAccount(500.0);
			acc.saque(550.00);
		});
	}
}
