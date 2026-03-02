package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

import org.junit.jupiter.api.Test;
import Appointment.Appointment;

class AppointmentTest {

	

    private Date futureDate() {
    	return new Date(System.currentTimeMillis() + 86_400_000L); // +1 Day.
    }
	
    private Date pastDate() {
    	return new Date(System.currentTimeMillis() - 86_400_000L); // -1 Day.
    }
    
	@Test
	void testGoodAppointment() {
		Date appDate = futureDate();
		String appDescrip = "Proper length description";
		
		Appointment appointment = new Appointment(appDate, appDescrip);
		
		assertEquals(appDate, appointment.getAppDate());
		assertEquals(appDescrip, appointment.getAppDescrip());
		assertNotNull(appointment.getAppointmentID());
	}

	@Test
	void testBadDateInPast() {
		Date appDate = pastDate();
		String appDescrip = "Good Description";
		
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(appDate, appDescrip);
		});
		assertEquals("Invalid Appointment Date", ex.getMessage());	
		
		Appointment appointment = new Appointment(futureDate(), appDescrip); 
		
		ex = assertThrows(IllegalArgumentException.class, () -> {
			appointment.setAppDate(appDate);
		});
		assertEquals("Invalid Appointment Date", ex.getMessage());
	}
	
	@Test
	void testNullDate() {
		String appDescrip = "Good Description";

		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, appDescrip);
		});
		assertEquals("Invalid Appointment Date", ex.getMessage());
		
		Appointment appointment = new Appointment(futureDate(), appDescrip);
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			appointment.setAppDate(null);
		});
		assertEquals("Invalid Appointment Date", exception.getMessage());
	}
	
	@Test
	void testTooLongDescription() {
		Date appDate = futureDate();
		String badAppDescrip = "This description needs to be way to long so it gives an error" +
							"So we are going to write two or three lines so it causes an error" +
							"I am adding a new line of description because it isnt throwing an exception";

		IllegalArgumentException ex =  assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(appDate, badAppDescrip);
		});
		assertEquals("Invalid Description", ex.getMessage());
		
		Appointment appointment = new Appointment(appDate, "Initialized");
		
		ex = assertThrows(IllegalArgumentException.class, () -> {
			appointment.setAppDescrip(badAppDescrip);
		});
		assertEquals("Invalid Description", ex.getMessage());
	}

    @Test
    void testNullDescription() {
        Date appDate = futureDate();

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appDate, null);
        });
        assertEquals("Invalid Description", ex.getMessage());
        
        Appointment appointment = new Appointment(appDate, "Initialized");
        ex = assertThrows(IllegalArgumentException.class, () -> {
        	appointment.setAppDescrip(null);
        });
    }

    @Test
    void testSetters_successfullyUpdate() {
        Appointment appointment = new Appointment(futureDate(), "Old");

        Date newFuture = new Date(System.currentTimeMillis() + 120_000);
        appointment.setAppDate(newFuture);
        appointment.setAppDescrip("New description");

        assertEquals(newFuture, appointment.getAppDate());
        assertEquals("New description", appointment.getAppDescrip());
    }
	
}
