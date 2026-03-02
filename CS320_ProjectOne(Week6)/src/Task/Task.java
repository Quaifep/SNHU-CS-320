package Task;

import java.util.concurrent.atomic.*;

public class Task {

	private final String taskID;
	private String taskName;
	private String taskDescription;
	private static AtomicLong Generator = new AtomicLong();
	
	public Task(String taskName, String taskDescription) {
		
		this.taskID = String.valueOf(Generator.getAndIncrement());
		
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid Task Name");
		}
		
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Tesk Description");
		}
		
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		
	}
	
	public void setTaskName(String taskName) {
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid Task Name");
		}
		this.taskName = taskName;
	}
	
	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Task Description");
		}
		this.taskDescription = taskDescription;
	}
	
	public String getTaskID() {
		return taskID;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getTaskDescription() {
		return taskDescription;
	}
	
	
	
	
}
