package ch.bbw.addressbook;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Getter
@Setter
public class AddressViewController {
	
	@Autowired
	private AddressService addressService;
	
    private String firstname;
    private String lastname;
    private String phoneNumber;

    private String message;

    public AddressViewController() {
    	message = "";
	}

    private void clearFields() {
        firstname = "";
        lastname = "";
        phoneNumber = "";    	
    }
    public void saveAddress() {
        Address address = new Address(0, firstname, lastname, phoneNumber);
        addressService.registerAddress(address);
        message = "The address was saved successfully.";
        clearFields();
    }
    public List<Address> getAddresses() {
        return addressService.getAllAddresses();
    }

}
