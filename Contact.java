package snhu.contact;

public class Contact {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	@SuppressWarnings("unused")
	private Contact() {} // Private constructor so only parameterized can be used.
	
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		
		if(contactID == null || contactID.isEmpty()) { // Check if ID is empty.
			// Throw exception if ID is empty.
			throw new IllegalArgumentException("ID cannot be empty.");
		}
		else if(contactID.length() > 10 ) { // Check length of ID.
			// Throw exception if ID is too long.
			throw new IllegalArgumentException("ID longer than 10 characters.");
		}
		else { 
			this.contactID = contactID;
		}
		
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
		
	}
	
	// Method to check if string contains something other than a digit.
	private boolean notJustDigits(String number) {
		
		// Loop through entire string.
		for(int i = 0; i < number.length(); i++) {
			
			// If any char is not a digit, return true.
			if(!Character.isDigit(number.charAt(i))) {
				return true;
			}
			
		}
		
		// If we make it through, return false.
		return false;
	}
	
	// Accessors 
	
	public String getContactID() {
		return this.contactID;
	}
	// ***********************************************************
	public String getFirstName() {
		return this.firstName;
	}
	// ***********************************************************
	public String getLastName() {
		return this.lastName;
	}
	// ***********************************************************
	public String getPhone() {
		return this.phone;
	}
	// ***********************************************************
	public String getAddress() {
		return this.address;
	}
	
	// Mutators for firstName, lastName, phone, and address
	
	public void setFirstName(String firstName) {
		
		if(firstName == null || firstName.isEmpty()) { // Check if First Name is empty.
			// Throw exception if First Name is empty.
			throw new IllegalArgumentException("First Name cannot be empty.");
		}
		else if(firstName.length() > 10 ) { // Check length of First Name.
			// Throw exception if First Name is too long.
			throw new IllegalArgumentException("First Name longer than 10 characters.");
		}
		else {  
			this.firstName = firstName;
		}
		
	}
	// ***********************************************************
	public void setLastName(String lastName) {
		if(lastName == null || lastName.isEmpty()) { // Check if Last Name is empty.
			// Throw exception if Last Name is empty.
			throw new IllegalArgumentException("Last Name cannot be empty.");
		}
		else if(lastName.length() > 10 ) { // Check length of Last Name.
			// Throw exception if Last Name is too long.
			throw new IllegalArgumentException("Last Name longer than 10 characters.");
		}
		else {  
			this.lastName = lastName;
		}
	}
	// ***********************************************************
	public void setPhone(String phone) {
		if(phone == null || phone.isEmpty()) { // Check if phone number is empty.
			// Throw exception if phone number is empty.
			throw new IllegalArgumentException("Phone number cannot be empty.");
		}
		else if(phone.length() < 10) { // Check if phone number is shorter than 10 characters.
			// Throw exception if phone number is too short.
			throw new IllegalArgumentException("Phone number too short.");
		}
		else if(phone.length() > 10) { // Check if phone number is longer than 10 characters.
			// Throw exception if phone number is too long.
			throw new IllegalArgumentException("Phone number too long.");
		}
		else if(notJustDigits(phone)) { // Check if phone number contains invalid character.
			// Throw exception if phone number contains an invalid character.
			throw new IllegalArgumentException("Invalid character in phone number."); 
		}
		else {
			this.phone = phone;
		}
	}
	// ***********************************************************
	public void setAddress(String address) {
		if(address == null || address.isEmpty()) { // Check if address is empty.
			// Throw exception if address is empty.
			throw new IllegalArgumentException("Address cannot be empty.");
		}
		else if(address.length() > 30) { // Check length of Address.
			// Throw exception if Address is too long.
			throw new IllegalArgumentException("Address too long."); 
		}
		else {
			this.address = address;
		}
	}
	
}
