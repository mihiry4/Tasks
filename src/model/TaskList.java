/**
 * 
 * @author Kaushal Bhat, Mihir Yadav, Shreyas Khandekar, Zachary Florez
 * 
 * File for a class that represents a tasklist with multiple tasks
 *  that a user to add, edit, complete. 
 *
 */

package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * 
 * @author Kaushal Bhat, Mihir Yadav, Shreyas Khandekar, Zachary Florez
 * 
 * Class that represents a tasklist with multiple tasks
 *  that a user to add, edit, complete. 
 *
 */
public class TaskList implements Serializable {
	
	/**
	 * Serial version UID to identify this object for serialization.
	 */
	private static final long serialVersionUID = -8513246459933416900L;
	private List<Task> taskList;
	private Map<String, Boolean> categories;
	private boolean showCompleted;
	
	/**
	 * Constructor for the class. Creates an empty task list.
	 */
	public TaskList() {
		
		taskList = new ArrayList<Task>();
		categories = new TreeMap<String, Boolean>();
	}
	
	/**
	 * Constructor for the class. Creates a task list with given list of tasks.
	 * @param list a list of tasks
	 */
	public TaskList(List<Task> list) {
		
		taskList = list;
		
		categories = new TreeMap<String, Boolean>();
		for (Task task : list) {
			String taskCategory = task.getCategory();
			if (!categories.containsKey(taskCategory)) {
				categories.put(taskCategory, true);
			}
		}
	}
	
	/**
	 * Returns the list of tasks as an ArrayList.
	 * @return the list of tasks as an ArrayList.
	 */
	public List<Task> getTaskList() {

		return taskList;
	}
	
	/**
	 * get all categories 
	 * @return map of categories
	 */
	public Map<String, Boolean> getCategories() {
		
		return categories;
	}
	
	
	/**
	 * Adds the given task to the taskList.
	 * @param task the Task object to be added to the taskList.
	 */
	public void addTask(Task task) {
		
		String taskCategory = task.getCategory();
		
		if (!categories.containsKey(taskCategory)) {
			categories.put(taskCategory, true);
		}

		taskList.add(task);
	}
	
	
	/**
	 * Removes the given task from the taskList. If that task does not exist, does nothing.
	 * @param task the task to be removed
	 * @return true if removed successfully and list is changed, false otherwise.
	 */
	public boolean removeTask(Task task) {
		
		if (taskList.remove(task)) return true;
		return false;
	}
	
	/**
	 * Removes from the taskList the task given by the date it was created.
	 * Removes from the taskList the task given by the date it was created (which should
	 * be unique for each task). If such a task exists, it is returned after being removed;
	 * otherwise, taskList is unchanged and null is returned.
	 * @param dateCreated the dateCreated of the task to be removed.
	 * @return the Task deleted if list is changed; otherwise, null.
	 */
	public Task removeTask(Date dateCreated) {
		
		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getDateCreated().equals(dateCreated)) {
				return taskList.remove(i);
			}
		}
		return null;
	}
	
	
	/**
	 * Gets from the task list the task given by the date it was created.
	 * Gets from the task list the task given by the date it was created (which should
	 * be unique for each task). If such a task exists, it is returned. Otherwise, null is returned.
	 * @param dateCreated the dateCreated of the task to be removed.
	 * @return the Task if found; otherwise, null.
	 */
	public Task getTask(Date dateCreated) {

		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getDateCreated().equals(dateCreated)) {
				return taskList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Modifies a task given the task to be modified and all of its new values.
	 * Modifies a task given the task to be modified and all of its new values; values 
	 * that should be kept the same should be passed in as the old value.
	 * @param task the task to be modified.
	 * @param taskName the new name of the task.
	 * @param description the new description of the task.
	 * @param priority the new priority of the task.
	 * @param category the new category of the task.
	 * @param completed the new completedness of the task.
	 * @param dateDue the new due date of the task.
	 * @param location the new location of the task.
	 */
	public void modifyTask(Task task, String taskName, String description, int priority, String category,
			boolean completed, Date dateDue, String location) {
		
		task.setName(taskName);
		task.setDescription(description);
		task.setPriority(priority);
		
		if (!categories.containsKey(category)) {
			categories.put(category, true);
		}
		
		task.setCategory(category);
		task.setCompleted(completed);
		task.setDateDue(dateDue);
		task.setLocation(location);
	}

	/**
	 * returns if showCompleted is true or false
	 * @return if showCompleted variable is true or false
	 */
	public boolean getShowCompleted() {
		return this.showCompleted;	
	}
	
	/**
	 * sets showCompleted in the GUI
	 * @param flag the flag that represents show completed
	 */
	public void setShowCompleted(boolean flag) {
		this.showCompleted = flag;	
	}

	/**
	 * updates showcategory
	 * @param category the category that needs to be shown
	 * @param flag the show status of true or false
	 */
	public void updateShowCategory(String category, boolean flag) {
		
		if (categories.containsKey(category)) {
			categories.put(category, flag);
		}
		
	}

}
