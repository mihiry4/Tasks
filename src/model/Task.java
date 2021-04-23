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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8426466080288612855L;
	private String taskName, description; 
	private int priority; 
	private String category;
	private boolean completed; 
	private Date dateCreated, dateDue;
	private String location;
	
	
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
	
	public Task(String taskName, String description, int priority, String category,
				Date dateDue, String location) {
		this(taskName, description, priority, category, false, dateDue, getNow(), location);
	}
	
	private static Date getNow() {
	    long millis = System.currentTimeMillis();  
	    Date retval = new Date(millis);  
	     //System.out.println(retval);  
		return retval;
	}
	
	
	// Getters
	public String getName() {
		return taskName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getPriority() {
		return priority;	
	}
	
	public String getCategory() {
		return category;
	}
	
	
	public boolean isCompleted() {
		return completed;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public Date getDateDue() {
		return dateDue;
	}
	
	public String getLocation() {
		return location;
	}
	
	
	// Setters
	public void setName(String newTaskName) {
		taskName = newTaskName;
	}
	
	public void setDescription(String newDescription) {
		description = newDescription;
	}
	
	public void setPriority(int newPriority) {
		priority = newPriority;	
	}
	
	public void setCategory(String newCategory) {
		category = newCategory;
	}
	
	
	public void setCompleted(boolean newCompleted) {
		completed = newCompleted;
	}
	
	/*
	 * Cannot change the Date created
	public void setDateCreated(Date newDateCreated) {
		dateCreated = newDateCreated;
	}
	*/
	public void setDateDue(Date newDateDue) {
		dateDue = newDateDue;
	}
	
	public void setLocation(String newLocation) {
		location = newLocation;
	}
	
}
