package view;

import controller.TodoController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.TodoModel;

/**
 * 
 * @author Kaushal Bhat, Mihir Yadav, Shreyas Khandekar, Zachary Florez
 * 
 * Class that will hold the View of the ToDo application. 
 *
 */
public class TodoView extends Application {
	
	private static BorderPane window;
	TodoModel model;
	TodoController controller;
	StackPane bottomButton;
	private MenuBar menuBar;
	private Circle addTask;
	private CheckMenuItem isCompleted;
	private MenuItem newFile, saveFile, loadFile;
	private MenuItem name, priority, category, dueDate, dateCreated;
	
	public void start(Stage stage) {
		
		window = new BorderPane();
		menuBar = new MenuBar();
		model = new TodoModel();
		controller = new TodoController();
		
		// Menu for files and sorting 
		Menu fileMenu   = new Menu("File ");
		Menu sortByMenu = new Menu("Sort ");
		Menu sortBy     = new Menu("Sort By");
		
		// Menu Items for fileMenu: 
		newFile  = new MenuItem("New File ");
		saveFile = new MenuItem("Save File");
		loadFile = new MenuItem("Load File");
		fileMenu.getItems().addAll(newFile, saveFile, loadFile);
		
		// Menu Items for sortBy: (Menu inside Menu) 
		name        = new MenuItem("Sort By Name");
		priority    = new MenuItem("Sort By Priority");
		category    = new MenuItem("Sort By Category");
		dueDate     = new MenuItem("Sort By Due Date");
		dateCreated = new MenuItem("Sort By Date Created");
		sortBy.getItems().addAll(name, priority, category, dueDate, dateCreated);
		
		isCompleted = new CheckMenuItem("Is Completed");
		sortByMenu.getItems().addAll(sortBy, isCompleted);
		
		// Add both Menus to MenuBar
		menuBar.getMenus().addAll(fileMenu, sortByMenu);
		
		// Method called to set all event handlers for all
		// different drop down menus. 
		setEventHandlers();
			
		// Function called to create button on bottom of window
		// to add a task. 
		createAddTask();
		
		// set window layer
		window.setTop(menuBar);
		window.setBottom(bottomButton);
		window.setAlignment(bottomButton, Pos.CENTER);
		
		// Set new scence and display. 
		Scene scene = new Scene(window, 400, 600);
		stage.setScene(scene);
		stage.setTitle("ToDo Application");
		stage.show();
	}
	
	
	/**
	 * Function called from start() to set all of the event handlers 
	 * for all the different drop down menus. 
	 * 
	 * no return.
	 */
	private void setEventHandlers() {
		
		// TODO
		name.setOnAction((event) -> {
			controller.sortByName();
		});
		
		// TODO
		priority.setOnAction((event) -> {
			controller.sortByPriority();
		});
		
		// TODO
		category.setOnAction((event) -> {
			controller.sortByCategory();
		});
		
		// TODO
		dueDate.setOnAction((event) -> {
			controller.sortByDateDue();
		});
		
		// TODO
		dateCreated.setOnAction((event) -> {
			controller.sortByDateCreated();
		});
		
		// TODO
		newFile.setOnAction((event) -> {
		});
		
		// TODO
		saveFile.setOnAction((event) -> {
		});
		
		// TODO
		loadFile.setOnAction((event) -> {
		});
		
		// TODO
		isCompleted.setOnAction((event) -> {
		});
	}
	
	
	/**
	 * Function called from start to create the Circle on bottom 
	 * of window and to set an event handler when circle is pressed. 
	 * 
	 * No return.
	 */
	private void createAddTask() {
		bottomButton = new StackPane();
		
		// Circle
		addTask = new Circle();
		addTask.setRadius(25);
		addTask.setFill(Color.GREEN);
		
		// Plus Sign above Circle
		Text plusSign = new Text("+");
		plusSign.setFill(Color.WHITE);
		plusSign.setFont(new Font(40));
		
		bottomButton.getChildren().addAll(addTask, plusSign);
		
		bottomButton.setOnMouseClicked((event) -> {
			addNewTask();
		});
	}
	
	
	/**
	 * Function called when addTask Circle is pressed on
	 * to get users input to create and add a new task. 
	 * 
	 * no return.
	 */
	private void addNewTask() {
		// TODO 
	}
}
