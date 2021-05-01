package controller;

/**
 * Class: TodoEmptyTaskNameException
 * @author Kaushal Bhat, Mihir Yadav, Shreyas Khandekar, Zachary Florez
 * Purpose: Thrown when user tries to submit without specifying a task name
 */

public class TodoEmptyTaskNameException extends Exception{

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param message
	 */
	public TodoEmptyTaskNameException(String message) {
		super(message);
	}
	
	/**
	 * String representation of the exception
	 */
	public String toString() {
		
		return "Task must have a name.";
	}

}
