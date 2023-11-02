package ch.schule.bank.junit5;

import ch.schule.PromoYouthSavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PromoYouthSavingsAccountTests {

	@Test
	public void testDepositWithBonus() {
		int date = 20231001;
		long initialBalance = 1000;
		long depositAmount = 500;

		PromoYouthSavingsAccount account = new PromoYouthSavingsAccount("PYSA-123");
		account.deposit(date, initialBalance);

		// Deposit with bonus
		boolean depositResult = account.deposit(date, depositAmount);

		// Check if the deposit was successful
		assertTrue(depositResult);

		// Calculate the expected balance after the deposit
		long expectedBalance = initialBalance + depositAmount + (depositAmount / 100); // 1% bonus

		// Check if the actual balance matches the expected balance
		assertEquals(expectedBalance, account.getBalance()-10);
	}

	@Test
	public void testDepositWithNegativeAmount() {
		int date = 20231001;
		long initialBalance = 1000;
		long depositAmount = -500;

		PromoYouthSavingsAccount account = new PromoYouthSavingsAccount("PYSA-123");
		account.deposit(date, initialBalance);

		// Attempt to deposit with a negative amount
		boolean depositResult = account.deposit(date, depositAmount);

		// Check if the deposit was unsuccessful
		assertFalse(depositResult);

		// Check if the balance remains the same
		assertEquals(initialBalance, account.getBalance()-10);
	}
}
