package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.AccountInverseBalanceComparator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountInverseBalanceComparatorTests {

    @Test
    public void testCompare() {
        // Create a list of Account objects with different balances
        Account account1 = new Account("1");
        Account account2 = new Account("2");
        Account account3 = new Account("3");
        Account account4 = new Account("4");

        // Add the accounts to a list
        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);

        // Sort the list using the AccountInverseBalanceComparator
        AccountInverseBalanceComparator comparator = new AccountInverseBalanceComparator();
        Collections.sort(accounts, comparator);

        // Verify that the accounts are sorted in ascending order by balance
        // Verify that the accounts are sorted in ascending order by balance
        assertEquals(account1, accounts.get(0), "First account should have the lowest balance");
        assertEquals(account2, accounts.get(1), "Second account should have the second-lowest balance");
        assertEquals(account3, accounts.get(2), "Third account should have the third-lowest balance");
        assertEquals(account4, accounts.get(3), "Fourth account should have the highest balance");

    }
}
