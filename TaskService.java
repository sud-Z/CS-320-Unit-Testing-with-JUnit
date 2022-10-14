package snhu.contact;

import java.util.HashMap;

public class TaskService {
	// Map to hold Tasks.
	public HashMap<String, Task> taskMap;
	public Task task;
	
	public TaskService() {
		this.task = null;
		this.taskMap = new HashMap<String, Task>();
	}
	
	// Method to add Tasks.
	public void addTask(String taskID, String name, String description) {
		
		// Check if Task already exists.
		if(taskMap.containsKey(taskID)) {
			throw new IllegalArgumentException("Task already exists.");
		}
		else {
			try {
				// Create Task.
				task = new Task(taskID, name, description);
			}
			catch(IllegalArgumentException e) {
				// Catch error and pass it on.
				throw e;
			}
			// Add Task to map.
			taskMap.put(taskID, task);
		}
		
	}
	
	
	// Method to remove Task from map.
	public void removeTask(String taskID) {
		
		// Check if Task exists.
		if(taskMap.containsKey(taskID)) {
			taskMap.remove(taskID);
		}
		else {
			throw new IllegalArgumentException("Task does not exist.");
		}
		
	}
	
	
	// Methods to update name and description
	public void updateName(String taskID, String name) {
		
		if(taskMap.containsKey(taskID)) {
			
			try {
				// Update Name.
				taskMap.get(taskID).setName(name);
			}
			catch(IllegalArgumentException e) {
				// Catch error and pass it on.
				throw e;
			}
			
		}
		else {
			throw new IllegalArgumentException("Task does not exist.");
		}
	}
	
	public void updateDescription(String taskID, String description) {
		
		if(taskMap.containsKey(taskID)) {
			
			try {
				// Update description.
				taskMap.get(taskID).setDescription(description);
			}
			catch(IllegalArgumentException e) {
				// Catch error and pass it on.
				throw e;
			}
			
		}
		else {
			throw new IllegalArgumentException("Task does not exist.");
		}
	}
	
	// Method to get Task from map.
	public Task getTask(String taskID) {
		
		if(taskMap.containsKey(taskID)) {
			return taskMap.get(taskID);
		}
		else {
			throw new IllegalArgumentException("Task does not exist.");
		}
	}
	
	
	/*
	public static void main(String args[]) {
		TaskService service = new TaskService();
		//Task t = null;
		
		//t = new Task("0123456789", "Nicholasasasasasasas", "**************************************************");
		service.addTask("0123456789", "Nicholasasasasasasas", "**************************************************");
		
		//System.out.println(t.getTaskID());
		//System.out.println(t.getName());
		//System.out.println(t.getDescription());
		
		
		System.out.println(service.getTask("0123456789").getTaskID());
		System.out.println(service.getTask("0123456789").getName());
		System.out.println(service.getTask("0123456789").getDescription());
		service.addTask("0123456789", "Nicholasasasasasasas", "**************************************************");
	}
	*/
}
