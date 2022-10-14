package snhu.contact;

public class Task {

	private String taskID;
	private String name;
	private String description;
	
	@SuppressWarnings("unused")
	private Task() {} // Private constructor so only parameterized can be used.
	
	public Task(String taskID, String name, String description) {
		
		if(taskID == null || taskID.isEmpty()) { // Check if ID is empty.
			// Throw exception if ID is empty.
			throw new IllegalArgumentException("ID cannot be empty.");
		}
		else if(taskID.length() > 10 ) { // Check length of ID.
			// Throw exception if ID is too long.
			throw new IllegalArgumentException("ID longer than 10 characters.");
		}
		else { 
			this.taskID = taskID;
		}
		
		setName(name);
		setDescription(description);
		
	}
	
	// Accessors 
	
	public String getTaskID() {
		return this.taskID;
	}
	// ***********************************************************
	public String getName() {
		return this.name;
	}
	// ***********************************************************
	public String getDescription() {
		return this.description;
	}

	// Mutators for name and description.
	
	public void setName(String name) {
		
		if(name == null || name.isEmpty()) { // Check if Name is empty.
			// Throw exception if Name is empty.
			throw new IllegalArgumentException("Name cannot be empty.");
		}
		else if(name.length() > 20 ) { // Check length of Name.
			// Throw exception if Name is too long.
			throw new IllegalArgumentException("Name longer than 20 characters.");
		}
		else {  
			this.name = name;
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
