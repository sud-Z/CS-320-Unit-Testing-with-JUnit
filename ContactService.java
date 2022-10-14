package snhu.contact;

import java.util.HashMap;

public class ContactService {
	// Map to hold Contacts.
	public HashMap<String, Contact> contactMap;
	public Contact contact;
	
	public ContactService() {
		this.contact = null;
		this.contactMap = new HashMap<String, Contact>();
	}
	
	// Method to add contact.
	public void addContact(String contactID, String firstName, String lastName, String phone, String address) {
		
		// Check if contact already exists.
		if(contactMap.containsKey(contactID)) {
			throw new IllegalArgumentException("Contact already exists.");
		}
		else {
			try {
				// Create contact.
				contact = new Contact(contactID, firstName, lastName, phone, address);
			}
			catch(IllegalArgumentException e) {
				// Catch error and pass it on.
				throw e;
			}
			// Add contact to map.
			contactMap.put(contactID, contact);
		}
		
	}
	
	
	// Method to remove contact from map.
	public void removeContact(String contactID) {
		
		// Check if contact exists.
		if(contactMap.containsKey(contactID)) {
			contactMap.remove(contactID);
		}
		else {
			throw new IllegalArgumentException("Contact does not exist.");
		}
		
	}
	
	
	// Methods to update firstName, lastName, phone, and address.
	public void updateFirstName(String contactID, String firstName) {
		
		if(contactMap.containsKey(contactID)) {
			
			try {
				// Update firstName.
				contactMap.get(contactID).setFirstName(firstName);
			}
			catch(IllegalArgumentException e) {
				// Catch error and pass it on.
				throw e;
			}
			
		}
		else {
			throw new IllegalArgumentException("Contact does not exist.");
		}
	}
	
	public void updateLastName(String contactID, String lastName) {
		
		if(contactMap.containsKey(contactID)) {
			
			try {
				// Update lastName.
				contactMap.get(contactID).setLastName(lastName);
			}
			catch(IllegalArgumentException e) {
				// Catch error and pass it on.
				throw e;
			}
			
		}
		else {
			throw new IllegalArgumentException("Contact does not exist.");
		}
	}
	
	public void updatePhone(String contactID, String phone) {
		
		if(contactMap.containsKey(contactID)) {
			
			try {
				// Update phone.
				contactMap.get(contactID).setPhone(phone);
			}
			catch(IllegalArgumentException e) {
				// Catch error and pass it on.
				throw e;
			}
			
		}
		else {
			throw new IllegalArgumentException("Contact does not exist.");
		}
	}
	
	public void updateAddress(String contactID, String address) {
		
		if(contactMap.containsKey(contactID)) {
			
			try {
				// Update address.
				contactMap.get(contactID).setAddress(address);
			}
			catch(IllegalArgumentException e) {
				// Catch error and pass it on.
				throw e;
			}
		}
		else {
			throw new IllegalArgumentException("Contact does not exist.");
		}
	}
	
	// Method to get contact from map.
	public Contact getContact(String contactID) {
		
		if(contactMap.containsKey(contactID)) {
			return contactMap.get(contactID);
		}
		else {
			throw new IllegalArgumentException("Contact does not exist.");
		}
	}
	
	
	/*
	public static void main(String args[]) {
		ContactService service = new ContactService();
		Contact con = null;
		
		con = new Contact("0123456789", "Nicholasas", "Cieslalala", "9894158389", "******************************");
	}
	*/
}
