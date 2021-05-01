package controller;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import model.Task;
import model.TodoModel;

/**
 * 
 * @author Kaushal Bhat, Mihir Yadav, Shreyas Khandekar, Zachary Florez
 *
 */
public class TodoController {
	
	
	private TodoModel model;
	
	
	/**
	 * Constructor that uses a model to create an instance
	 * @param customModel model associated with the constructor
	 */
	public TodoController(TodoModel customModel) {
		model = customModel;

	}
	
	/**
	 * Constructor that uses a model to create an instance
	 * @param customModel model associated with the constructor
	 */
	public TodoController(List<Task> arr) {
		model = new TodoModel(arr);
	}
	
	/**
	 * Used to write the model/board to an object output stream
	 * @param oos Object output stream to which we write
	 * @throws IOException
	 */
	public void writeToFile(ObjectOutputStream oos) throws IOException {
		model.saveList(oos);
	}
	
	/**
	 * Used to sort taskList by name
	 */
	public void sortByName() {
			
		Collections.sort(model.getTaskList(), new Comparator<Task>() {
			  public int compare(Task t1, Task t2) {
				  return t1.getName().compareTo(t2.getName());
			  }
		});
		
		model.manualNotify();
		
		return;
	}
	
	/**
	 * Used to sort taskList by priority
	 */
	public void sortByPriority() {
			
		model.getTaskList().sort(Comparator.comparingInt(Task::getPriority).thenComparing(Task::getPriority));
		
		model.manualNotify();
		
		return;
	}
	
	/**
	 * Used to sort taskList by category
	 */
	public void sortByCategory() {
		
		Collections.sort(model.getTaskList(), new Comparator<Task>() {
			  public int compare(Task t1, Task t2) {
				  return t1.getCategory().compareTo(t2.getCategory());
			  }
		});
		
		model.manualNotify();
		
		return;
	}
	
	/**
	 * Used to sort taskList by due date
	 */
	public void sortByDateDue() {	
		Collections.sort(model.getTaskList(), new Comparator<Task>() {
			  public int compare(Task t1, Task t2) {
				  return t1.getDateDue().compareTo(t2.getDateDue());
			  }
		});
		
		model.manualNotify();
	}
	
	/**
	 * Used to sort taskList by date created
	 */
	public void sortByDateCreated() {
		
		Collections.sort(model.getTaskList(), new Comparator<Task>() {
			  public int compare(Task t1, Task t2) {
				  return t1.getDateCreated().compareTo(t2.getDateCreated());
			  }
		});
		
		model.manualNotify();
	}
	
	/**
	 * Moves the task up or down in the TaskList
	 * Swaps task with the previous or next task based on direction (true is 
	 * up, false is down) unless there is no previous or next task (eg. direction if false
	 * and task is the last task)
	 * @param task the task to be moved
	 * @param direction an int: 1 for up, -1 for down
	 */
	public void manualReorder(Task task, int direction) {
		
			
		int index = model.getTaskList().indexOf(task);
		if (index != -1) {
			int swapIndex = index + direction;
			if (swapIndex < model.getTaskList().size() && swapIndex >= 0) {
				Collections.swap(model.getTaskList(), index, swapIndex);
			}
		}
		model.manualNotify();
	}
	
	/**
	 * Updates show completed for task completion
	 * @param bool status of task completion
	 */
	public void updateShowCompleted(boolean bool) {
		
		model.updateShowCompleted(bool);
		model.manualNotify();
	}
	
	
	/**
	 * creates a new task 
	 * @param name the name of a task
	 * @param description the description of a task
	 * @param priority the priority of a task
	 * @param category the category of a task
	 * @param completed the completion of a task
	 * @param dateDue the due date of a task
	 * @param location the location of a task
	 * @return Task newly created task
	 * @throws TodoDueDateInPastException
	 * @throws TodoEmptyTaskNameException
	 */
	public Task createNewTask(String name, String description, int priority, String category, boolean completed
			, Date dateDue, String location) throws TodoDueDateInPastException, TodoEmptyTaskNameException {
		Date currDate = new Date();
		if(dateDue.compareTo(currDate) < 0) {
			throw new TodoDueDateInPastException(dateDue.toString() + " is in the past");
		}
		if(name.equals("")) {
			throw new TodoEmptyTaskNameException("Task must have a name");
		}
		Task newTask = new Task(name, description, priority, category, completed, dateDue, new Date(), location);
		model.addTask(newTask);
		return newTask;
	}
	
	/**
	 * modifies an already existing task
	 * @param task the task needed to be modified
	 * @param taskName the name of the task
	 * @param description the description of a task
	 * @param priority the priority of a task
	 * @param category the category of a task
	 * @param completed the completion of a task
	 * @param dateDuen the due date of a task
	 * @param location the location of a task
	 * @throws TodoDueDateInPastException
	 * @throws TodoEmptyTaskNameException
	 */
	public void modifyTask(Task task, String taskName, String description, int priority, String category,
			boolean completed, Date dateDue, String location) throws TodoDueDateInPastException, TodoEmptyTaskNameException {
		Date currDate = new Date();
		if(dateDue.compareTo(currDate) < 0) {
			throw new TodoDueDateInPastException(dateDue.toString() + " is in the past");
		}
		if(taskName.equals("")) {
			throw new TodoEmptyTaskNameException("Task must have a name");
		}
		model.modifyTask(task, taskName, description, priority, category, completed, dateDue, location);
	}
	
	/**
	 * removes an already existing task
	 * @param task
	 * @return if task was deleted successfully or not
	 */
	public boolean removeTask(Task task) {
		
		return model.removeTask(task);
	}
	
	/*
	 * calls manualNotify in the model to notify
	 */
	public void manualNotify() {
		
		model.manualNotify();
	}
		
}
