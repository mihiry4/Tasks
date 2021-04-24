package controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
	private List<Task> taskList;
	
	public TodoController() {
		model = new TodoModel();
		taskList = model.getTaskList();
	}
	
	public TodoController(TodoModel customModel) {
		model = customModel;
		taskList = model.getTaskList();
	}
	
	public TodoController(List<Task> arr) {
		taskList = arr;
	}
	
	public void sortByName() {
		Collections.sort(taskList, new Comparator<Task>() {
			  public int compare(Task t1, Task t2) {
				  return t1.getName().compareTo(t2.getName());
			  }
		});
		return;
	}
	
	public void sortByPriority() {
		taskList.sort(Comparator.comparingInt(Task::getPriority).thenComparing(Task::getPriority));
		return;
	}
	
	public void sortByCategory() {
		Collections.sort(taskList, new Comparator<Task>() {
			  public int compare(Task t1, Task t2) {
				  return t1.getCategory().compareTo(t2.getCategory());
			  }
		});
		return;
	}
	
	
	public void sortByDateDue() {
		Collections.sort(taskList, new Comparator<Task>() {
			  public int compare(Task t1, Task t2) {
				  return t1.getDateDue().compareTo(t2.getDateDue());
			  }
		});
	}
	
	public void sortByDateCreated() {
		Collections.sort(taskList, new Comparator<Task>() {
			  public int compare(Task t1, Task t2) {
				  return t1.getDateCreated().compareTo(t2.getDateCreated());
			  }
		});
	}
}
