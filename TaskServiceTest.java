package snhu.contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TaskServiceTest {

	private TaskService sut;

	@BeforeEach
	void setUp() {
		sut = new TaskService();
	}

	@AfterEach
	void tearDown() {
		sut = null;
	}

	@Test
	@DisplayName("Test Successful Task adding")
	void testAddTaskSuccess() {
		
		// When 
		sut.addTask("0", "N", "*");
		
		// Then
		assertEquals("N", sut.getTask("0").getName());

	}
	
	@Test
	@DisplayName("Test Duplicated Task adding Failure")
	void testAddTaskDuplicateFailure()
	{
		sut.addTask("0", "N", "*");
		
		// When (attempt to add duplicate)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.addTask("0", "N", "*");
		});
		
		// Then
		assertEquals("Task already exists.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Task adding with invalid ID")
	void testAddTaskIDFailure()
	{
		// When (Invalid ID)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.addTask("", "N", "*");
		});
		
		// Then
		assertEquals("ID cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Task adding with invalid Name")
	void testAddTaskNameFailure()
	{
		// When (Invalid Name)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.addTask("0", "", "*");
		});
		
		// Then
		assertEquals("Name cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Task adding with invalid Description")
	void testAddTaskDescriptionFailure()
	{
		// When (Invalid Description)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.addTask("0", "N", "");
		});
		
		// Then
		assertEquals("Description cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Successful Task Removal")
	void testRemoveTaskSuccess() {
		sut.addTask("0", "N", "*");
		
		// When 
		sut.removeTask("0");
		
		// Then
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.getTask("0");
		});
		assertEquals("Task does not exist.", exception.getMessage());
		
		// When
		exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.removeTask("0");
		});
		
		// Then
		assertEquals("Task does not exist.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Non-existent Task Removal")
	void testRemoveTaskFailure() {
		// When
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.removeTask("0");
		});
		
		// Then
		assertEquals("Task does not exist.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Successful Task Update")
	void testTaskUpdateSuccess() {
		sut.addTask("0", "N", "*");
		
		// When (Name updated)
			sut.updateName("0", "F");
			
		// Then
			assertEquals("F", sut.getTask("0").getName());

		// When (Description updated)
			sut.updateDescription("0", "**");
			
		// Then
			assertEquals("**", sut.getTask("0").getDescription());
	}
	
	@Test
	@DisplayName("Test Non-existent Task Update Failure")
	void testTaskUpdateFailure() {
		// When (update task that doesn't exist)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.updateName("1", "S");
		});
		
		// Then
		assertEquals("Task does not exist.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Task Update With Invalid Name")
	void testTaskUpdateNameFailure() {
		sut.addTask("0", "N", "*");
		
		// When (update task with invalid name)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.updateName("0", "");
		});
		
		// Then
		assertEquals("Name cannot be empty.", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test Task Update With Invalid Description")
	void testTaskUpdateDescriptionFailure() {
		sut.addTask("0", "N", "*");
		
		// When (update task with invalid Description)
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			sut.updateDescription("0", "");
		});
		
		// Then
		assertEquals("Description cannot be empty.", exception.getMessage());
	}

}
