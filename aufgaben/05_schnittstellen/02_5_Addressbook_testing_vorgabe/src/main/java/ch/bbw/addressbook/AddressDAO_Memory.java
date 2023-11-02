package ch.bbw.addressbook;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class AddressDAO_Memory implements AddressDAO {

	private List<Address> addresses = new ArrayList<>();
	// not using .size() -> could lead to same ids when deleting
	private int idCounter = 0;
	private int getNewId() { return idCounter++; }

	@Override
	public boolean isAvailable() {
		return addresses != null;
	}
	@Override
	public int getUniqueId() {
		return 0;
	}

	public Address create(Address address) {
		address.setId(getNewId());
		addresses.add(address);
		return address;
	}
	
	public Address read(int id) {
		Optional<Address> foundAddres = addresses.stream().filter(ele -> ele.getId() == id).findFirst();
		return foundAddres.orElse(null);
	}
	public List<Address> readAll() {
		return addresses;
	}

	public Address update(Address address) {
		for (int i = 0; i < addresses.size(); i++) {
			if (addresses.get(i).getId() == address.getId()) {
				addresses.set(i, address);
				return address;
			}
		}
		return null;
	}
	
	public void delete(int id) {
		for (int i = 0; i < addresses.size(); i++) {
			if (addresses.get(i).getId() == id) {
				addresses.remove(i);
				break;
			}
		}
	}

	@Override
	public void deleteAll() {
		addresses.clear();
	}
}
