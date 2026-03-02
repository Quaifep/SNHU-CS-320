package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Task.Task;

class TaskTest {

	@Test
	void testNewTaskAddedIsValid() {
		Task task = new Task("Task #1", "This is the task description");
		assertTrue(task.getTaskName().equals("Task #1"));
		assertTrue(task.getTaskDescription().equals("This is the task description"));
		assertNotNull(task.getTaskID());
	}

	@Test
	void testConstructorRejectsNullTaskName() {
		assertThrows(IllegalArgumentException.class, () -> 
				new Task(null, "This is the task description"));
	}
	
	@Test
	void testConstructorRejectsNullTaskDescription() {
		assertThrows(IllegalArgumentException.class, () -> 
				new Task("Task #1", null));
	}
	
	@Test
	void testTaskNameInput() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("This needs to be more than 20 characters and I dont want to count",
					"description");
		});
	}
	
	@Test
	void testTaskDescriptionInput() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Task("Task Name", 
					"This needs to be more than 50 characters and I dont want to count"
					+ "individually bevcause my eyesite isn't the best and I left my glasses"
					+ "at home, but this run on sentence should be enough to fail the check"
					+ "but pass the test.");
		});
	}
	
	@Test
	void testSetTaskNameValidAndInvalid() {
		Task task =  new Task("Name", "description");
		
		task.setTaskName("New Name");
		assertEquals("New Name", task.getTaskName());
		
		assertThrows(IllegalArgumentException.class, () -> task.setTaskName(null));
		assertThrows(IllegalArgumentException.class, () -> task.setTaskName("This needs "
				+ "to be more than 20 characters and I dont want to count"));
	}
	
	@Test
	void testTaskDescriptionValidAndInvalid() {
		Task task = new Task("Name", "Description");
		
		task.setTaskDescription("New Description");
		assertEquals("New Description", task.getTaskDescription());
		
		assertThrows(IllegalArgumentException.class, () -> task.setTaskDescription(null));
		assertThrows(IllegalArgumentException.class, () -> task.setTaskDescription(
				"This needs to be more than 50 characters and I dont want to count"
				+ "individually bevcause my eyesite isn't the best and I left my glasses"
				+ "at home, but this run on sentence should be enough to fail the check"
				+ "but pass the test."));
	}
	@Test
	void testConstructorAcceptMaxLength() {
		String name20 = "12345678901234567891";
		String desc50 = "12345678901234567891123456789212345678931234567894";
		
		Task task = new Task(name20, desc50);
		
		assertEquals(name20, task.getTaskName());
		assertEquals(desc50, task.getTaskDescription());
	}
	
}
