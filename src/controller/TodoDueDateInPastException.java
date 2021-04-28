package controller;

public class TodoDueDateInPastException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TodoDueDateInPastException(String message) {
		super(message);
	}
	
	public String toString() {
		
		return "Due Date cannot be in the past: " + getMessage() + ".";
	}

}
