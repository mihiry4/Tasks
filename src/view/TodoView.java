package view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.ZoneId;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import controller.TodoController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
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
	
	private void setup() {
		model = new TodoModel();
		controller = new TodoController(model);
		model.addObserver(this); 
	}
	
	public void start(Stage stage) {
		this.myStage = stage;
		window = new BorderPane();
		menuBar = new MenuBar();
		
		
		
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
		
		// set window layer
		window.setTop(menuBar);
		window.setBottom(bottomPane);
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
			System.out.println("add task plus button clicked");
			addNewTask();
		});
		
		// TODO: Make a transparent circle on top of the stack pane
		// and add the event handler to it.
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
		createPopUp("", "", 1, "Work", false, new Date(),"");
	}
	
	/**
	 * Function called when addTask Circle is pressed on
	 * to get users input to customize an added new task. 
	 * 
	 * no return.
	 */
	private void modifyTask(Task task) {
		createPopUp(task.getName(), task.getDescription(), task.getPriority(), 
				task.getCategory(), task.isCompleted(), task.getDateDue(), task.getLocation());
	}
	
	
	private void createPopUp(String taskName, String description, int priority, String category, boolean completed,
			Date dateDue, String location) {
		final Stage dialog = new Stage();
		dialog.setResizable(false);
		dialog.setTitle("Add Task");
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(myStage);
        HBox dialogHbox = new HBox(60);
        VBox primaryDetailsVbox = new VBox(20);
        VBox secondaryDetailsVbox = new VBox(20);
        primaryDetailsVbox.setPadding(new Insets(8, 8, 8, 8));
        
        // adds name and description fields and completed checkbox
        TextField nameField = new TextField();
        nameField.setText(taskName);
        TextArea DescriptionField = new TextArea();
        DescriptionField.setText(description);
        nameField.setPromptText("Name");
        nameField.setPrefWidth(180);
        nameField.setMaxWidth(200);
        DescriptionField.setPromptText("Description");
        DescriptionField.setPrefWidth(180);
        DescriptionField.setMaxWidth(200);
        DescriptionField.setPrefHeight(100);
        DescriptionField.setMaxHeight(100);
        CheckBox cb = new CheckBox("Completed");
        cb.setSelected(completed);
        primaryDetailsVbox.getChildren().addAll(nameField,DescriptionField,cb);

        //adds category, priority, due date, Location and submit button elements
        secondaryDetailsVbox.setPadding(new Insets(8, 8, 8, 8));
        Rectangle backGColor = new Rectangle(270,600);
        backGColor.setFill(javafx.scene.paint.Color.LIGHTGRAY);
        StackPane stackPane = new StackPane();
        Text categoryText = new Text("Category");
        final ComboBox<String> categoryComboBox = new ComboBox<String>();
        categoryComboBox.getItems().addAll(
            "Work",
            "Home",
            "Personal",
            "Health",
            "Lifestyle"
        );
        categoryComboBox.setValue("Work");
        Text priorityText = new Text("Priority");
        final ComboBox<Integer> priorityComboBox = new ComboBox<Integer>();
        priorityComboBox.getItems().addAll(
            1,
            2,
            3,
            4,
            5
        );   
        priorityComboBox.setValue(priority);
        Text dueDateText = new Text("Due Date");
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(dateDue.toInstant()
        	      .atZone(ZoneId.systemDefault())
        	      .toLocalDate());
        Text locationHeading = new Text("Location");
        TextField locationField = new TextField();
        locationField.setPromptText("Location");
        locationField.setPrefWidth(160);
        locationField.setMaxWidth(180);
        locationField.setText(location);
        Button submitDetailsButton = new Button("Submit");
        
        
        // printing out all the fields on submit button
        submitDetailsButton.setOnAction((event)->{
        	System.out.println(nameField.getText());
        	System.out.println(DescriptionField.getText());
        	System.out.println(cb.isSelected()); // return a boolean
        	System.out.println(categoryComboBox.getValue());
        	System.out.println(priorityComboBox.getValue());
        	System.out.println(datePicker.getValue()); // returns in format 2021-04-28
        	System.out.println(locationField.getText());
        	dialog.close();
        });
        submitDetailsButton.setStyle("-fx-background-color: #008300; -fx-text-fill: white");
        secondaryDetailsVbox.getChildren().addAll(categoryText, categoryComboBox, 
        		priorityText, priorityComboBox, dueDateText, 
        		datePicker,locationHeading, locationField, submitDetailsButton);
        stackPane.getChildren().addAll(backGColor,secondaryDetailsVbox);

        dialogHbox.getChildren().addAll(primaryDetailsVbox,stackPane);
        Scene dialogScene = new Scene(dialogHbox, 500, 400);
        dialog.setScene(dialogScene);
        dialog.show();
	}

	@Override
	public void update(Observable o, Object arg) {
		// 
		// TODO Auto-generated method stub
		
	}
}
