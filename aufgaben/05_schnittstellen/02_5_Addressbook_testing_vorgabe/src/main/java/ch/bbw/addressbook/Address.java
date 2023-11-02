package ch.bbw.addressbook;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Address {

	private int id;
	private String firstname;
    private String lastname;
    private String phonenumber;
    private Date registrationDate;

    public Address(int id, String firstname, String lastname, String phonenumber) {
    	this(id, firstname, lastname, phonenumber, null);
    }
    public Address(int id, String firstname, String lastname, String phonenumber, Date registrationDate) {
    	this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.registrationDate = registrationDate;
    }
}
