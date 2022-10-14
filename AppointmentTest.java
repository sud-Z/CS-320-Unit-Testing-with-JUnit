package snhu.contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.Date;

@SuppressWarnings("deprecation") // to allow the use of the date class without warnings 
class AppointmentTest {

	private Appointment sut;
	private Date today = new Date();
	private Date tomorrow = new Date(today.getYear(), today.getMonth(), today.getDate() + 1);
	private Date future = new Date(3000 + 1900, 11, 31);
	private Date past = new Date(today.getYear(), today.getMonth(), today.getDate() - 1);
	

	
	@BeforeEach
	void setUp() {
		sut = null;
	}

	@AfterEach
	void tearDown() {
		sut = null;
	}


	@Test
	@DisplayName("Test successful Appointment Object creation")
	void testCreateAppointmentSuccess() {
		
		// When (upper boundary test)
		sut = new Appointment("0123456789", future, "**************************************************");
		
		// Then
		assertEquals("0123456789", sut.getAppointmentID());
		assertEquals(future, sut.getDate());
		assertEquals("**************************************************", sut.getDescription());
		
		//When (Lower boundary test)
		sut = new Appointment("0", tomorrow, "*");
		
		// Then
		assertEquals("0", sut.getAppointmentID());
		assertEquals(tomorrow, sut.getDate());
		assertEquals("*", sut.getDescription());
		
	
	}
	
	@Test
	@DisplayName("Test Appointment creation with invalid ID")
	void testCreateAppointmentIDFails() {
		// When (ID is too long)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Appointment("00123456789", tomorrow, "*");
		});
		
		// Then
		assertEquals("ID longer than 10 characters.", exception.getMessage());
		
		// When (ID is null or empty)
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Appointment("", tomorrow, "*");
		});
		
		// Then
		assertEquals("ID cannot be empty.", exception.getMessage());
		
	}
	
	@Test
	@DisplayName("Test Appointment Object creation with invalid Date")
	void testCreateAppointmentDateFails()
	{
		
		// When (Date is in the past)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Appointment("0", past, "*");
		});
		
		// Then
		assertEquals("Date cannot be in the past.", exception.getMessage());
		
		// When (Name is null or empty)
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Appointment("0", null, "*");
		});
		
		// Then
		assertEquals("Date cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Appointment Object creation with invalid Description")
	void testCreateAppointmentDescriptionFails()
	{
		// When (Description is too long)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Appointment("0", future, "**************************************************1");
		});
		
		// Then
		assertEquals("Description longer than 50 characters.", exception.getMessage());

		
		// When (Description is null or empty)
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Appointment("0", future, "");
		});
		
		// Then
		assertEquals("Description cannot be empty.", exception.getMessage());
	}
	
	// mutators covered by creation as they are called in the constructor. ******************************
	
}
