package ch.schule.bank.junit5;

import ch.schule.SavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTests {

	@Test
	public void testWithdrawSufficientBalance() {
		// Create a savings account with an initial balance of 1000 Millirappen (10 CHF)
		SavingsAccount savingsAccount = new SavingsAccount("S-1001");
		savingsAccount.deposit(1, 1000);

		// Attempt to withdraw 500 Millirappen (5 CHF)
		boolean result = savingsAccount.withdraw(2, 500);

		// The withdrawal should be successful
		assertTrue(result);

		// Verify that the balance has been updated correctly
		assertEquals(500, savingsAccount.getBalance());
	}

	@Test
	public void testWithdrawInsufficientBalance() {
		// Create a savings account with an initial balance of 500 Millirappen (5 CHF)
		SavingsAccount savingsAccount = new SavingsAccount("S-1002");
		savingsAccount.deposit(1, 500);

		// Attempt to withdraw 1000 Millirappen (10 CHF) with insufficient balance
		boolean result = savingsAccount.withdraw(2, 1000);

		// The withdrawal should fail due to insufficient balance
		assertFalse(result);

		// The balance should remain the same
		assertEquals(500, savingsAccount.getBalance());
	}

	@Test
	public void testWithdrawNegativeAmount() {
		// Create a savings account with an initial balance of 1000 Millirappen (10 CHF)
		SavingsAccount savingsAccount = new SavingsAccount("S-1003");
		savingsAccount.deposit(1, 1000);

		// Attempt to withdraw a negative amount, which should fail
		boolean result = savingsAccount.withdraw(2, -200);

		// The withdrawal should fail due to a negative amount
		assertFalse(result);

		// The balance should remain the same
		assertEquals(1000, savingsAccount.getBalance());
	}
}
