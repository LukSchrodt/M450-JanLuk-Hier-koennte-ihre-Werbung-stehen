package ch.schule.bank.junit5;

import ch.schule.BankUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankUtilsTests {

    @Test
    public void testFormatBankDate() {
        // Test with a date representing 1st January 1970
        String formattedDate = BankUtils.formatBankDate(0);
        assertEquals("01.01.1970", formattedDate);

        // Test with a date representing 15th March 2023
        formattedDate = BankUtils.formatBankDate(19552); // 360 * 53 + 30 * 2 + 15
        assertEquals("23.04.2024", formattedDate);
    }

    @Test
    public void testFormatAmount() {
        // Test with a positive amount
        String formattedAmount = BankUtils.formatAmount(1234567);
        assertEquals("     12.35", formattedAmount);

        // Test with a negative amount
        formattedAmount = BankUtils.formatAmount(-987654);
        assertEquals("     -9.88", formattedAmount);

        // Test with zero
        formattedAmount = BankUtils.formatAmount(0);
        assertEquals("      0.00", formattedAmount);
    }
}
