package snhu.contact;

import java.util.Date;

public class Appointment {
	private String appointmentID;
	private Date date;
	private String description;
	
	@SuppressWarnings("unused")
	private Appointment() {} // Private constructor so only parameterized can be used.
	
	public Appointment(String appointmentID, Date date, String description) {
		
		if(appointmentID == null || appointmentID.isEmpty()) { // Check if ID is empty.
			// Throw exception if ID is empty.
			throw new IllegalArgumentException("ID cannot be empty.");
		}
		else if(appointmentID.length() > 10 ) { // Check length of ID.
			// Throw exception if ID is too long.
			throw new IllegalArgumentException("ID longer than 10 characters.");
		}
		else { 
			this.appointmentID = appointmentID;
		}
		
		setDate(date);
		setDescription(description);
		
	}
	
	// Accessors 
	
	public String getAppointmentID() {
		return this.appointmentID;
	}
	// ***********************************************************
	public Date getDate() {
		return this.date;
	}
	// ***********************************************************
	public String getDescription() {
		return this.description;
	}

	// Mutators for name and description.
	
	public void setDate(Date date) {
		
		if(date == null) { // Check if date is empty.
			// Throw exception if Name is empty.
			throw new IllegalArgumentException("Date cannot be empty.");
		}
		else if(date.before(new Date())) { // Check if date is in the past
			// Throw exception if Name is too long.
			throw new IllegalArgumentException("Date cannot be in the past.");
		}
		else {
			this.date = date;
		}
		
	}
	// ***********************************************************
	public void setDescription(String description) {
		if(description == null || description.isEmpty()) { // Check if Last Name is empty.
			// Throw exception if description is empty.
			throw new IllegalArgumentException("Description cannot be empty.");
		}
		else if(description.length() > 50 ) { // Check length of Last Name.
			// Throw exception if description is too long.
			throw new IllegalArgumentException("Description longer than 50 characters.");
		}
		else {  
			this.description = description;
		}
	}

}
