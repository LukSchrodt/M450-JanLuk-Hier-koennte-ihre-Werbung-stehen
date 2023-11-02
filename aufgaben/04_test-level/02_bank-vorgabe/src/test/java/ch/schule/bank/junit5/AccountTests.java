package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTests {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account("12345");
    }

    @Test
    public void testInit() {
        assertNotNull(account);
        assertEquals("12345", account.getId());
        assertEquals(0, account.getBalance());
    }

    @Test
    public void testDeposit() {
        assertTrue(account.deposit(20231003, 1000));
        assertEquals(1000, account.getBalance());
        assertTrue(account.deposit(20231004, 500));
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        assertTrue(account.deposit(20231003, 1000));
        assertTrue(account.withdraw(20231004, 500));
        assertEquals(500, account.getBalance());
    }

    @Test
    public void testWithdrawNegativeAmount() {
        assertFalse(account.withdraw(20231003, -500));
        assertEquals(0, account.getBalance());
    }

    @Test
    public void testCanTransact() {
        assertTrue(account.canTransact(20231003));
        assertTrue(account.deposit(20231003, 1000));
        assertFalse(account.canTransact(20231002));
        assertTrue(account.canTransact(20231003));
        assertTrue(account.canTransact(20231004));
    }


    // Additional tests for the print(int year, int month) method can be added similarly.
}

