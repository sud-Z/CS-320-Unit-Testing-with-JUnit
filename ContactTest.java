package snhu.contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class ContactTest {
	
	private Contact sut;
	
	@BeforeEach
	void setUp() {
		sut = null;
	}

	@AfterEach
	void tearDown() {
		sut = null;
	}

	@Test
	@DisplayName("Test successful Contact Object creation")
	void testCreateContactSuccess() {
		// When (upper boundary test)
		sut = new Contact("0123456789", "Nicholasas", "Cieslalala", "9894158389", "******************************");
		
		// Then
		assertEquals("0123456789", sut.getContactID());
		assertEquals("Nicholasas", sut.getFirstName());
		assertEquals("Cieslalala", sut.getLastName());
		assertEquals("9894158389", sut.getPhone());
		assertEquals("******************************", sut.getAddress());
		
		//When (Lower boundary test)
		sut = new Contact("0", "N", "C", "9894158389", "*");
		
		// Then
		assertEquals("0", sut.getContactID());
		assertEquals("N", sut.getFirstName());
		assertEquals("C", sut.getLastName());
		assertEquals("9894158389", sut.getPhone());
		assertEquals("*", sut.getAddress());
		
	
	}
	
	@Test
	@DisplayName("Test Contact Object creation with invalid ID")
	void testCreateTaskIDFails() {
		// When (ID is too long)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Contact("00123456789", "Nicholasas", "Cieslalala", "9894158389", "******************************");
		});
		
		// Then
		assertEquals("ID longer than 10 characters.", exception.getMessage());
		
		
		// When (ID is null or empty)
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Contact("", "N", "C", "9894158389", "*");
		});
		
		// Then
		assertEquals("ID cannot be empty.", exception.getMessage());
		
	}
	
	@Test
	@DisplayName("Test Contact Object creation with invalid First Name")
	void testCreateTaskFirstNameFails()
	{
		// When (First Name is too long)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Contact("0123456789", "Nicholasas1", "Cieslalala", "9894158389", "******************************");
		});
		
		// Then
		assertEquals("First Name longer than 10 characters.", exception.getMessage());
		
		// When (First Name is null or empty)
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Contact("0", "", "C", "9894158389", "*");
		});
		
		// Then
		assertEquals("First Name cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Contact Object creation with invalid Last Name")
	void testCreateTaskLastNameFails()
	{
		// When (Last Name is too long)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Contact("0123456789", "Nicholasas", "Cieslalala1", "9894158389", "******************************");
		});
		
		// Then
		assertEquals("Last Name longer than 10 characters.", exception.getMessage());
		
		// When (Last Name is null or empty)
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Contact("0", "N", "", "9894158389", "*");
		});
		
		// Then
		assertEquals("Last Name cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Contact Object creation with invalid Phone number")
	void testCreateTaskPhoneNumberFails()
	{
		// When (Phone number is too long)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Contact("0123456789", "Nicholasas", "Cieslalala", "98941583891", "******************************");
		});
		
		// Then
		assertEquals("Phone number too long.", exception.getMessage());
		
		// When (Phone number is too short)
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Contact("0123456789", "Nicholasas", "Cieslalala", "989415838", "******************************");
		});
		
		// Then
		assertEquals("Phone number too short.", exception.getMessage());
	
		// When (Phone number contains invalid char)
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Contact("0123456789", "Nicholasas", "Cieslalala", "989415838f", "******************************");
		});
		
		// Then
		assertEquals("Invalid character in phone number.", exception.getMessage());
		
		// When (Phone number is null or empty)
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Contact("0", "N", "C", "", "*");
		});
		
		// Then
		assertEquals("Phone number cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Contact Object creation with invalid Address")
	void testCreateTaskAddressFails()
	{
		// When (Address is too long)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Contact("0123456789", "Nicholasas", "Cieslalala", "9894158389", "*******************************");
		});
		
		// Then
		assertEquals("Address too long.", exception.getMessage());
		
		// When (Address is null or empty)
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Contact("0123456789", "Nicholasas", "Cieslalala", "9894158389", "");
		});
		
		// Then
		assertEquals("Address cannot be empty.", exception.getMessage());
	}
	
	
	// mutators covered by creation as they are called in the constructor.  **************************
	

}
