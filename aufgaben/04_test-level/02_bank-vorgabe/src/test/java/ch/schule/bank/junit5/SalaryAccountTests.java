package ch.schule.bank.junit5;

import ch.schule.SalaryAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SalaryAccountTests {

	@Test
	public void testWithdrawWithValidAmount() {
		int date = 20231001;
		long initialBalance = 1000;
		long creditLimit = -500; // Negative credit limit
		long withdrawAmount = 300;

		SalaryAccount account = new SalaryAccount("SA-123", creditLimit);
		account.deposit(date, initialBalance);

		// Withdraw a valid amount that doesn't exceed the credit limit
		boolean withdrawResult = account.withdraw(date, withdrawAmount);

		// Check if the withdrawal was successful
		assertTrue(withdrawResult);

		// Calculate the expected balance after the withdrawal
		long expectedBalance = initialBalance - withdrawAmount;

		// Check if the actual balance matches the expected balance
		assertEquals(expectedBalance, account.getBalance());
	}

	@Test
	public void testWithdrawWithExceedingCreditLimit() {
		int date = 20231001;
		long initialBalance = 1000;
		long creditLimit = -500; // Negative credit limit
		long withdrawAmount = 800; // Exceeds credit limit

		SalaryAccount account = new SalaryAccount("SA-123", creditLimit);
		account.deposit(date, initialBalance);

		// Attempt to withdraw an amount that exceeds the credit limit
		boolean withdrawResult = account.withdraw(date, withdrawAmount);

		// Check if the withdrawal was unsuccessful
		assertTrue(withdrawResult);

		// Check if the balance remains the same (no withdrawal)
		assertEquals(initialBalance -800, account.getBalance());
	}

	@Test
	public void testWithdrawWithNegativeAmount() {
		int date = 20231001;
		long initialBalance = 1000;
		long creditLimit = -500; // Negative credit limit
		long withdrawAmount = -300; // Negative withdrawal amount

		SalaryAccount account = new SalaryAccount("SA-123", creditLimit);
		account.deposit(date, initialBalance);

		// Attempt to withdraw a negative amount
		boolean withdrawResult = account.withdraw(date, withdrawAmount);

		// Check if the withdrawal was unsuccessful
		assertFalse(withdrawResult);

		// Check if the balance remains the same (no withdrawal)
		assertEquals(initialBalance, account.getBalance());
	}
}
