package snhu.contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


class ContactServiceTest {
	
	private ContactService sut;

	@BeforeEach
	void setUp() {
		sut = new ContactService();
	}

	@AfterEach
	void tearDown() {
		sut = null;
	}

	@Test
	@DisplayName("Test Successful Contact adding")
	void testAddContactSuccess() {
		
		// When 
		sut.addContact("0", "N", "C", "9894158389", "*");
		
		// Then
		assertEquals("N", sut.getContact("0").getFirstName());
		assertEquals("C", sut.getContact("0").getLastName());
		assertEquals("9894158389", sut.getContact("0").getPhone());
		assertEquals("*", sut.getContact("0").getAddress());
	}
	
	@Test
	@DisplayName("Test Duplicated Contact adding")
	void testAddContactDuplicateFailure()
	{
		sut.addContact("0", "N", "C", "9894158389", "*");
		
		// When (attempt to add duplicate)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.addContact("0", "N", "C", "9894158389", "*");
		});
		
		// Then
		assertEquals("Contact already exists.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Contact Adding With Invalid ID")
	void testAddContactIDFailure()
	{
		// When (ID is null)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.addContact("", "N", "C", "9894158389", "*");
		});
		
		// Then
		assertEquals("ID cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Contact Adding With Invalid First Name")
	void testAddContactFirstNameFailure()
	{
		// When (First Name is null)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.addContact("0", "", "C", "9894158389", "*");
		});
		
		// Then
		assertEquals("First Name cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Contact Adding With Invalid Last Name")
	void testAddContactLastNameFailure()
	{
		// When (Last Name is null)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.addContact("0", "N", "", "9894158389", "*");
		});
		
		// Then
		assertEquals("Last Name cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Contact Adding With Invalid Phone Number")
	void testAddContactPhoneNumberFailure()
	{
		// When (Phone Number is null)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.addContact("0", "N", "C", "", "*");
		});
		
		// Then
		assertEquals("Phone number cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Contact Adding With Invalid Address")
	void testAddContactAddressFailure()
	{
		// When (Address is null)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.addContact("0", "N", "C", "9894158389", "");
		});
		
		// Then
		assertEquals("Address cannot be empty.", exception.getMessage());
	}
	
	
	@Test
	@DisplayName("Test Successful Contact Removal")
	void testRemoveContactSuccess() {
		sut.addContact("0", "N", "C", "9894158389", "*");
		
		// When 
		sut.removeContact("0");
		
		// Then
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.getContact("0");
		});
		assertEquals("Contact does not exist.", exception.getMessage());
		

	}
	
	@Test
	@DisplayName("Test Non-existent Contact Removal Failure")
	void testRemoveContactFailure()
	{
		// When
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.removeContact("0");
		});
		
		// Then
		assertEquals("Contact does not exist.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Successful Contact Update")
	void testContactUpdateSuccess() {
		sut.addContact("0", "N", "C", "9894158389", "*");
		
		// When (First Name updated)
			sut.updateFirstName("0", "F");
			
		// Then
			assertEquals("F", sut.getContact("0").getFirstName());
			
		// When (Last Name updated)
			sut.updateLastName("0", "L");
			
		// Then
			assertEquals("L", sut.getContact("0").getLastName());
			
		// When (Phone number updated)
			sut.updatePhone("0", "9898934378");
			
		// Then
			assertEquals("9898934378", sut.getContact("0").getPhone());
			
		// When (Address updated)
			sut.updateAddress("0", "**");
			
		// Then
			assertEquals("**", sut.getContact("0").getAddress());
	}
	
	
	
	@Test
	@DisplayName("Test Non-existent Contact Update Failure")
	void testContactUpdateFailure()
	{
		// When (update conact that doesn't exist)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.updateFirstName("1", "S");
		});
		
		// Then
		assertEquals("Contact does not exist.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Contact Update Invalid First Name")
	void testContactUpdateFirstNameFailure()
	{
		sut.addContact("0", "N", "C", "9894158389", "*");
		
		// When (update conact with invalid first name)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.updateFirstName("0", "");
		});
		
		// Then
		assertEquals("First Name cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Contact Update Invalid Last Name")
	void testContactUpdateLastNameFailure()
	{
		sut.addContact("0", "N", "C", "9894158389", "*");
		
		// When (update conact with invalid last name)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.updateLastName("0", "");
		});
		
		// Then
		assertEquals("Last Name cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Contact Update Invalid Phone Number")
	void testContactUpdatePhoneNumberFailure()
	{
		sut.addContact("0", "N", "C", "9894158389", "*");
		
		// When (update conact with invalid phone number)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.updatePhone("0", "");
		});
		
		// Then
		assertEquals("Phone number cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Contact Update Invalid Address")
	void testContactUpdateAddressFailure()
	{
		sut.addContact("0", "N", "C", "9894158389", "*");
		
		// When (update conact with invalid phone number)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.updateAddress("0", "");
		});
		
		// Then
		assertEquals("Address cannot be empty.", exception.getMessage());
	}

}
