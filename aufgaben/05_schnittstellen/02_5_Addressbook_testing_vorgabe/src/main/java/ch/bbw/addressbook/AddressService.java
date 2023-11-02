package ch.bbw.addressbook;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AddressService {

	private final AddressDAO addressDAO;

	@Autowired
	public AddressService(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	public List<Address> getAllAddresses() {
		List<Address> addresses = addressDAO.readAll();
		
		return addresses.stream().sorted(new AddressLastnameComparator()).toList();
	}
	public Address getAddressById(int id) {
		return addressDAO.read(id);
	}

	public Address registerAddress(Address address) {
		address.setRegistrationDate(new Date());
		return addressDAO.create(address);
	}
	public Address updateAddress(Address address, int id) {
		address.setId(id);
		return addressDAO.update(address);
	}

	public void deleteById(int id) {
		addressDAO.delete(id);
	}

	@Override
	public String toString() {
		return "Using database with id: " + addressDAO.getUniqueId();
	}
}
