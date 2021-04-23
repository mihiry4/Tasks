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
	String taskName, description, category, location; 
	int priority; 
	boolean completed; 
	Date dateCreated, dateDue;
	
	
	public Task() {
		// TODO 
	}
	
	public boolean isCompleted() {
		return completed;
	}
}
