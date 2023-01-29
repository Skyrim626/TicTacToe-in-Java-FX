package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import player.Player;

/**
 * A class when the user selects
 * 
 * @author dell
 *
 */
public class Registration implements EventHandler<ActionEvent>{
	
	private Stage window;
	private BorderPane container;
	private Scene registrationScene;
	private ColorTheme theme;
	private Button goBackButton;
	
	private boolean aiMode;
	
	private TextField player1Input, player2Input;
	private String mode;
	
	public Registration(Stage window, ColorTheme theme, boolean aiMode, String mode) {
		
		//Instantiating
		this.window = window;
		this.theme = theme;
		this.aiMode = aiMode;
		this.mode = mode;
		
		this.container = new BorderPane();
		
		//Designing
		this.container.setStyle(this.theme.getButtonsTheme());
		
		displayFirstLayer(); //Displays the top layer components
		displaySecondLayer(); //Displays the center layer component
		displayThirdLayer(); //Displays the bottom layer component
		
		registrationScene = new Scene(container);
		
		String css = this.getClass().getResource("application.css").toExternalForm();
		this.registrationScene.getStylesheets().add(css);
		
	}
	
	/**
	 * A method to sets the top layer components
	 */
	public void displayFirstLayer() {
		
		//Initializing 
		HBox buttonContainer = new HBox();
		this.goBackButton = new Button("Go Back");
		
		//SetID
		this.goBackButton.setId("goBack");
		
		//Designing
		this.goBackButton.setStyle(this.theme.getButtonsTheme());
		buttonContainer.setStyle(this.theme.getcurrentTheme());
		
		//Positioning
		buttonContainer.setPadding(new Insets(10, 10, 10, 10));
		
		//Set Button Action
		this.goBackButton.setOnAction(e -> returnMainMenu());
		
		//Sizing
		buttonContainer.setSpacing(80);
		this.goBackButton.setPrefHeight(40);
		this.goBackButton.setPrefWidth(170);
		
		//Assigning Children Components
		buttonContainer.getChildren().add(this.goBackButton);
		
		this.container.setTop(buttonContainer);
		
		
	}
	
	/**
	 * A method to sets the center layer components
	 */
	public void displaySecondLayer() {
		
		//Instantiating
		VBox inputsContainer = new VBox();
		
		player1Input = new TextField();
		player2Input = new TextField();
		
		//Set Prompt
		player1Input.setPromptText("Enter Player 1 Name");
		player2Input.setPromptText("Enter Player 2 Name");
		
		Label label = new Label("Registration");
		if(aiMode) {
			player2Input.setText("Computer");
		}
		
		//Set ID
		label.setId("title"); //Set ID
		
		//Designing
		player1Input.setStyle(this.theme.getButtonsTheme());
		player2Input.setStyle(this.theme.getButtonsTheme());
		
		//Sizing
		inputsContainer.setMaxSize(500, 300);
		player1Input.setPrefSize(50, 50);
		player2Input.setPrefSize(50, 50);
		
		
		//Positioning
		inputsContainer.setSpacing(20);
		inputsContainer.setAlignment(Pos.TOP_CENTER);
		
		//Assigning children Components
		inputsContainer.getChildren().addAll(label, player1Input, player2Input);
		//mainContainer.setCenter(inputsContainer);
		
		this.container.setCenter(inputsContainer);
		
	}
	
	
	/**
	 * A method to sets the bottom layer components
	 */
	public void displayThirdLayer() {
		
		//Instantiating
		BorderPane thirdLayer= new BorderPane(); //Holds the components in the bottom window
		
		Button playGame = new Button("BEGIN");
		
		//Set Button on Action
		playGame.setOnAction(this);
		
		//Set ID
		playGame.setId("exitButton");
		
		//Designing
		playGame.setStyle(this.theme.getButtonsTheme());
		playGame.setPrefHeight(55);
		playGame.setPrefWidth(185);
		
		//Positioning
		thirdLayer.setPadding(new Insets(10, 10, 10, 10));
		
		thirdLayer.setCenter(playGame);
		
		this.container.setBottom(thirdLayer);
		
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		String name1 = player1Input.getText();
		String name2 = player2Input.getText();
		
		//System.out.println("Name : " + name1);
		//System.out.println("Name : " + name2);
		
		//Check if AI MODE
		if(this.aiMode) {
			
			if(this.mode.equals("3x3")) {
				this.window.setScene(new _3x3_(this.window, this.theme, new Player(name1), new Player(name2), this.aiMode).getScene());
			}
			
			else if(this.mode.equals("4x4")) {
				this.window.setScene(new _4x4_(this.window, this.theme, new Player(name1), new Player(name2), this.aiMode).getScene());
			}
			
			else {
				this.window.setScene(new _5x5_(this.window, this.theme, new Player(name1), new Player(name2), this.aiMode).getScene());
			}
			
		}
		
		else {
			
			if(this.mode.equals("3x3")) {
				this.window.setScene(new _3x3_(this.window, this.theme, new Player(name1), new Player(name2), this.aiMode).getScene());
			}
			
			else if(this.mode.equals("4x4")) {
				this.window.setScene(new _4x4_(this.window, this.theme, new Player(name1), new Player(name2), this.aiMode).getScene());
			}
			
			else {
				this.window.setScene(new _5x5_(this.window, this.theme, new Player(name1), new Player(name2), this.aiMode).getScene());
			}
			
		}
		
		
	}
	
	/**
	 * A method that returns to the Main Menu
	 */
	public void returnMainMenu() {
		
		this.window.setScene(new MainMenu(this.window, this.theme).getScene());
		
	}
	
	
	/**
	 * A method to get the Scene
	 * @return
	 */
	public Scene getScene() {
		return this.registrationScene;
	}
	
}
