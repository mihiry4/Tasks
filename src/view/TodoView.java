package view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Observable;
import java.util.Observer;

import controller.TodoController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import model.Task;
import model.TodoModel;

/**
 * 
 * @author Kaushal Bhat, Mihir Yadav, Shreyas Khandekar, Zachary Florez
 * 
 * Class that will hold the View of the ToDo application. 
 *
 */
public class TodoView extends Application implements Observer {
	
	private static BorderPane window;
	TodoModel model;
	TodoController controller;
	StackPane bottomPane;
	private MenuBar menuBar;
	private Circle addTaskButton, transparentCircle;
	private CheckMenuItem showCompleted;
	private MenuItem newFile, saveFile, loadFile;
	private MenuItem name, priority, category, dueDate, dateCreated;
	private Stage myStage;
	private VBox vbox;
	private VBox centerWindow;
	private HBox topColumns;
	
	private void setup() {
		model = new TodoModel();
		controller = new TodoController(model);
		model.addObserver(this); 
	}
	
	public void start(Stage stage) {
		this.myStage = stage;
		window       = new BorderPane();
		menuBar      = new MenuBar();
		vbox         = new VBox();
		centerWindow = new VBox();
		topColumns   = new HBox();
		
		
		// Menu for files and sorting 
		Menu fileMenu   = new Menu("File");
		Menu sortByMenu = new Menu("View");
		Menu sortBy     = new Menu("Sort By");
		
		// Menu Items for fileMenu: 
		newFile  = new MenuItem("New File");
		saveFile = new MenuItem("Save...");
		loadFile = new MenuItem("Load...");
		fileMenu.getItems().addAll(newFile, saveFile, loadFile);
		
		// Menu Items for sortBy: (Menu inside Menu) 
		name        = new MenuItem("Name");
		priority    = new MenuItem("Priority");
		category    = new MenuItem("Category");
		dueDate     = new MenuItem("Due Date");
		dateCreated = new MenuItem("Date Created");
		sortBy.getItems().addAll(name, priority, category, dueDate, dateCreated);
		
		showCompleted = new CheckMenuItem("Show Completed Tasks");
		sortByMenu.getItems().addAll(sortBy, showCompleted);
		
		// Add both Menus to MenuBar
		menuBar.getMenus().addAll(fileMenu, sortByMenu);
		
		// Method called to set all event handlers for all
		// different drop down menus. 
		setEventHandlers();
			
		// Function called to create button on bottom of window
		// to add a task. 
		createAddTaskButton();
		
		// Setup the columns headers and do the initial setup
		createColumnHeaders();
		
		
		centerWindow.getChildren().addAll(topColumns, vbox);
		centerWindow.setSpacing(14.0);
		//centerWindow.setStyle("-fx-background-color:#D2B48C");
		
		
		// set window layer
		window.setTop(menuBar);
		window.setBottom(bottomPane);
		window.setCenter(centerWindow);
		window.setAlignment(bottomPane, Pos.CENTER);
		
		// Set new scence and display. 
		Scene scene = new Scene(window, 400, 600);
		stage.setScene(scene);
		stage.setTitle("ToDo Application");
		stage.show();
	}
	
	
	private void createColumnHeaders() {
		// TODO Create the headers for column
		// And have a grey-ish text box that says no tasks click + sign to add
		// HBOX for each row
		// V box to contains HBoxes
		// Column headers should not be part of the VBOX which contains tasks
		Text name = new Text(" Task          || ");
		Text dueDate = new Text("Due Date || ");
		Text dateCreated = new Text("Date Created || ");
		Text category    = new Text("Category || ");
		Text priority    = new Text("Priority");
		
		name       .setFont(new Font(15));
		dueDate    .setFont(new Font(15));
		dateCreated.setFont(new Font(15));
		category   .setFont(new Font(15));
		priority   .setFont(new Font(15));
		
		topColumns.getChildren().addAll(name, dateCreated, dueDate, category, priority);
		topColumns.setStyle("-fx-background-color:#C0C0C0");
		
		
		vbox.setSpacing(10.0);
		vbox.setMinHeight(480);
	}

	/**
	 * Function called from start() to set all of the event handlers 
	 * for all the different drop down menus. 
	 * 
	 * no return.
	 */
	private void setEventHandlers() {
		
		
		name.setOnAction((event) -> {
			controller.sortByName();
		});
		
		
		priority.setOnAction((event) -> {
			controller.sortByPriority();
		});
		
		
		category.setOnAction((event) -> {
			controller.sortByCategory();
		});
		
		
		dueDate.setOnAction((event) -> {
			controller.sortByDateDue();
		});
		
		
		dateCreated.setOnAction((event) -> {
			controller.sortByDateCreated();
		});
		
		
		newFile.setOnAction((event) -> {
			setup();
			// TODO: Add a pass- through method in the controller to replace
			// this call which is bad style
			model.manualNotify();
			// TODO: Maybe in the future, add a pop-up to save the current file
			// before in the future. Also do that on close.
		});
		
		
		saveFile.setOnAction((event) -> {
			FileChooser fileChooser = new FileChooser();
		    fileChooser.setTitle("Save");
		    fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.dat"));
		    //Adding action on the menu item
	        //Opening a dialog box
		    File file = fileChooser.showSaveDialog(myStage);
	        if (file != null) {
	        	String fileName = file.getName();
                try {
					FileOutputStream fout = new FileOutputStream(fileName);
					ObjectOutputStream oos = new ObjectOutputStream(fout);
					controller.writeToFile(oos);
				} catch (IOException e) {
					// catch block
					Alert a = new Alert(Alert.AlertType.INFORMATION);
					a.setTitle("Message");
					a.setContentText("YIKES!");
					a.setHeaderText("Unable to Save game");
					a.showAndWait();
				}
	        }
		});
		
		
		
		loadFile.setOnAction((event) -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			fileChooser.getExtensionFilters().addAll(
					new ExtensionFilter("Text Files", "*.dat"));
			File selectedFile = fileChooser.showOpenDialog(this.myStage);
			if (selectedFile != null) {
				model = new TodoModel(selectedFile);
			}
		});
		
		
		showCompleted.setOnAction((event) -> {
			controller.updateShowCompleted(showCompleted.isSelected());
		});
	}
	
	
	/**
	 * Function called from start to create the Circle on bottom 
	 * of window and to set an event handler when circle is pressed. 
	 * 
	 * No return.
	 */
	private void createAddTaskButton() {
		bottomPane = new StackPane();
		bottomPane.setPadding(new Insets(10));
		
		// Plus Sign above Circle
		Text plusSign = new Text("+");
		plusSign.setFill(Color.WHITE);
		plusSign.setFont(new Font(40));
		plusSign.setBoundsType(TextBoundsType.VISUAL);
		
		// Circle
		double radius = 10 + getWidth(plusSign)/2;
		addTaskButton = new Circle();
		addTaskButton.setRadius(radius);
		addTaskButton.setFill(Color.GREEN);
		
		// Transparent Circle
		transparentCircle = new Circle();
		transparentCircle.setRadius(radius);
		transparentCircle.setFill(Color.TRANSPARENT);
		
		// Adding to stack pane
		bottomPane.getChildren().addAll(addTaskButton, plusSign, transparentCircle);
		
		transparentCircle.setOnMouseClicked((event) -> {
			System.out.println("hi");
			addNewTask();
		});
	}
	
	private double getWidth(Text text) {
		new Scene(new Group(text));
		text.applyCss();
		return text.getLayoutBounds().getWidth();
	}
	
	
	/**
	 * Function called when addTask Circle is pressed on
	 * to get users input to create and add a new task. 
	 * 
	 * no return.
	 */
	private void addNewTask() {
		// Mihir
		// have a function to make the popup widow
		// call it here
		// TODO: Create a new Popup
	}
	
	/**
	 * Function called when addTask Circle is pressed on
	 * to get users input to create and add a new task. 
	 * 
	 * no return.
	 */
	private void modifyTask(Task task) {
		// Mihir
		// have a function to make the popup widow : same as the one called in addNewTask
		// add code to prepopulate the popup with the task
		// TODO: Create a new Popup
	}
	

	@Override
	public void update(Observable o, Object arg) {
		// 
		// TODO Auto-generated method stub
		
	}
}
