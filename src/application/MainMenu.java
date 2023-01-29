package application;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import player.Player;

/**
 * This class would handle the graphical user interface (GUI) and display the Tic-Tac-Toe board to the user.
 *
 */
public class MainMenu implements EventHandler<ActionEvent>{
	
	private Stage window;
	private Scene mainMenu;
	private ColorTheme theme;
	private Button changeTheme, playerComputerButton, playerPlayerButton, _3x3Button, _4x4Button, _5x5Button, exit;
	private BorderPane container;
	//private Music music;

	
	private String boardSelected; //Board Selection
	
	/**
	 * A method that displays the Main Menu of the Game
	 * @param stage
	 * @param theme
	 */
	public MainMenu(Stage stage, ColorTheme theme) {
		
		/**
		 * Play music
		 */
		
		/**
		 * Memory Reference
		 */
		this.window = stage;
		this.theme = theme;
		
		this.container = new BorderPane(); //Adding frame
		
		this.container.setStyle(this.theme.getcurrentTheme()); //Default Color Theme
		
		this.setFirstLayer();  //Sets First Layer
		this.setSecondLayer(); //Sets Second Layer
		this.setThirdLayer();  //Sets the Third Layer
		
		//container.getChildren().add(changeTheme);
		
		this.mainMenu = new Scene(container, 880, 660);
		String css = this.getClass().getResource("application.css").toExternalForm();
		this.mainMenu.getStylesheets().add(css);
		
	}
	 
	/**
	 * This sets the first layer in the main menu
	 * Sets the Change Theme Button
	 * Sets the Full screen button
	 */
	public void setFirstLayer() {
		
		BorderPane firstLayer = new BorderPane();
		
		this.changeTheme = new Button(this.theme.getThemeName().toUpperCase());
		
		//Set ID
		this.changeTheme.setId("changeTheme");
		
		//Designing
		this.changeTheme.setStyle(this.theme.getButtonsTheme());
		
		//Positioning
		firstLayer.setPadding(new Insets(10, 10, 10, 10));
		
		//Sizing
		this.changeTheme.setPrefHeight(40);
		this.changeTheme.setPrefWidth(170);
		
		//Set ActionEvents
		this.changeTheme.setOnMousePressed(e -> nextTheme());
		
		//Assigning Child Components
		firstLayer.setLeft(this.changeTheme);
		
		//this.container.setTop(firstLayer); //Set it to top
		//this.container.getChildren().add(firstLayer);
		this.container.setTop(firstLayer);
		
	}
	
	
	/**
	 * This sets the second layer in the main menu
	 * Sets the Title
	 * Sets the Play Game Option
	 * Sets the Board Selection
	 */
	public void setSecondLayer() {
		
		//Initializing
		BorderPane mainContainer = new BorderPane();
		VBox midContainer = new VBox();
		VBox buttonContainer = new VBox();
		HBox boardSelectorContainer = new HBox();
		
		Label title = new Label("Tic Tac Toe");
		title.setId("title"); //Set ID
		
		this.playerComputerButton = new Button("Player vs Computer");
		this.playerPlayerButton = new Button("Player vs Player");
		
		/**
		 * Board Selector
		 */
		this._3x3Button = new Button("3 x 3");
		this._4x4Button = new Button("4 x 4");
		this._5x5Button = new Button("5 x 5");
		
		//Set ID
		this.playerComputerButton.setId("playerComputerButton");
		this.playerPlayerButton.setId("playerPlayerButton");
		this._3x3Button.setId("boardOption");
		this._4x4Button.setId("boardOption");
		this._5x5Button.setId("boardOption");
		
		//Set Button on Action
		this._3x3Button.setOnAction(this);
		this._4x4Button.setOnAction(this);
		this._5x5Button.setOnAction(this);
		this.playerPlayerButton.setOnAction(this);
		this.playerComputerButton.setOnAction(this);
		
		//Designing
		this.playerPlayerButton.setStyle(this.theme.getButtonsTheme());
		this.playerComputerButton.setStyle(this.theme.getButtonsTheme());
		this._3x3Button.setStyle(this.theme.getButtonsTheme());
		this._4x4Button.setStyle(this.theme.getButtonsTheme());
		this._5x5Button.setStyle(this.theme.getButtonsTheme());
		this.playerComputerButton.setDisable(true); //Disable Button
		this.playerPlayerButton.setDisable(true); //Disable Button
		
		//Positioning
		mainContainer.setTranslateY(40);
		buttonContainer.setTranslateY(30);
		buttonContainer.setSpacing(20);
		boardSelectorContainer.setSpacing(10);
		
		//Sizing
		this.playerPlayerButton.setPrefHeight(70);
		this.playerPlayerButton.setPrefWidth(275);
		this.playerComputerButton.setPrefHeight(70);
		this.playerComputerButton.setPrefWidth(275);
		this._3x3Button.setPrefHeight(70);
		this._3x3Button.setPrefWidth(83.3);
		this._4x4Button.setPrefHeight(70);
		this._4x4Button.setPrefWidth(83.3);
		this._5x5Button.setPrefHeight(70);
		this._5x5Button.setPrefWidth(83.3);
		
		//Assigning Positions
		midContainer.getChildren().addAll(title, buttonContainer);
		midContainer.setAlignment(Pos.CENTER);
		buttonContainer.getChildren().addAll(playerComputerButton, playerPlayerButton, boardSelectorContainer);
		boardSelectorContainer.getChildren().addAll(_3x3Button, _4x4Button, _5x5Button);
		boardSelectorContainer.setAlignment(Pos.CENTER);
		buttonContainer.setAlignment(Pos.CENTER);
		mainContainer.setTop(midContainer);
		
		//this.container.setCenter(mainContainer);
		//this.container.getChildren().add(mainContainer);
		this.container.setCenter(mainContainer);
		
	}
	
	/**
	 * This sets the Third Layer in the Main Menu
	 * Sets the Exit Button
	 * Sets the Music Player
	 * Sets the Music On/Off Option
	 * Sets the Sound Effects On/Off Option
	 */
	public void setThirdLayer() {
		
		//Instantiating
		BorderPane thirdLayer= new BorderPane(); //Holds the components in the bottom window
		
		this.exit = new Button("E X I T");
		
		//Set Button on Action
		this.exit.setOnAction(e -> new Exit().display("Tic Tac Toe", this.theme));
		
		//Set ID
		this.exit.setId("exitButton");
		
		//Designing
		this.exit.setStyle(this.theme.getButtonsTheme());
		this.exit.setPrefHeight(40);
		this.exit.setPrefWidth(170);
		
		//Positioning
		thirdLayer.setPadding(new Insets(10, 10, 10, 10));

		thirdLayer.setLeft(this.exit);
		
		this.container.setBottom(thirdLayer);
		
	}
	
	/**
	 * A method for switching theme during Button Clicking
	 */
	public void nextTheme() {
		
		this.container.setStyle(this.theme.getBackgroundTheme());
		
		//Change button colors
		this.playerPlayerButton.setStyle(this.theme.getButtonsTheme());
		this.playerComputerButton.setStyle(this.theme.getButtonsTheme());
		
		//Change the color of the button
		this.changeTheme.setStyle(this.theme.getButtonsTheme());
		this.changeTheme.setText(this.theme.getThemeName().toUpperCase());
		this._3x3Button.setStyle(this.theme.getButtonsTheme());
		this._4x4Button.setStyle(this.theme.getButtonsTheme());
		this._5x5Button.setStyle(this.theme.getButtonsTheme());
		this.exit.setStyle(this.theme.getButtonsTheme());
		
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
		//Board Selected If Condition
		if(event.getSource() == this._3x3Button) {
			this.boardSelected = "3x3";
			this._3x3Button.setDisable(true);
			this._4x4Button.setDisable(false);
			this._5x5Button.setDisable(false);
			this.playerComputerButton.setDisable(false);
			this.playerPlayerButton.setDisable(false);
		}
		if(event.getSource() == this._4x4Button) {
			this.boardSelected = "4x4";
			this._3x3Button.setDisable(false);
			this._4x4Button.setDisable(true);
			this._5x5Button.setDisable(false);
			this.playerComputerButton.setDisable(false);
			this.playerPlayerButton.setDisable(false);
		}
		if(event.getSource() == this._5x5Button) {
			this.boardSelected = "5x5";
			this._3x3Button.setDisable(false);
			this._4x4Button.setDisable(false);
			this._5x5Button.setDisable(true);
			this.playerComputerButton.setDisable(false);
			this.playerPlayerButton.setDisable(false);
		}
		
		//Play Multiplayer Game Type
		if(event.getSource() == this.playerPlayerButton && this.boardSelected != null) {
			
			Player.resetGameCount(); //Reset game count to 0
			this.window.setScene(new Registration(this.window, this.theme, false, this.boardSelected).getScene());
			
		}
		
		
		//Play Computer
		if(event.getSource() == this.playerComputerButton && this.boardSelected != null) {
			
			Player.resetGameCount(); //Reset game count to 0
			this.window.setScene(new Registration(this.window, this.theme, true, this.boardSelected).getScene());
			
		}
		
		//Play Computer
		/*
		if(event.getSource() == this.playerComputerButton && this.boardSelected != null) {
			
			Player player1 = new Player("Hans");
			Player player2 = new Player("Computer");
			Player.resetGameCount(); //Reset Game into 0
			
			if(this.boardSelected.equals("3x3")) {
				this.window.setScene(new _3x3_(this.window, this.theme, player1, player2, true).getScene());
				
				
			}
			
			if(this.boardSelected.equals("4x4")) {
				this.window.setScene(new _4x4_(this.window, this.theme, player1, player2 ,true).getScene());
			}
			
			if(this.boardSelected.equals("5x5")) {
				this.window.setScene(new _5x5_(this.window, this.theme, player1, player2 ,true).getScene());
			}
			
		}
		*/
		
	}
	
	/**
	 * Returns the Scene to the Model
	 * @return
	 */
	public Scene getScene() {
		return this.mainMenu;
	}
	
}
