import javafx.application.Application;
import view.TodoView;

/**
 * 
 * @author Kaushal Bhat, Mihir Yadav, Shreyas Khandekar, Zachary Florez
 * Class that launches the GUI
 *
 */
public class Todo {
	/**
	 * main method that launches GUI view
	 * @param args the arguments from preferences
	 */
	public static void main(String args[]) {
		Application.launch(TodoView.class, args);
	}
}
