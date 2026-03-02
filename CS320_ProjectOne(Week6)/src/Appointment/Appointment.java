package Appointment;

import java.util.Date;
import java.util.concurrent.atomic.*;



public class Appointment {

	private final String appointmentID;
	private Date appDate;
	private String appDescrip;
	private static AtomicLong Generator = new AtomicLong();
	
	
	
	public Appointment(Date appDate, String appDescrip) {
		
		String generateID = String.valueOf(Generator.getAndIncrement());
		
		if (generateID == null || generateID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if (appDate == null || appDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid Appointment Date");
		}	
		
		if (appDescrip == null || appDescrip.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		this.appointmentID = generateID;
		this.appDate = appDate;
		this.appDescrip = appDescrip; 
	}

	public void setAppDate(Date appDate) {
		if (appDate == null || appDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid Appointment Date");
		}
		this.appDate = appDate;
	}
	
	public void setAppDescrip(String appDescrip) {
		if (appDescrip == null || appDescrip.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		this.appDescrip = appDescrip;
	}
	
	public String getAppointmentID() {
		return appointmentID;
	}
	
	public Date getAppDate() {
		return appDate;
	}
	
	public String getAppDescrip() {
		return appDescrip;
	}
	
	
}
