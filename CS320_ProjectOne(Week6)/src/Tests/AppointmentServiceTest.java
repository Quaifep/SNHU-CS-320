package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;

import Appointment.AppointmentService;

class AppointmentServiceTest {

    private Date futureDate() {
        return new Date(System.currentTimeMillis() + 86_400_000L); // +1 Day.
    }

    @Test
    void addAppointment_increasesSize() {
        AppointmentService service = new AppointmentService();
        String id = service.addAppointment(futureDate(), "Desc");

        assertNotNull(id);
        assertEquals(1, service.size());
        assertNotNull(service.getAppointmentByID(id));
    }

    @Test
    void getAppointmentByIDNullThrows() {
    	AppointmentService service = new AppointmentService();
    	assertThrows(IllegalArgumentException.class, () -> service.getAppointmentByID(null));
    }
    
    @Test
    void deleteAppointmentByIDNullThrows() {
    	AppointmentService service = new AppointmentService();
    	assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment(null));
    }
    
    @Test
    void deleteAppointment_existingId_removes() {
        AppointmentService service = new AppointmentService();
        String id = service.addAppointment(futureDate(), "Desc");

        service.deleteAppointment(id);

        assertEquals(0, service.size());
        assertThrows(IllegalArgumentException.class, () -> service.getAppointmentByID(id));
    }

    @Test
    void deleteAppointment_missingId_throws() {
        AppointmentService service = new AppointmentService();

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("does-not-exist");
        });

        assertEquals("Appointment ID not Found", ex.getMessage());
    }

    @Test
    void getAppointmentByID_missingId_throws() {
        AppointmentService service = new AppointmentService();

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            service.getAppointmentByID("nope");
        });

        assertEquals("Appointment ID not Found", ex.getMessage());
    }
}