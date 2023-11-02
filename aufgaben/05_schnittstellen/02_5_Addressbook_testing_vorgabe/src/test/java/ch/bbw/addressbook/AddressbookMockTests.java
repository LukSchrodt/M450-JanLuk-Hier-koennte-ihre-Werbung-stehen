package ch.bbw.addressbook;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddressbookMockTests {

    @Mock
    public AddressDAO addressDAO;

    @InjectMocks
    public AddressService service;

    @Test
    @DisplayName("Test assigning a new Date to new Entries")
    void createTest() {
        Address mockObject = new Address(
                mockedAddressList.get(0).getId(),
                mockedAddressList.get(0).getFirstname(),
                mockedAddressList.get(0).getLastname(),
                mockedAddressList.get(0).getPhonenumber(),
                new Date()
        ); // Needed for clone: Would otherwise override date and falsify testing data

        when(addressDAO.create(any(Address.class)))
                .thenAnswer(invocation -> invocation.getArgument(0, Address.class));
        Address returnAddress = service.registerAddress(mockObject);

        assertEquals("Tyler", returnAddress.getLastname());
        // New Date got Generated
        assertTrue(returnAddress.getRegistrationDate().after(mockedAddressList.get(0).getRegistrationDate()));
    }

    @Test
    @DisplayName("Test update Mock and setting of correct Id")
    void updateTest() {
        Address mockObject = mockedAddressList.get(1);
        mockObject.setId(5);
        when(addressDAO.update(any(Address.class))).thenReturn(mockObject);

        mockObject.setId(0);
        Address returnAddress = service.updateAddress(mockObject, 5);

        assertEquals("Case", returnAddress.getLastname());
        assertEquals(5, returnAddress.getId());
    }

    int compare(Address current, Address previous) {
        int i = current.getLastname().compareTo(previous.getLastname());

        if (i != 0) return i;

        i = current.getFirstname().compareTo(previous.getFirstname());
        if (i != 0) return i;

        return current.getRegistrationDate().compareTo(previous.getRegistrationDate());
    }
    @Test
    @DisplayName("Test the compare of the Service")
    void compareTest() {
        when(addressDAO.readAll()).thenReturn(mockedAddressList);
        List<Address> addressList = service.getAllAddresses();

        assertFalse(addressList.isEmpty());

        Iterator<Address> iterator = addressList.iterator();
        Address current, previous = iterator.next();
        while (iterator.hasNext()) {
            current = iterator.next();

            assertTrue(0 < compare(current, previous));

            System.out.println(current.getFirstname());
            System.out.println(current.getLastname());
            System.out.println(current.getPhonenumber());
            System.out.println(current.getRegistrationDate().toString());

            previous = current;
        }
    }


    private final List<Address> mockedAddressList = List.of(
            new Address(
                    0, "Robin", "Tyler",
                    "1-364-341-3933",
                    new Date(2021 - 1900, Calendar.NOVEMBER, 24)),
            new Address(
                    1, "Price", "Case",
                    "1-684-781-7482",
                    new Date(2024 - 1900, Calendar.OCTOBER, 14)),
            new Address(
                    2, "Leah", "Golden",
                    "1-345-215-7455",
                    new Date(2022 - 1900, Calendar.MAY, 2)),
            new Address(
                    3, "Holly", "Soto",
                    "1-321-224-7378",
                    new Date(2022 - 1900, Calendar.SEPTEMBER, 4)),
            new Address(
                    4, "Bruno", "Hunt",
                    "1-841-793-5991",
                    new Date(2022 - 1900, Calendar.MARCH, 5))
    );
}
