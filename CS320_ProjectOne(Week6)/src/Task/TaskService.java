package Task;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

@SuppressWarnings("unused")

public class TaskService {

	private final Map<String, Task> tasks = new HashMap<>();
	
	public Collection<Task> getAllTasks() {
		return tasks.values();
	}
	
	public int size() {
		return tasks.size();
	}
	
	public String addTask(String taskName, String taskDescription) {
		Task task = new Task(taskName, taskDescription);
		String id = task.getTaskID();
		
		if (tasks.containsKey(id)) {
			throw new IllegalArgumentException("Duplicate Task ID");
		}
		tasks.put(id, task);
		return id;
		
	}
	
	public Task getTaskByID(String taskID) {
		Task task = tasks.get(taskID);
		if (task == null) {
			throw new IllegalArgumentException("Task ID not found");
		}
		return task;
	}

	public void deleteTask(String taskID) {
		if (tasks.remove(taskID) == null) {
			throw new IllegalArgumentException("Task ID not Found");
		}
	}
	
	public void updateTaskName(String updateString, String taskID) {
		getTaskByID(taskID).setTaskName(updateString);
	}
	
	public void updatetaskDescription(String updateString, String taskID) {
		getTaskByID(taskID).setTaskDescription(updateString);
	}
	
}
