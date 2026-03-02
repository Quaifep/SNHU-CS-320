package Contact;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class ContactService {
	/*
	 ****Changing to a MAP like suggested, but leaving code
	public ArrayList<Contact> contactList = new ArrayList<Contact>();
	
	public ArrayList<Contact> getListOfContacts() {
			return contactList;
	}
	
	public void addContact(String firstName, String lastName, String address, String phoneNum) {
		Contact contact = new Contact(firstName, lastName, address, phoneNum);
		contactList.add(contact);
	} 
	*/
	
	private final Map<String, Contact> contacts = new HashMap<>();
	
	public Collection<Contact> getAllContacts() {
		return contacts.values();
	}
	
	public int size() {
		return contacts.size();
	}
	
	public String addContact(String firstName, String lastName, String address, String phoneNum) {
		
		Contact contact = new Contact(firstName, lastName, address, phoneNum);
		String id = contact.getid();
		
		if (contacts.containsKey(id)) {
			throw new IllegalArgumentException("Duplicate Contact ID");
		}
		
		contacts.put(id, contact);
		return id;
	}
	
	public Contact getContactByID(String id) {
		if (!contacts.containsKey(id)) {
			throw new IllegalArgumentException("Contact ID Not Found");
		}
		return contacts.get(id);
	}
	
	public void deleteContact(String id) {
		if (!contacts.containsKey(id)) {
			throw new IllegalArgumentException("Contact ID Not Found");
		}
		contacts.remove(id);
	}
	
	public void updatefirstName(String updateString, String id) {
			getContactByID(id).setfirstName(updateString);
	}
	
	public void updatelastName(String updateString, String id) {
		getContactByID(id).setlastName(updateString);
	}
	
	public void updatephoneNum(String updateString, String id) {
		getContactByID(id).setphoneNum(updateString);
	}
	
	public void updateaddress(String updateString, String id) {
		getContactByID(id).setaddress(updateString);
	}

}

