package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Contact.ContactService;
import Contact.Contact;

class ContactServiceTest { 

	@Test
	void testAddContactToMapReturnsID() {
		ContactService service = new ContactService();
		String id = service.addContact("fName", "lName", "1234 Random Way", "5555555555");
		assertNotNull(id);
		assertEquals(1, service.size());
		
		Contact added = service.getContactByID(id);
		assertEquals("fName", added.getfirstName());
		assertEquals("lName", added.getlastName());
		assertEquals("1234 Random Way", added.getaddress());
		assertEquals("5555555555", added.getphoneNum());
	}
	
	@Test
	void testGetAllContactsReturnsALL() {
		ContactService service = new ContactService();
		service.addContact("fName", "lName", "1234 Random Way", "5555555555");
		
		assertEquals(1, service.getAllContacts().size());
		assertNotNull(service.getAllContacts().iterator().next());
	}
	
	@Test
	void testGetContactbyIDReturnsCorrectContact() {
		ContactService service = new ContactService();
		
		String id1 = service.addContact("Alpha", "One", "Address A", "1111111111");
		String id2 = service.addContact("Bravo", "Two", "Address B", "2222222222");
		
		Contact c1 = service.getContactByID(id1);
		Contact c2 = service.getContactByID(id2);
		
		assertEquals("Alpha", c1.getfirstName());
		assertEquals("Bravo", c2.getfirstName());
	}
	
	@Test
	void testGetContactByIDThrowsWhenNotFound() {
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> service.getContactByID("FakeId"));
	}
	
	@Test
	void testDeleteContactRemovesContact() {
		ContactService service = new ContactService();
		
		String id = service.addContact("fName", "lName", "1234 Random Way", "5555555555");
		service.deleteContact(id);
		
		assertEquals(0, service.size());
		assertThrows(IllegalArgumentException.class, () -> service.getContactByID(id));
	}
	
	@Test
	void testDeleteContactThrowsWhenNotFound() {
	    ContactService service = new ContactService();
	    assertThrows(IllegalArgumentException.class, () -> service.deleteContact("FakeId"));
	}
	
	@Test
	void testUpdateFirstName() {
		ContactService service = new ContactService();
		
		String id = service.addContact("fName", "lName", "1234 Random Way", "5555555555");
		service.updatefirstName("NewName", id);
		
		assertEquals("NewName", service.getContactByID(id).getfirstName());
	}
	
	@Test
	void testUpdateLastName() {
		ContactService service = new ContactService();
		
		String id = service.addContact("fName", "lName", "1234 Random Way", "5555555555");
		service.updatelastName("NewName", id);
		
		assertEquals("NewName", service.getContactByID(id).getlastName());
	}
	
	@Test
	void testUpdateAddress() {
		ContactService service = new ContactService();
		
		String id = service.addContact("fName", "lName", "1234 Random Way", "5555555555");
		service.updateaddress("New Address", id);
		
		assertEquals("New Address", service.getContactByID(id).getaddress());
	}
	
	@Test
	void testUpdatePhoneNumber() {
		ContactService service = new ContactService();
		
		String id = service.addContact("fName", "lName", "1234 Random Way", "5555555555");
		service.updatephoneNum("1111111111", id);
		
		assertEquals("1111111111", service.getContactByID(id).getphoneNum());
	}
	
	@Test
	void testUpdateThrowsWhenIdNotFound() {
		ContactService service = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> service.updatefirstName("NewName", "FakeId"));
	}
	
	
}












