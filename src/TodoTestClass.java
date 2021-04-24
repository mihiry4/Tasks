import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import controller.TodoController;
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
	
	@Test
	void testGetNameSorted() {
		Task testTask1 = new Task("alpha", "This", 0, "Groceries", new Date(), "Neverland");
		Task testTask2 = new Task("beta", "This", 0, "Groceries", new Date(), "Neverland");
		Task testTask3 = new Task("delta", "This", 0, "Groceries", new Date(), "Neverland");
		Task testTask4 = new Task("gamma", "This", 0, "Groceries", new Date(), "Neverland");
		List<Task> arr1 = new ArrayList<Task>();
		List<Task> arr2 = new ArrayList<Task>();
		arr1.add(testTask4);
		arr1.add(testTask3);
		arr1.add(testTask2);
		arr1.add(testTask1);
		arr2.add(testTask1);
		arr2.add(testTask2);
		arr2.add(testTask3);
		arr2.add(testTask4);
		TodoController controller = new TodoController(arr1);
		controller.getNameSorted();
		assertTrue(arr1.equals(arr2));
	}
	
	@Test
	void testGetPrioritySorted() {
		Task testTask1 = new Task("alpha", "This", 0, "Groceries", new Date(), "Neverland");
		Task testTask2 = new Task("beta", "This", 1, "Groceries", new Date(), "Neverland");
		Task testTask3 = new Task("delta", "This", 2, "Groceries", new Date(), "Neverland");
		Task testTask4 = new Task("gamma", "This", 3, "Groceries", new Date(), "Neverland");
		List<Task> arr1 = new ArrayList<Task>();
		List<Task> arr2 = new ArrayList<Task>();
		arr1.add(testTask4);
		arr1.add(testTask3);
		arr1.add(testTask2);
		arr1.add(testTask1);
		arr2.add(testTask1);
		arr2.add(testTask2);
		arr2.add(testTask3);
		arr2.add(testTask4);
		TodoController controller = new TodoController(arr1);
		controller.getPrioritySorted();
		assertTrue(arr1.equals(arr2));
	}
	
	@Test
	void testGetCategorySorted() {
		Task testTask1 = new Task("alpha", "This", 0, "appliances", new Date(), "Neverland");
		Task testTask2 = new Task("beta", "This", 1, "books", new Date(), "Neverland");
		Task testTask3 = new Task("delta", "This", 2, "food", new Date(), "Neverland");
		Task testTask4 = new Task("gamma", "This", 3, "groceries", new Date(), "Neverland");
		List<Task> arr1 = new ArrayList<Task>();
		List<Task> arr2 = new ArrayList<Task>();
		arr1.add(testTask4);
		arr1.add(testTask3);
		arr1.add(testTask2);
		arr1.add(testTask1);
		arr2.add(testTask1);
		arr2.add(testTask2);
		arr2.add(testTask3);
		arr2.add(testTask4);
		TodoController controller = new TodoController(arr1);
		controller.getCategorySorted();
		assertTrue(arr1.equals(arr2));
	}
	
	@Test
	void testGetDueDateSorted() {
		Date d1 = new Date(118,5,4,10,40);
		Date d2 = new Date(119,5,4,10,40);
		Date d3 = new Date(120,5,4,10,40);
		Date d4 = new Date(121,5,4,10,40);
		Task testTask1 = new Task("alpha", "This", 0, "appliances", d1, "Neverland");
		Task testTask2 = new Task("beta", "This", 1, "books", d2, "Neverland");
		Task testTask3 = new Task("delta", "This", 2, "food", d3, "Neverland");
		Task testTask4 = new Task("gamma", "This", 3, "groceries", d4, "Neverland");
		List<Task> arr1 = new ArrayList<Task>();
		List<Task> arr2 = new ArrayList<Task>();
		arr1.add(testTask4);
		arr1.add(testTask3);
		arr1.add(testTask2);
		arr1.add(testTask1);
		arr2.add(testTask1);
		arr2.add(testTask2);
		arr2.add(testTask3);
		arr2.add(testTask4);
		TodoController controller = new TodoController(arr1);
		controller.getDueDateSorted();
		assertTrue(arr1.equals(arr2));
	}
	
	@Test
	void testGetDateCreatedSorted() {
		Date d1 = new Date(118,5,4,10,40);
		Date d2 = new Date(119,5,4,10,40);
		Date d3 = new Date(120,5,4,10,40);
		Date d4 = new Date(121,5,4,10,40);
		Task testTask1 = new Task("alpha", "This", 0, "Groceries", true, d1, d1, "Neverland");
		Task testTask2 = new Task("beta",  "This", 0, "Groceries", true, d2, d2, "Neverland");
		Task testTask3 = new Task("delta",  "This", 0, "Groceries", true, d3, d3, "Neverland");
		Task testTask4 = new Task("gamma",  "This", 0, "Groceries", true, d4, d4, "Neverland");
		List<Task> arr1 = new ArrayList<Task>();
		List<Task> arr2 = new ArrayList<Task>();
		arr1.add(testTask4);
		arr1.add(testTask3);
		arr1.add(testTask2);
		arr1.add(testTask1);
		arr2.add(testTask1);
		arr2.add(testTask2);
		arr2.add(testTask3);
		arr2.add(testTask4);
		TodoController controller = new TodoController(arr1);
		controller.getDateCreatedSorted();
		assertTrue(arr1.equals(arr2));
	}
	
	

}
