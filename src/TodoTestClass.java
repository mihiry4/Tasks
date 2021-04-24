import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import model.Task;

class TodoTestClass {

	@Test
	void testTaskStringStringIntStringBooleanDateDateString() {
		@SuppressWarnings("deprecation")
		Date dueDate = new Date(2021, 2, 15, 20, 20, 20);
		Task testTask = new Task("Test Task 1", "This task is all about making sure that we can "
				+ "create a task properly and that a description can handle some string nicely without "
				+ "complaining too much about what I write in here so that I can actually have a proper "
				+ "decription for the task which will help me remember what I need to do in order to "
				+ "complete the task", 0, "Groceries", true, dueDate, new Date(), "Neverland");
		
	}

	@Test
	void testTaskStringStringIntStringDateString() {
		@SuppressWarnings("deprecation")
		Date dueDate = new Date(2021, 2, 15, 22, 40, 20);
		Task testTask = new Task("Test Task 1", "Simple task description", 0, 
								"Misc", dueDate, "Neverland");
		
	}

	@Test
	void testGetName() {
		@SuppressWarnings("deprecation")
		Date dueDate = new Date(2021, 2, 15, 22, 40, 20);
		Task testTask = new Task("Test Task 1", "Simple task description", 0, 
								"Misc", dueDate, "Neverland");
		assertEquals(testTask.getName(),"Test Task 1");
		
	}

	@Test
	void testGetDescription() {
		@SuppressWarnings("deprecation")
		Date dueDate = new Date(2021, 2, 15, 22, 40, 20);
		Task testTask = new Task("Test Task 1", "Simple task description", 0, 
								"Misc", dueDate, "Neverland");
		assertEquals(testTask.getDescription(),"Simple task description");
		testTask = new Task("Test Task 1", "This task is all about making sure that we can "
				+ "create a task properly and that a description can handle some string nicely without "
				+ "complaining too much about what I write in here so that I can actually have a proper "
				+ "decription for the task which will help me remember what I need to do in order to "
				+ "complete the task", 0, "Groceries", true, dueDate, new Date(), "Neverland");
		assertEquals(testTask.getDescription(),"This task is all about making sure that we can " 
								+ "create a task properly and that a description can handle some string nicely without "								+ "complaining too much about what I write in here so that I can actually have a proper "  
								+ "decription for the task which will help me remember what I need to do in order to "  
								+ "complete the task");
	}

	@Test
	void testGetPriority() {
		@SuppressWarnings("deprecation")
		Date dueDate = new Date(2021, 2, 15, 22, 40, 20);
		Task testTask = new Task("Test Task 1", "Simple task description", 1099, 
								"Misc", dueDate, "Neverland");
		assertEquals(testTask.getPriority(), 1099);
	}

	@Test
	void testGetCategory() {
		@SuppressWarnings("deprecation")
		Date dueDate = new Date(2021, 2, 15, 22, 40, 20);
		Task testTask = new Task("Test Task 1", "Simple task description", 0, 
								"Misc", dueDate, "Neverland");
		assertEquals(testTask.getCategory(),"Misc");
	}

	@Test
	void testIsCompleted() {
		@SuppressWarnings("deprecation")
		Date dueDate = new Date(2021, 2, 15, 22, 40, 20);
		Task testTask = new Task("Test Task 1", "Simple task description", 0, 
								"Misc", dueDate, "Neverland");
		assertFalse(testTask.isCompleted());
	}

	@Test
	void testGetDateCreated() {
		@SuppressWarnings("deprecation")
		Date dueDate = new Date(2021, 2, 15, 22, 40, 20);
		Date created = new Date();
		Task testTask = new Task("Test Task 1", "This", 0, "Groceries", true, dueDate, created, "Neverland");
		assertEquals(testTask.getDateCreated(), created);
	}

	@Test
	void testGetDateDue() {
		@SuppressWarnings("deprecation")
		Date dueDate = new Date(2021, 2, 15, 22, 40, 20);
		Task testTask = new Task("Test Task 1", "This", 0, "Groceries", dueDate, "Neverland");
		assertEquals(testTask.getDateDue(), dueDate);
	}

	@Test
	void testGetLocation() {
		@SuppressWarnings("deprecation")
		Date dueDate = new Date(2021, 2, 15, 22, 40, 20);
		Task testTask = new Task("Test Task 1", "This", 0, "Groceries", dueDate, "Neverland");
		assertEquals(testTask.getLocation(), "Neverland");
	}

	@Test
	void testSetName() {
		Task testTask = new Task("Test Task 1", "This", 0, "Groceries", new Date(), "Neverland");
		testTask.setName("New Task Name");
		assertEquals(testTask.getName(), "New Task Name");
	}

	@Test
	void testSetDescription() {
		Task testTask = new Task("Test Task 1", "This", 0, "Groceries", new Date(), "Neverland");
		testTask.setDescription("New Task Desc");
		assertEquals(testTask.getDescription(), "New Task Desc");
	}

	@Test
	void testSetPriority() {
		Task testTask = new Task("Test Task 1", "This", 0, "Groceries", new Date(), "Neverland");
		testTask.setPriority(10);
		assertEquals(testTask.getPriority(), 10);
	}

	@Test
	void testSetCategory() {
		Task testTask = new Task("Test Task 1", "This", 0, "Groceries", new Date(), "Neverland");
		testTask.setCategory("Misc");
		assertEquals(testTask.getCategory(), "Misc");
	}

	@Test
	void testSetCompleted() {
		Task testTask = new Task("Test Task 1", "This", 0, "Groceries", new Date(), "Neverland");
		assertFalse(testTask.isCompleted());
		testTask.setCompleted(true);
		assertTrue(testTask.isCompleted());
	}

	@Test
	void testSetDateDue() {
		Task testTask = new Task("Test Task 1", "This", 0, "Groceries", new Date(), "Neverland");
		Date d = new Date();
		testTask.setDateDue(d);
		assertEquals(testTask.getDateDue(), d);
	}

	@Test
	void testSetLocation() {
		Task testTask = new Task("Test Task 1", "This", 0, "Groceries", new Date(), "Neverland");
		testTask.setLocation("Tucson");
		assertEquals(testTask.getLocation(), "Tucson");
	}

}
