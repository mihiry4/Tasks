package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

/**
 * @author Kaushal Bhat, Mihir Yadav, Shreyas Khandekar, Zachary Florez
 *
 * Class that will hold the Model of ToDo Application. 
 */

@SuppressWarnings("deprecation")
public class TodoModel extends Observable {
	
	private TaskList taskList;
	
	public TodoModel() {
		this.taskList = new TaskList();
	}
	
	public TodoModel(TaskList taskList) {
		this.taskList = taskList;
	}
	
	public TodoModel(ArrayList<Task> taskList) {
		this.taskList = new TaskList(taskList);
	}
	
	/**
	 * Method to get a list of all the tasks that a user has. 
	 * 
	 * @return List<Task> that contains all of the current tasks a user has. 
	 */
	public List<Task> getTaskList(){
		
		return this.taskList.getTaskList();
		
	}
	
	
	/**
	 * Method to get number of tasks a user is working with.
	 * 
	 * @return number of current tasks. 
	 */
	public int getTaskListSize() {
		return this.taskList.getTaskList().size(); 
	}
	
	/**
	 * Add a task to the TaskList
	 * @param task The task to be added
	 */
	public void addTask(Task task) {
		this.taskList.addTask(task);
	}
	
	/**
	 * Removes the given task from the taskList in the model. 
	 * If that task does not exist, it returns false and leaves the model unchaged
	 * @param task the task to be removed
	 * @return true if removed successfully, false otherwise
	 */
	public boolean removeTask(Task task) {
		
		return taskList.removeTask(task);
		
	}

	/**
	 * Removes from the taskList the task given by the date it was created (which should
	 * be unique for each task). If such a task exists, it is returned after being removed;
	 * otherwise, taskList is unchanged and null is returned.
	 * @param dateCreated the date the task was created
	 * @return the Task deleted if list is changed; otherwise, null.
	 */
	public Task removeTask(Date dateCreated) {
		return this.taskList.removeTask(dateCreated);
	}
	
	
	/**
	 * Gets from the task list the task given by the date it was created. 
	 * If such a task exists, it is returned. Otherwise, null is returned.
	 * @param dateCreated the dateCreated of the task to be removed.
	 * @return the Task if found; otherwise, null.
	 */
	public Task getTask(Date dateCreated) {
		return this.taskList.getTask(dateCreated);
	}
	
	/**
	 * Modifies a task given the task to be modified and all of its new values; values 
	 * that should be kept the same should be passed in as the old value.
	 * @param task the task to be modified.
	 * @param taskName the new name of the task.
	 * @param description the new description of the task.
	 * @param priority the new priority of the task.
	 * @param category the new category of the task.
	 * @param completed the new completeness of the task.
	 * @param dateDue the new due date of the task.
	 * @param location the new location of the task.
	 */
	public void modifyTask(Task task, String taskName, String description, int priority, String category,
			boolean completed, Date dateDue, String location) {
		this.taskList.modifyTask(task, taskName, description, priority, category, completed, dateDue, location);
	}
	
	/**
	 * Notifies the observers that the model has changed
	 */
	public void manualNotify() {
		setChanged();
		notifyObservers(this.taskList);
	}
	
	/**
	 * Function to set flag for if we want to show completed tasks
	 * @param flag
	 */
	public void updateShowCompleted(boolean flag) {
		this.taskList.setShowCompleted(flag);	
	}
}
