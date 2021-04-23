package TodoTaskList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import TodoTask.Task;

public class TaskList implements Serializable {
	
	HashMap<Date, Task> taskList; 	// Date is Priority 
	
	
	public TaskList() {
		// TODO 
	}
	
	
	public List<Task> getTaskList() {
		// TODO
		List<Task> dummyValue = new ArrayList<Task>();
		return dummyValue;
	}
	
	
	public void addTask() {
		// TODO 
		taskList.put(null, null); 
	}
	
	
	public Task removeTask() {
		//TODO
		return new Task();
	}
	
	
	public Task getTask() {
		// TODO
		return new Task();
	}
	
	
	public void modifyTask() {
		// TODO
	}

}
