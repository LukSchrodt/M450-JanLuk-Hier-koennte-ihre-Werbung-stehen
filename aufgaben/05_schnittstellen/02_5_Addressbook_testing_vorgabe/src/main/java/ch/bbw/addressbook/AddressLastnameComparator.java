package ch.bbw.addressbook;

import java.util.Comparator;

public class AddressLastnameComparator implements Comparator<Address> {

	@Override
	public int compare(Address a1, Address a2) {
		int i = a1.getLastname().compareTo(a2.getLastname());
		if (i != 0) return i;

		i = a1.getFirstname().compareTo(a2.getFirstname());
		if (i != 0) return i;

		return a1.getRegistrationDate().compareTo(a2.getRegistrationDate());
	}

}
