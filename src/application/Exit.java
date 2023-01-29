package application;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * A class for Displaying Exit window option
 * @author dell
 *
 */
public class Exit {
	
	/**
	 * A method to displays the Exit Window Option
	 */
	public void display(String title, ColorTheme theme) {
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setWidth(480);
		window.setHeight(160);
		
		//Initializing Components
		Label exitText = new Label("Are you sure you want to exit?");
		Button noButton = new Button("No");
		Button yesButton = new Button ("Yes");
		
		VBox container = new VBox();
		HBox buttonContainer = new HBox();
		
		//Set Button Action
		noButton.setOnAction(e -> window.close());
		yesButton.setOnAction(e -> System.exit(0));
		
		//Set ID
		noButton.setId("changeTheme");
		yesButton.setId("changeTheme");
		exitText.setId("exitText");
		
		//Sizing
		noButton.setPrefHeight(40);
		noButton.setPrefWidth(170);
		yesButton.setPrefHeight(40);
		yesButton.setPrefWidth(170);
		
		//Designing
		container.setStyle(theme.getcurrentTheme());
		noButton.setStyle(theme.getButtonsTheme());
		yesButton.setStyle(theme.getButtonsTheme());
		
		//Positioning
		container.setAlignment(Pos.CENTER);
		container.setSpacing(10);
		buttonContainer.setAlignment(Pos.CENTER);
		buttonContainer.setSpacing(15);
		
		//Assigning Children
		buttonContainer.getChildren().addAll(noButton, yesButton);
		container.getChildren().addAll(exitText, buttonContainer);
		
		Scene exitScene = new Scene(container);
		
		String css = this.getClass().getResource("application.css").toExternalForm();
		exitScene.getStylesheets().add(css);
		
		
		/**
		 * Adding Stage icon
		 */
		File iconFile = new File("Images/logo.png");
		Image icon = new Image("file:" + iconFile.getPath());
		window.getIcons().add(icon);
		
		window.setScene(exitScene);
		window.showAndWait();
		
		
		
	}
	
}
