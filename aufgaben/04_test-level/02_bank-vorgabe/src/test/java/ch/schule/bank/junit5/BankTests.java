package ch.schule.bank.junit5;

import ch.schule.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTests {

    private Bank bank;
    private String accountId;

    @BeforeEach
    public void setup() {
        bank = new Bank();
        accountId = bank.createSavingsAccount();
    }

    @Test
    public void testCreateSavingsAccount() {
        assertNotNull(accountId);
    }

    @Test
    public void testCreatePromoYouthSavingsAccount() {
        String youthAccountId = bank.createPromoYouthSavingsAccount();
        assertNotNull(youthAccountId);
    }

    @Test
    public void testCreateSalaryAccount() {
        String salaryAccountId = bank.createSalaryAccount(-500); // Negative credit limit
        assertNotNull(salaryAccountId);

        String invalidAccountId = bank.createSalaryAccount(500); // Positive credit limit (should return null)
        assertNull(invalidAccountId);
    }

    @Test
    public void testGetBalance() {
        long initialBalance = bank.getBalance();
        assertEquals(0, initialBalance);

        long depositAmount = 1000;
        assertTrue(bank.deposit(accountId, 20231001, depositAmount));
        long updatedBalance = bank.getBalance();
        assertEquals(depositAmount *-1, updatedBalance);

        long withdrawAmount = 500;
        assertTrue(bank.withdraw(accountId, 20231002, withdrawAmount));
        long finalBalance = bank.getBalance();
        assertEquals(depositAmount - withdrawAmount, finalBalance *-1);
    }

    @Test
    public void testGetBalanceWithInvalidAccount() {
        long balance = bank.getBalance("NonExistentAccount");
        assertEquals(0, balance);
    }

    @Test
    public void testDeposit() {
        long depositAmount = 1000;
        assertTrue(bank.deposit(accountId, 20231001, depositAmount));
        long balance = bank.getBalance(accountId);
        assertEquals(depositAmount, balance);
    }

    @Test
    public void testWithdraw() {
        long initialBalance = bank.getBalance(accountId);
        long withdrawAmount = 500;
        assertFalse(bank.withdraw(accountId, 20231002, withdrawAmount));
        long finalBalance = bank.getBalance(accountId);
        assertEquals(initialBalance - withdrawAmount +500, finalBalance);
    }

    @Test
    public void testWithdrawWithInsufficientFunds() {
        long initialBalance = bank.getBalance(accountId);
        long withdrawAmount = initialBalance + 100; // Attempt to withdraw more than available
        assertFalse(bank.withdraw(accountId, 20231002, withdrawAmount));
        long finalBalance = bank.getBalance(accountId);
        assertEquals(initialBalance, finalBalance); // Balance should remain the same
    }

    @Test
    public void testPrint() {
        // Ensure there's no exception when printing
        bank.print(accountId);
    }

    @Test
    public void testPrintWithInvalidAccount() {
        // Ensure there's no exception when attempting to print an invalid account
        bank.print("NonExistentAccount");
    }

    @Test
    public void testPrintTop5() {
        // Ensure there's no exception when printing top 5 accounts
        bank.printTop5();
    }

    @Test
    public void testPrintBottom5() {
        // Ensure there's no exception when printing bottom 5 accounts
        bank.printBottom5();
    }
}
