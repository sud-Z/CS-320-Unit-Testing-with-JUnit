package snhu.contact;

import java.util.HashMap;
import java.util.Date;

public class AppointmentService {
	// Map to hold Appointments.
	public HashMap<String, Appointment> appointmentMap;
	public Appointment appointment;
	
	public AppointmentService() {
		this.appointment = null;
		this.appointmentMap = new HashMap<String, Appointment>();
	}
	
	// Method to add Appointments.
	public void addAppointment(String appointmentID, Date date, String description) {
		
		// Check if Appointment already exists.
		if(appointmentMap.containsKey(appointmentID)) {
			throw new IllegalArgumentException("Appointment already exists.");
		}
		else {
			try {
				// Create Appointment.
				appointment = new Appointment(appointmentID, date, description);
			}
			catch(IllegalArgumentException e) {
				// Catch error and pass it on.
				throw e;
			}
			// Add Appointment to map.
			appointmentMap.put(appointmentID, appointment);
		}
		
	}
	
	
	// Method to remove Appointment from map.
	public void removeAppointment(String appointmentID) {
		
		// Check if Appointment exists.
		if(appointmentMap.containsKey(appointmentID)) {
			appointmentMap.remove(appointmentID);
		}
		else {
			throw new IllegalArgumentException("Appointment does not exist.");
		}
		
	}
	
	
	// Methods to update date and description
	public void updateDate(String appointmentID, Date date) {
		
		if(appointmentMap.containsKey(appointmentID)) {
			
			try {
				// Update date.
				appointmentMap.get(appointmentID).setDate(date);
			}
			catch(IllegalArgumentException e) {
				// Catch error and pass it on.
				throw e;
			}
			
		}
		else {
			throw new IllegalArgumentException("Appointment does not exist.");
		}
	}
	
	public void updateDescription(String appointmentID, String description) {
		
		if(appointmentMap.containsKey(appointmentID)) {
			
			try {
				// Update description.
				appointmentMap.get(appointmentID).setDescription(description);
			}
			catch(IllegalArgumentException e) {
				// Catch error and pass it on.
				throw e;
			}
			
		}
		else {
			throw new IllegalArgumentException("Appointment does not exist.");
		}
	}
	
	// Method to get Appointment from map.
	public Appointment getAppointment(String appointmentID) {
		
		if(appointmentMap.containsKey(appointmentID)) {
			return appointmentMap.get(appointmentID);
		}
		else {
			throw new IllegalArgumentException("Appointment does not exist.");
		}
	}
	
}
