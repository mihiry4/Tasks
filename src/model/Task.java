/**
 * 
 * @author Kaushal Bhat, Mihir Yadav, Shreyas Khandekar, Zachary Florez
 * 
 * File for class that represents a single task for a user to add, edit, complete. 
 *
 */


package model;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Kaushal Bhat, Mihir Yadav, Shreyas Khandekar, Zachary Florez
 * 
 * Class that represents a single task for a user to add, edit, complete. 
 *
 */
public class Task implements Serializable {
	
	
	private static final long serialVersionUID = -8426466080288612855L;
	private String taskName, description; 
	private int priority; 
	private String category;
	private boolean completed; 
	private Date dateCreated, dateDue;
	private String location;
	
	
	 /**
	  * constructor to create a new task
	  * @param taskName the name of a task
	  * @param description the description of a task
	  * @param priority the priority of a task
	  * @param category the category of a task
	  * @param completed the completed of a task
	  * @param dateDue the date due of a task
	  * @param dateCreated the date created of a task
	  * @param location  the location of a task
	  */
	public Task(String taskName, String description, int priority, String category, boolean completed,
				Date dateDue, Date dateCreated, String location) {
		this.taskName = taskName;
		this.description = description;
		this.priority = priority;
		this.category = category;
		this.completed = completed;
		this.dateDue = dateDue;
		this.dateCreated = dateCreated;
		this.location = location;
	}
	
	/**
	 *  constructor to create a new task
	 * @param taskName the name of a task
	 * @param description the description of a task
	 * @param priority the priority of a task
	 * @param category the category of a task
	 * @param dateDue the date due of a task
	 * @param location the location of a task
	 */
	public Task(String taskName, String description, int priority, String category,
				Date dateDue, String location) {
		this(taskName, description, priority, category, false, dateDue, getNow(), location);
	}
	
	/**
	 * gets time in milliseconds
	 * @return Date date in milli seconds
	 */
	private static Date getNow() {
	    long millis = System.currentTimeMillis();  
	    Date retval = new Date(millis);  
	     //System.out.println(retval);  
		return retval;
	}
	
	
	/**
	 * gets name of the task
	 * @return name as a string
	 */
	public String getName() {
		return taskName;
	}
	
	/**
	 * gets description of the task
	 * @return description as a string
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * gets priority of the task
	 * @return priority as an int
	 */
	public int getPriority() {
		return priority;	
	}
	
	/**
	 * gets category of the task
	 * @return category as a string
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * gets completion status of the task
	 * @return completion as a boolean
	 */
	public boolean isCompleted() {
		return completed;
	}
	
	/**
	 * gets date created of the task
	 * @return date as a date object
	 */
	public Date getDateCreated() {
		return dateCreated;
	}
	
	/**
	 * gets due date of the task
	 * @return date as a date object
	 */
	public Date getDateDue() {
		return dateDue;
	}
	
	/**
	 * gets location of the task
	 * @return location as a string
	 */
	public String getLocation() {
		return location;
	}
	
	
	/**
	 * sets name of the task
	 * @param newTaskName a new task name
	 */
	public void setName(String newTaskName) {
		taskName = newTaskName;
	}
	
	/**
	 * sets description of a task
	 * @param newDescription a new description
	 */
	public void setDescription(String newDescription) {
		description = newDescription;
	}
	
	/**
	 * sets priority of the task
	 * @param newPriority a new priority
	 */
	public void setPriority(int newPriority) {
		priority = newPriority;	
	}
	
	/**
	 * sets category of a task
	 * @param newCategory a new category
	 */
	public void setCategory(String newCategory) {
		category = newCategory;
	}
	
	/**
	 * sets completion of a task
	 * @param newCompleted a new completion status
	 */
	public void setCompleted(boolean newCompleted) {
		completed = newCompleted;
	}
	
	/**
	 * sets new date due
	 * @param newDateDue a new due date
	 */
	public void setDateDue(Date newDateDue) {
		dateDue = newDateDue;
	}
	
	/**
	 * sets location of the task
	 * @param newLocation a new Location 
	 */
	public void setLocation(String newLocation) {
		location = newLocation;
	}
	
}
