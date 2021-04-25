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
	
	//TODO: ONCE METHODS ARE TESTED WELL:
	// get rid of taskList field, call model.getTaskList() in each method instead
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
		//TODO: taskList = model.getTaskList();	
		Collections.sort(taskList, new Comparator<Task>() {
			  public int compare(Task t1, Task t2) {
				  return t1.getName().compareTo(t2.getName());
			  }
		});
		
		//TODO: model.manualNotify();
		
		return;
	}
	
	public void sortByPriority() {
		//TODO: taskList = model.getTaskList();	
		taskList.sort(Comparator.comparingInt(Task::getPriority).thenComparing(Task::getPriority));
		
		//TODO: model.manualNotify();
		
		return;
	}
	
	public void sortByCategory() {
		//TODO: taskList = model.getTaskList();	
		Collections.sort(taskList, new Comparator<Task>() {
			  public int compare(Task t1, Task t2) {
				  return t1.getCategory().compareTo(t2.getCategory());
			  }
		});
		
		//TODO: model.manualNotify();
		
		return;
	}
	
	
	public void sortByDateDue() {
		//TODO: taskList = model.getTaskList();	
		Collections.sort(taskList, new Comparator<Task>() {
			  public int compare(Task t1, Task t2) {
				  return t1.getDateDue().compareTo(t2.getDateDue());
			  }
		});
		
		//TODO: model.manualNotify();
	}
	
	public void sortByDateCreated() {
		//TODO: taskList = model.getTaskList();	
		Collections.sort(taskList, new Comparator<Task>() {
			  public int compare(Task t1, Task t2) {
				  return t1.getDateCreated().compareTo(t2.getDateCreated());
			  }
		});
		
		//TODO: model.manualNotify();
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
		
		//TODO: taskList = model.getTaskList();	
		int index = taskList.indexOf(task);
		if (index != -1) {
			int swapIndex = index + direction;
			if (swapIndex < taskList.size() && swapIndex >= 0) {
				Collections.swap(taskList, index, swapIndex);
			}
		}
		//TODO: model.manualNotify();
	}
}
