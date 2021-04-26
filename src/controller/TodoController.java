package controller;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
	
	
	public TodoController() {
		model = new TodoModel();

	}
	
	public TodoController(TodoModel customModel) {
		model = customModel;

	}
	
	public TodoController(ArrayList<Task> arr) {
		model = new TodoModel(arr);
	}
	
	public void writeToFile(ObjectOutputStream oos) throws IOException {
		model.saveList(oos);
	}
	
	public void sortByName() {
			
		Collections.sort(model.getTaskList(), new Comparator<Task>() {
			  public int compare(Task t1, Task t2) {
				  return t1.getName().compareTo(t2.getName());
			  }
		});
		
		model.manualNotify();
		
		return;
	}
	
	public void sortByPriority() {
			
		model.getTaskList().sort(Comparator.comparingInt(Task::getPriority).thenComparing(Task::getPriority));
		
		model.manualNotify();
		
		return;
	}
	
	public void sortByCategory() {
		
		Collections.sort(model.getTaskList(), new Comparator<Task>() {
			  public int compare(Task t1, Task t2) {
				  return t1.getCategory().compareTo(t2.getCategory());
			  }
		});
		
		model.manualNotify();
		
		return;
	}
	
	
	public void sortByDateDue() {	
		Collections.sort(model.getTaskList(), new Comparator<Task>() {
			  public int compare(Task t1, Task t2) {
				  return t1.getDateDue().compareTo(t2.getDateDue());
			  }
		});
		
		model.manualNotify();
	}
	
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
	
	public void updateShowCompleted(boolean bool) {
		
		model.updateShowCompleted(bool);
	}
}
