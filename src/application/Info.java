package application;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class displays the a Stage and a Scene displaying the Info/Rules
 * @author dell
 *
 */

public class Info {

	private Stage window;
	private BorderPane mainContainer;
	private VBox gameTypeTextContainer, rulesContainer, textsContainer;
	private Label topLabel , label1, label2, label3, label4, label5;
	
	public void display(String title, ColorTheme theme, int gameType) {
		
		this.window = new Stage();
		
		this.window.initModality(Modality.APPLICATION_MODAL);
		this.window.setTitle(title);
		this.window.setWidth(580);
		this.window.setHeight(460);
		
		//Create Main Container
		mainContainer = new BorderPane();
		
		//Close Button
		VBox buttonContainer = new VBox();
		Button closeButton = new Button("Close");
		
		//Assigning Children Close Button & buttonContainer
		buttonContainer.getChildren().add(closeButton);
		mainContainer.setBottom(buttonContainer);
		
		//Designing
		mainContainer.setStyle(theme.getcurrentTheme());
		
		/**
		 *  GameType 
		 *  3 = Displays the rules of 3x3
		 *  4 = Displays the rules of 4x4
		 *  5 = Displays the rules of 5x5
		 *  
		 */
		if(gameType == 3) {
			//Display 3x3 Rules
			display_3x3_Rule();
			
		}
		
		else if(gameType == 4) {
			//Display 4x4 Rules
			display_4x4_Rule();
		}
		else {
			//Display 5x5 Rules
			display_5x5_Rule();
		}
		
		//Button Assigning
		closeButton.setOnAction(e -> window.close());
		
		//SetID
		closeButton.setId("exitButton");
		
		//Designing Button
		closeButton.setStyle(theme.getButtonsTheme());
		closeButton.prefHeight(40);
		closeButton.prefWidth(170);
		
		//Positioning
		buttonContainer.setPadding(new Insets(10, 10, 10, 10));
		buttonContainer.setAlignment(Pos.CENTER);
		gameTypeTextContainer.setSpacing(15);
		
		Scene infoScene = new Scene(mainContainer);
		String css = this.getClass().getResource("application.css").toExternalForm();
		infoScene.getStylesheets().add(css);
		
		/**
		 * Adding Stage icon
		 */
		File iconFile = new File("Images/logo.png");
		Image icon = new Image("file:" + iconFile.getPath());
		this.window.getIcons().add(icon);
		
		this.window.setScene(infoScene);
		this.window.showAndWait();
		
	}
	
	/**
	 * Displays the Rules of 3x3 Tic Tac Toe Game
	 */
	public void display_3x3_Rule() {
		
		//Instantiating
		rulesContainer = new VBox();
		gameTypeTextContainer = new VBox();
		textsContainer = new VBox();
		
		topLabel = new Label("3 X 3  Rules");
		label1 = new Label("[1] The game is played on a 3x3 grid.");
		label2 = new Label("[2] Players take turns placing their symbol (X or O) on an\n     empty space on the grid.");
		label3 = new Label("[3] The first player to get three of their symbol in a row\n      (horizontally, vertically, or diagonally) wins the game.");
		label4 = new Label("[4] If all spaces on the grid are filled and no player has three in a\n     row, the game is a tie.");
		label5 = new Label("[5] Players are not allowed to place their symbol on a space that\n     has already been filled.");
		
		//Set ID
		topLabel.setId("gameTypeRule");
		label1.setId("rulesText");
		label2.setId("rulesText");
		label3.setId("rulesText");
		label4.setId("rulesText");
		label5.setId("rulesText");
		
		//Positioning
		rulesContainer.setAlignment(Pos.CENTER);
		gameTypeTextContainer.setAlignment(Pos.CENTER);
		rulesContainer.setPadding(new Insets(10, 10, 10, 10));
		textsContainer.setSpacing(15);
		textsContainer.setPadding(new Insets(10, 10, 10, 10));
		
		//Assigning
		textsContainer.getChildren().addAll(label1, label2, label3, label4, label5);
		rulesContainer.getChildren().addAll(topLabel, textsContainer);
		
		mainContainer.setTop(rulesContainer);
		mainContainer.setCenter(gameTypeTextContainer);
		
	}
	
	/**
	 * Displays the Rules of 4x4 Tic Tac Toe Game
	 */
	public void display_4x4_Rule() {
		
		//Instantiating
		rulesContainer = new VBox();
		gameTypeTextContainer = new VBox();
		textsContainer = new VBox();
		
		topLabel = new Label("4 X 4  Rules");
		label1 = new Label("[1] The game is played on a 4x4 grid.");
		label2 = new Label("[2] Players take turns placing their symbol (X or O) on an\n     empty space on the grid.");
		label3 = new Label("[3] The first player to get three of their symbol in a row\n      (horizontally, vertically, or diagonally) wins the game.");
		label4 = new Label("[4] If all spaces on the grid are filled and no player has three in a\n     row, the game is a tie.");
		label5 = new Label("[5] Players are not allowed to place their symbol on a space that\n     has already been filled.");
		
		//Set ID
		topLabel.setId("gameTypeRule");
		label1.setId("rulesText");
		label2.setId("rulesText");
		label3.setId("rulesText");
		label4.setId("rulesText");
		label5.setId("rulesText");
		
		//Positioning
		rulesContainer.setAlignment(Pos.CENTER);
		gameTypeTextContainer.setAlignment(Pos.CENTER);
		rulesContainer.setPadding(new Insets(10, 10, 10, 10));
		textsContainer.setSpacing(15);
		textsContainer.setPadding(new Insets(10, 10, 10, 10));
		
		//Assigning
		textsContainer.getChildren().addAll(label1, label2, label3, label4, label5);
		rulesContainer.getChildren().addAll(topLabel, textsContainer);
		
		mainContainer.setTop(rulesContainer);
		mainContainer.setCenter(gameTypeTextContainer);

	}

	/**
	 * Displays the Rules of 5x5 Tic Tac Toe Game
	 */
	public void display_5x5_Rule() {
		
		//Instantiating
		rulesContainer = new VBox();
		gameTypeTextContainer = new VBox();
		textsContainer = new VBox();
		
		topLabel = new Label("5 X 5  Rules");
		label1 = new Label("[1] The game is played on a 5x5 grid.");
		label2 = new Label("[2] Players take turns placing their symbol (X or O) on an\n     empty space on the grid.");
		label3 = new Label("[3] The first player to get four of their symbol in a row\n       (horizontally, vertically, or diagonally) wins the game.");
		label4 = new Label("[4] If all spaces on the grid are filled and no player has four in a\n      row, the game is a tie.");
		label5 = new Label("[5] Players are not allowed to place their symbol on a space that\n     has already been filled.");
		
		//Set ID
		topLabel.setId("gameTypeRule");
		label1.setId("rulesText");
		label2.setId("rulesText");
		label3.setId("rulesText");
		label4.setId("rulesText");
		label5.setId("rulesText");
		
		//Positioning
		rulesContainer.setAlignment(Pos.CENTER);
		gameTypeTextContainer.setAlignment(Pos.CENTER);
		rulesContainer.setPadding(new Insets(10, 10, 10, 10));
		textsContainer.setSpacing(15);
		textsContainer.setPadding(new Insets(10, 10, 10, 10));
		
		//Assigning
		textsContainer.getChildren().addAll(label1, label2, label3, label4, label5);
		rulesContainer.getChildren().addAll(topLabel, textsContainer);
		
		mainContainer.setTop(rulesContainer);
		mainContainer.setCenter(gameTypeTextContainer);
		
	}
	
}
