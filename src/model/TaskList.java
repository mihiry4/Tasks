package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TaskList implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8513246459933416900L;
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
