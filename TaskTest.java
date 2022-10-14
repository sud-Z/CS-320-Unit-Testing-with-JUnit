package snhu.contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TaskTest {

	private Task sut;
	
	@BeforeEach
	void setUp() {
		sut = null;
	}

	@AfterEach
	void tearDown() {
		sut = null;
	}

	@Test
	@DisplayName("Test successful Task Object creation")
	void testCreateTaskSuccess() {
		// When (upper boundary test)
		sut = new Task("0123456789", "Nicholasasasasasasas", "**************************************************");
		
		// Then
		assertEquals("0123456789", sut.getTaskID());
		assertEquals("Nicholasasasasasasas", sut.getName());
		assertEquals("**************************************************", sut.getDescription());
		
		//When (Lower boundary test)
		sut = new Task("0", "N", "*");
		
		// Then
		assertEquals("0", sut.getTaskID());
		assertEquals("N", sut.getName());
		assertEquals("*", sut.getDescription());
		
	
	}
	
	@Test
	@DisplayName("Test Task Object creation with invalid ID")
	void testCreateTaskIDFails() {
		// When (ID is too long)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Task("00123456789", "Nicholasasasasasasas", "**************************************************");
		});
		
		// Then
		assertEquals("ID longer than 10 characters.", exception.getMessage());
		
		// When (ID is null or empty)
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Task("", "N", "*");
		});
		
		// Then
		assertEquals("ID cannot be empty.", exception.getMessage());
		
	}
	
	@Test
	@DisplayName("Test Task Object creation with invalid Name")
	void testCreateTaskNameFails()
	{
		
		// When (Name is too long)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Task("0123456789", "Nicholasasasasasasas*", "**************************************************");
		});
		
		// Then
		assertEquals("Name longer than 20 characters.", exception.getMessage());
		
		// When (Name is null or empty)
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Task("0", "", "*");
		});
		
		// Then
		assertEquals("Name cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Task Object creation with invalid Description")
	void testCreateTaskDescriptionFails()
	{
		// When (Description is too long)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Task("0123456789", "Nicholasasasasasasas", "**************************************************1");
		});
		
		// Then
		assertEquals("Description longer than 50 characters.", exception.getMessage());

		
		// When (Description is null or empty)
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut = new Task("0", "N", "");
		});
		
		// Then
		assertEquals("Description cannot be empty.", exception.getMessage());
	}
	
	// mutators covered by creation as they are called in the constructor. ******************************

}
