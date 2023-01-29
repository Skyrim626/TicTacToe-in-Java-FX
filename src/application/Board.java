package application;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import player.Player;

public abstract class Board {
	
	protected Stage window;
	protected Scene scene;
	protected ColorTheme theme;
	protected BorderPane board;
	
	protected Label playerScore1, playerName1;
	protected Label playerScore2, playerName2;
	protected Label gameCount;
	
	protected Player p1, p2;
	protected boolean aiMode;
	protected Button infoButton;
	
	protected int gameType;
	
	public Board(Stage window, ColorTheme theme, Player p1, Player p2, boolean aiMode, int gameType) {
		
		this.window = window;
		this.theme = theme;
		this.p1 = p1;
		this.p2 = p2;
		this.gameType = gameType;
		
		this.board = new BorderPane();
		
		//Designing
		this.board.setStyle(this.theme.getcurrentTheme());
		
		this.displayTopLayer(); //Displays the top layer
		this.displayLeftLayer(); //Displays the left layer
		this.displayRightLayer(); //Displays the right layer
		// this.displayCenterLayer(); //Displays the center layer
		//this.displayBottomLayer(); //Displays the bottom layer
		
		this.scene = new Scene(this.board);
		String css = this.getClass().getResource("application.css").toExternalForm();
		this.scene.getStylesheets().add(css);
		
	}
	
	/**
	 * A method that displays the Top Layer's Components
	 */
	public void displayTopLayer() {
		
		/**
		 * Instantiating
		 */
		HBox container = new HBox();
		Button goBack = new Button("Go Back");
		Label timerLabel = new Label("00:00");
		gameCount = new Label("Game : " + Player.getGameCount());
		//gameCount = new Label("Game : 100");
		this.infoButton = new Button("Rules");
		
		//SetID
		this.infoButton.setId("changeTheme");
		timerLabel.setId("timerLabel");
		goBack.setId("goBack");
		gameCount.setId("gameCount");
		
		//Designing
		container.setStyle(this.theme.getcurrentTheme());
		goBack.setStyle(this.theme.getButtonsTheme());
		this.infoButton.setStyle(this.theme.getButtonsTheme());
		
		//Positioning
		container.setPadding(new Insets(10, 10, 10, 10));
		
		//Set Button Action
		goBack.setOnAction(e -> returnMainMenu()); //Returns to Main Menu
		this.infoButton.setOnAction(e -> new Info().display("Tic Tac Toe", this.theme, this.gameType));
		
		//Sizing
		container.setAlignment(Pos.CENTER_LEFT);
		container.setSpacing(120);
		goBack.setPrefHeight(40);
		goBack.setPrefWidth(170);
		this.infoButton.setPrefHeight(40);
		this.infoButton.setPrefWidth(130);
		
		//Assigning
		container.getChildren().addAll(goBack, timerLabel, gameCount, this.infoButton);
		
		this.board.setTop(container);
		
	}
	
	/**
	 * A method that displays the Left Layer's Components
	 */
	public void displayLeftLayer() {
		
		//Initializing
		VBox container = new VBox();
		Button playerLogo1 = new Button();
		
		playerName1 = new Label(this.p1.getName());
		playerScore1 = new Label(this.p1.getScore());
		
		/*	
		 * Player Image
		 *Button Images
		*/
		
		Image player1_GetImage = new Image("file:" + new File("Images/red.png").getPath());
		ImageView player1_DisplayImage = new ImageView(player1_GetImage);
		
		//Designing
		playerLogo1.setGraphic(player1_DisplayImage);
		playerLogo1.setBackground(null);
		
		//SetID
		playerName1.setId("playerName");
		playerScore1.setId("playerScore");
		
		//Positioning
		container.setAlignment(Pos.CENTER);
		container.setSpacing(20);
		container.setPadding(new Insets(10, 10, 10, 50));
		
		//Sizing
		playerLogo1.setPrefHeight(90);
		playerLogo1.setPrefWidth(90);
		player1_DisplayImage.setFitHeight(playerLogo1.getPrefHeight());
		player1_DisplayImage.setFitWidth(playerLogo1.getPrefWidth());
		
		
		//Assigning
		container.getChildren().addAll(playerLogo1, playerName1, playerScore1);
		
		this.board.setLeft(container);
		
	}	


	/**
	 * A method that displays the Right Layer's Components
	 */
	public void displayRightLayer() {
		
		//Initializing
		VBox container = new VBox();
		Button playerLogo2 = new Button();
				
		playerName2 = new Label(this.p2.getName());
		playerScore2 = new Label(this.p2.getScore());
		
		/*	
		 * Player Image
		 *Button Images
		*/
		Image player2_GetImage = new Image("file:" + new File("Images/blue.png").getPath());
		ImageView player2_DisplayImage = new ImageView(player2_GetImage);
				
		//Designing
		playerLogo2.setGraphic(player2_DisplayImage);
		playerLogo2.setBackground(null);
		
		//SetID
		playerName2.setId("playerName");
		playerScore2.setId("playerScore");
				
		//Positioning
		container.setAlignment(Pos.CENTER);
		container.setSpacing(20);
		container.setPadding(new Insets(10, 50, 10, 10));
		
		//Sizing
		playerLogo2.setPrefHeight(90);
		playerLogo2.setPrefWidth(90);
		player2_DisplayImage.setFitHeight(playerLogo2.getPrefHeight());
		player2_DisplayImage.setFitWidth(playerLogo2.getPrefWidth());
				
		//Assigning
		container.getChildren().addAll(playerLogo2, playerName2, playerScore2);
				
		this.board.setRight(container);
		
	}

	/**
	 * A method that returns to the Main Menu
	 */
	public void returnMainMenu() {
		
		this.window.setScene(new MainMenu(this.window, this.theme).getScene());
		
	}
	
	
	/**
	 * A getter method to get the Scene of this Board
	 * @return
	 */
	public Scene getScene() {
		return this.scene;
	}
	
	/**
	 * A method that displays the Center Layer's Components
	 */
	protected abstract void displayCenterLayer();
	
	/**
	 * A method for who' turn first
	 */
	protected abstract void firstTurn();
	
	/**
	 * A method to check if there is a winning condition
	 */
	protected abstract void check();
	
	/**
	 * A method to be for Player's next turn
	 */
	protected abstract String nextTurn();
	

}
