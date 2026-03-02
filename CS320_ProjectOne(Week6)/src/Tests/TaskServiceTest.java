package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Task.Task;
import Task.TaskService;

class TaskServiceTest {

	@Test
	void testAddTaskToMapReturnsID() {
		TaskService service = new TaskService();
		
		String id = service.addTask("Name", "Description");
		
		assertNotNull(id);
		assertEquals(1, service.size());
		
		Task added = service.getTaskByID(id);
		assertNotNull(added.getTaskID());
		assertEquals("Name", added.getTaskName());
		assertEquals("Description", added.getTaskID());
	}

	@Test
	void testGetTaskByIDReturnsCorrectTask() {
		TaskService service = new TaskService();
		
		String id1 = service.addTask("1Name", "1 Description");
		String id2 = service.addTask("2Name", "2Description");
		
		Task t1 = service.getTaskByID(id1);
		Task t2 = service.getTaskByID(id2);
		
		assertEquals("1Name", t1.getTaskName());
		assertEquals("2Name", t2.getTaskName());
	}
	
	@Test
	void testGetTaskByIDThrowsWhenNotFound() {
		TaskService service = new TaskService();
		
		assertThrows(IllegalArgumentException.class, () -> service.getTaskByID("FakeID"));
	}
	
	@Test
	void testGetTaskByIdThrowsWhenNotFound() {
		TaskService service = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> service.getTaskByID("FakeID"));
	}
	
	@Test
	void testDeleteTaskByIDRemovesTask() {
		TaskService service = new TaskService();
		
		String id = service.addTask("Name", "Description");
		
		service.deleteTask(id);
		
		assertEquals(0, service.size());
		assertThrows(IllegalArgumentException.class, () -> service.getTaskByID(id));
	}
	@Test
	void testDeleteTaskThrowsWhenNotFound() {
		TaskService service = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> service.deleteTask("FakeID"));
	}
	
	@Test
	void testUpdateTaskName() {
		TaskService service = new TaskService();
		
		String id = service.addTask("Name", "Description");
		service.updateTaskName("New Name", id);
		
		assertEquals("New Name", service.getTaskByID(id).getTaskName());
	}
	
	@Test
	void testUpdateTaskDescription() {
		TaskService service = new TaskService();
		
		String id = service.addTask("Name", "Description 1");
		service.updatetaskDescription("New Description", id);
		
		assertEquals("New Description", service.getTaskByID(id).getTaskDescription());
	}
}
