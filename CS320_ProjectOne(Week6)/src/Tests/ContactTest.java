package Tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Contact.Contact;

class ContactTest {

	//Test confirms that initial constructor inputs are accepted by Contact Class.
	@Test
	void testContact() {
		Contact contact = new Contact("fName", "lName", "1234 Random Way", "5555555555");
		assertTrue(contact.getfirstName().equals("fName"));
		assertTrue(contact.getlastName().equals("lName"));
		assertTrue(contact.getaddress().equals("1234 Random Way"));
		assertTrue(contact.getphoneNum().equals("5555555555"));
		assertNotNull(contact.getid());
		assertTrue(contact.getid().length() <= 10); 
	}
	
	// ----Null Tests----
	
	@Test
	void testConstructorRejectsNullFirstName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "lname", "1234 Random Way", "5555555555");
		});
	}
	
	@Test
	void testConstructorRejectsNullLastName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("fName", null, "1234 Random Way", "5555555555");
		});
	}
	
	@Test
	void testConstructorRejectsNullAddress() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FName", "lname", null, "5555555555");
		});
	}
	
	@Test
	void testConstructorRejectsNullLPhoneNum() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("fName", "lname", "1234 Random Way", null);
		});
	}
	
	// ----Length Tests----
	
	@Test
	void testFirstNameInput() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("First Name is too long", "lName", "1234 Random Way", "5555555555");
		});
	}
	
	@Test
	void testLastNameInput() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("fName", "Last Name is too long", "1234 Random Way", "5555555555");
		});
	}

	@Test
	void testAddressInput() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("fName", "lName", "1234 Random Way but lets add characters to be too long", "5555555555");
		});
	}
	
	@Test
	void testPhoneNumInput() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("fName", "lName", "1234 Random Way", "123");
		});
	}
	
    @Test
    void testConstructorAcceptsMaxLengths() {
        String f10 = "1234567890";                    // 10
        String l10 = "abcdefghij";                    // 10
        String a30 = "123456789012345678901234567890"; // 30
        String p10 = "0123456789";                    // 10

        Contact contact = new Contact(f10, l10, a30, p10);

        assertEquals(f10, contact.getfirstName());
        assertEquals(l10, contact.getlastName());
        assertEquals(a30, contact.getaddress());
        assertEquals(p10, contact.getphoneNum());
    }

	@Test
	void testSetFirstNameValidAndInvalid() {
		Contact contact = new Contact("fName", "lName", "1234 Random Way", "5555555555");

		contact.setfirstName("NewName");
		assertEquals("NewName", contact.getfirstName());

		assertThrows(IllegalArgumentException.class, () -> contact.setfirstName(null));
		assertThrows(IllegalArgumentException.class, () -> contact.setfirstName("FirstNameTooLong"));
	}

	@Test
	void testSetLastNameValidAndInvalid() {
		Contact contact = new Contact("fName", "lName", "1234 Random Way", "5555555555");

		contact.setlastName("NewLast");
		assertEquals("NewLast", contact.getlastName());

		assertThrows(IllegalArgumentException.class, () -> contact.setlastName(null));
		assertThrows(IllegalArgumentException.class, () -> contact.setlastName("LastNameTooLonggg"));
	}

	@Test
	void testSetAddressValidAndInvalid() {
		Contact contact = new Contact("fName", "lName", "1234 Random Way", "5555555555");

		contact.setaddress("9876 Updated Address");
		assertEquals("9876 Updated Address", contact.getaddress());

		assertThrows(IllegalArgumentException.class, () -> contact.setaddress(null));
		assertThrows(IllegalArgumentException.class, () -> contact.setaddress("1234567890123456789012345678901"));
	}

	@Test
	void testSetPhoneNumValidAndInvalid() {
		Contact contact = new Contact("fName", "lName", "1234 Random Way", "5555555555");

		contact.setphoneNum("4444444444");
		assertEquals("4444444444", contact.getphoneNum());

		assertThrows(IllegalArgumentException.class, () -> contact.setphoneNum(null));
		assertThrows(IllegalArgumentException.class, () -> contact.setphoneNum("123"));
		assertThrows(IllegalArgumentException.class, () -> contact.setphoneNum("12345678901"));
	}
	
}
