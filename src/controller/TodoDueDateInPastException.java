package controller;

/**
 * Class: TodoDueDateInPastException
 * @author Kaushal Bhat, Mihir Yadav, Shreyas Khandekar, Zachary Florez
 * Purpose: Thrown when user tries to choose a date before current date
 */
public class TodoDueDateInPastException extends Exception{


	private static final long serialVersionUID = 1L;
	
	/**
	 * @param message
	 */
	public TodoDueDateInPastException(String message) {
		super(message);
	}
	
	/**
	 * String representation of the exception
	 */
	public String toString() {
		
		return "Due Date cannot be in the past: " + getMessage() + ".";
	}

}
