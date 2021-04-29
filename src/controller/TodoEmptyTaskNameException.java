package controller;

public class TodoEmptyTaskNameException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TodoEmptyTaskNameException(String message) {
		super(message);
	}
	
	public String toString() {
		
		return "Task must have a name.";
	}

}
