package snhu.contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.Date;

@SuppressWarnings("deprecation") // to allow the use of the date class without warnings 

class AppointmentServiceTest {

	private AppointmentService sut;
	private Date today = new Date();
	private Date tomorrow = new Date(today.getYear(), today.getMonth(), today.getDate() + 1);
	private Date future = new Date(3000 + 1900, 11, 31);
	private Date past = new Date(today.getYear(), today.getMonth(), today.getDate() - 1);
	
	@BeforeEach
	void setUp() {
		sut = new AppointmentService();
	}

	@AfterEach
	void tearDown() {
		sut = null;
	}

	@Test
	@DisplayName("Test Successful Appointment adding")
	void testAddAppointmentSuccess() {
		
		// When 
		sut.addAppointment("0", future, "*");
		
		// Then
		assertEquals(future, sut.getAppointment("0").getDate());
		assertEquals("*", sut.getAppointment("0").getDescription());

	}
	
	@Test
	@DisplayName("Test Duplicated Appointment adding Failure")
	void testAddAppointmentDuplicateFailure()
	{
		sut.addAppointment("0", future, "*");
		
		// When (attempt to add duplicate)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.addAppointment("0", future, "*");
		});
		
		// Then
		assertEquals("Appointment already exists.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Appointment adding with invalid ID")
	void testAddAppointmentIDFailure()
	{
		// When (Invalid ID)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.addAppointment("", future, "*");
		});
		
		// Then
		assertEquals("ID cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Appointment adding with invalid Date")
	void testAddAppointmentDateFailure()
	{
		// When (Invalid Date)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.addAppointment("0", null, "*");
		});
		
		// Then
		assertEquals("Date cannot be empty.", exception.getMessage());
		
		// When (Invalid Name)
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.addAppointment("0", past, "*");
		});
		
		// Then
		assertEquals("Date cannot be in the past.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Appointment adding with invalid Description")
	void testAddAppointmentDescriptionFailure()
	{
		// When (Invalid Description)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.addAppointment("0", future, "");
		});
		
		// Then
		assertEquals("Description cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Successful Appointment Removal")
	void testRemoveAppointmentSuccess() {
		sut.addAppointment("0", future, "*");
		
		// When 
		sut.removeAppointment("0");
		
		// Then
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.getAppointment("0");
		});
		assertEquals("Appointment does not exist.", exception.getMessage());
		
		// When
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.removeAppointment("0");
		});
		
		// Then
		assertEquals("Appointment does not exist.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Non-existent Appointment Removal")
	void testRemoveAppointmentFailure() {
		// When
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.removeAppointment("0");
		});
		
		// Then
		assertEquals("Appointment does not exist.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Successful Appointment Update")
	void testAppointmentUpdateSuccess() {
		sut.addAppointment("0", future, "*");
	
		// When (Name updated)
		sut.updateDate("0", tomorrow);
			
		// Then
		assertEquals(tomorrow, sut.getAppointment("0").getDate());

		// When (Description updated)
		sut.updateDescription("0", "**");
			
		// Then
		assertEquals("**", sut.getAppointment("0").getDescription());
	}
	
	@Test
	@DisplayName("Test Non-existent Appointment Update Failure")
	void testAppointmentUpdateFailure() {
		// When (update task that doesn't exist)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.updateDate("1", future);
		});
		
		// Then
		assertEquals("Appointment does not exist.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Appointment Update With Invalid Date")
	void testAppointmentUpdateDateFailure() {
		sut.addAppointment("0", future, "*");
		
		// When (update task with invalid date)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.updateDate("0", past);
		});
		
		// Then
		assertEquals("Date cannot be in the past.", exception.getMessage());
		
		// When (update task with past date)
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.updateDate("0", null);
		});
		
		// Then
		assertEquals("Date cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Appointment Update With Invalid Description")
	void testAppointmentUpdateDescriptionFailure() {
		sut.addAppointment("0", future, "*");
		
		// When (update task with invalid Description)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.updateDescription("0", "");
		});
		
		// Then
		assertEquals("Description cannot be empty.", exception.getMessage());
	}

}
