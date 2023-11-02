package ch.bbw.addressbook;

import java.util.List;

public interface AddressDAO {

	// for testing
	public boolean isAvailable();
	public int getUniqueId();
	// CRUD Commands: Create Read Update Delete
	public Address create(Address address);
	public Address read(int id);
	public List<Address> readAll();
	public Address update(Address address);
	public void delete(int id);
	// Clear Table (Used for Testing, better used carefully)
	public void deleteAll();

}