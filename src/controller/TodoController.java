package controller;
import java.util.ArrayList;
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
	
	public void getNameSorted() {
		// TODO
//		Collections.sort(taskList, new Comparator<User>() {
//			  @Override
//			  public int compare(Task t1, Task t2) {
//			    return t1.getTaskName().compareTo(t2.getTaskName());
//			  }
//			});
		return;
	}
	
	public void getPrioritySorted() {
		// TODO
		return;
	}
	
	public void getCategorySorted() {
		// TODO
		return;
	}
	
	public void getCompletionSorted() {
		// TODO
		return;
	}
}
