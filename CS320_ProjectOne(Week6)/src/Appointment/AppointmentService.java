package Appointment;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    private final Map<String, Appointment> appMap = new HashMap<>();

    public int size() {
        return appMap.size();
    }

    public String addAppointment(Date appDate, String appDescrip) {
        Appointment appointment = new Appointment(appDate, appDescrip);
        String id = appointment.getAppointmentID();

        if (appMap.containsKey(id)) {
            throw new IllegalArgumentException("Duplicate Appointment ID");
        }

        appMap.put(id, appointment);
        return id;
    }

    public Appointment getAppointmentByID(String appointmentID) {
        if (appointmentID == null) {
            throw new IllegalArgumentException("Appointment ID not Found");
        }

        Appointment found = appMap.get(appointmentID);
        if (found == null) {
            throw new IllegalArgumentException("Appointment ID not Found");
        }
        return found;
    }

    public void deleteAppointment(String appointmentID) {
        if (appointmentID == null) {
            throw new IllegalArgumentException("Appointment ID not Found");
        }

        if (!appMap.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID not Found");
        }

        appMap.remove(appointmentID);
    }
}
