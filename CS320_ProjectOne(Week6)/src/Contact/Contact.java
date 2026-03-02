/**************************
 * Paul R Quaife
 * CS-320
 * Feb 23rd, 2026
 * Module 3 - Milestone 1
 */

package Contact;

import java.util.concurrent.atomic.*;


public class Contact {

	private final String id;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNum;
	private static AtomicLong Generator = new AtomicLong();

	public Contact(String firstName, String lastName, String address, String phoneNum) {
	
		//Creates random ID Number to assign.
		this.id = String.valueOf(Generator.getAndIncrement());
	
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		if (phoneNum == null || phoneNum.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNum = phoneNum;
	}
	// Getters
	

	public void setfirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = firstName;
	}
	
	public void setlastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.lastName = lastName;
	}
	
	public void setaddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.address = address;
	}
	
	public void setphoneNum(String phoneNum) {
		if (phoneNum == null || phoneNum.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		this.phoneNum = phoneNum;
	}
	
	public String getid() {
		return id;
	}

	public String getfirstName() {
		return firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public String getaddress() {
		return address;
	}

	public String getphoneNum() {
		return phoneNum;
	}

}
