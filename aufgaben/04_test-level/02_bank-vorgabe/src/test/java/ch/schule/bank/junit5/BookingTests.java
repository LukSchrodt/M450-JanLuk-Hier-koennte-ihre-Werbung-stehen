package ch.schule.bank.junit5;

import ch.schule.Booking;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class BookingTests {

	@Test
	public void testGetDate() {
		int date = 20231001;
		long amount = 1000;
		Booking booking = new Booking(date, amount);
		assertEquals(date, booking.getDate());
	}

	@Test
	public void testGetAmount() {
		int date = 20231001;
		long amount = 1000;
		Booking booking = new Booking(date, amount);
		assertEquals(amount, booking.getAmount());
	}

	@Test
	public void testPrint() {
		int date = 20231001;
		long amount = 1000;
		long balance = 500;
		Booking booking = new Booking(date, amount);

		// Redirect standard output to capture printed content
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		booking.print(balance);

		// Reset standard output
		System.setOut(System.out);

		String printedOutput = outputStream.toString().trim();
		String expectedOutput = "22.03.58167       0.01       0.01"; // Modify this according to your expected format

		assertEquals(expectedOutput, printedOutput);
	}
}
