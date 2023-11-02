package ch.bbw.addressbook;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddressbookAddressDAOTests {

	// @Autowired
	// public AddressDAO_Database address;
	@Autowired
	public AddressDAO_Memory address;

	@Test
	@DisplayName("Check if the Test-Data is accessible")
	void dataAccessible() {
		assertNotNull(address.read(1));
	}

	@Test
	@DisplayName("Test read by id")
	void getAddress() {
		Address foundAddress = address.read(1);
		assertNotNull(foundAddress);
		assertEquals(1, foundAddress.getId());
		assertEquals("Price", foundAddress.getFirstname());
		assertEquals("Case", foundAddress.getLastname());
		assertEquals("1-684-781-7482", foundAddress.getPhonenumber());

		assertEquals(0,
				foundAddress.getRegistrationDate()
						.compareTo(new Date(2024 - 1900, Calendar.OCTOBER, 14)));
	}

	@Test
	@DisplayName("Test creation of a new Address")
	void createAddress() {
		Address newAddress = new Address(
				0,
				"Test",
				"Tester",
				"1-369-891-1387",
				new Date(2022 - 1900, Calendar.JUNE, 11));
		Address createdAddress = address.create(newAddress);

		assertNotNull(createdAddress);
		assertNotNull(address.read(createdAddress.getId()));
	}

	@Test
	@DisplayName("Test update to an Address")
	void updateAddress() {
		final String newLastName = "ChangedLastName";

		Address foundAddress = address.read(3);
		foundAddress.setLastname(newLastName);
		Address updatedAddress = address.update(foundAddress);

		assertNotNull(address.read(updatedAddress.getId()));
		assertEquals(newLastName, address.read(updatedAddress.getId()).getLastname());
	}

	@Test
	@DisplayName("Test delete on an Address")
	void deleteAddress() {
		address.delete(4);
		Address shouldNotExist = address.read(4);

		assertNull(shouldNotExist);
	}

	@Test
	@DisplayName("Test get All Addresses")
	void getAllAddress() {
		assertFalse(address.readAll().isEmpty());
	}

	@BeforeAll
	//Ersatz für @BeforeEach
	void beforeAll() {
		assertTrue(address.isAvailable());
		address.deleteAll();

		address.create(new Address(
				0,
				"Robin",
				"Tyler",
				"1-364-341-3933",
				new Date(2021 - 1900, Calendar.NOVEMBER, 24)));
		address.create(new Address(
				1,
				"Price",
				"Case",
				"1-684-781-7482",
				new Date(2024 - 1900, Calendar.OCTOBER, 14)));
		address.create(new Address(
				2,
				"Leah",
				"Golden",
				"1-345-215-7455",
				new Date(2022 - 1900, Calendar.MAY, 2)));
		address.create(new Address(
				3,
				"Holly",
				"Soto",
				"1-321-224-7378",
				new Date(2022 - 1900, Calendar.SEPTEMBER, 4)));
		address.create(new Address(
				4,
				"Bruno",
				"Hunt",
				"1-841-793-5991",
				new Date(2022 - 1900, Calendar.MARCH, 5)));
	}

}
