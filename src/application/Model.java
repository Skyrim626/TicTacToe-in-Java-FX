

package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * This is the main class for executing the Tic Tac Toe Game
 * @author dell
 *
 */
public class Model extends Application {
	
	private Stage window;
	private Scene mainMenu;
	private ColorTheme theme = new ColorTheme();
	private MainMenu menu;
	
	public static void main(String[] args) {
		
		/**
		 * Play Background Music
		 */
		Music music = new Music();
		music.playCurrentMusic();
		
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		this.window = primaryStage; //Set the stage
		this.window.setTitle("Tic Tac Toe"); //Title
		
		/**
		 * Setting the width and height of the Stage
		 */
		this.window.setWidth(880);
		this.window.setHeight(660);
		
		/**
		 * Adding Stage icon
		 */
		File iconFile = new File("Images/logo.png");
		Image icon = new Image("file:" + iconFile.getPath());
		this.window.getIcons().add(icon);
		
		
		/**
		 * Scene
		 */
		//Scene 1
		this.menu = new MainMenu(window, theme); //Sets Up the Main Menu Scene
		
		this.mainMenu = menu.getScene(); //Gets the Scene
		
		this.window.setResizable(false);
		this.window.show();
		this.window.setScene(mainMenu);
		this.window.centerOnScreen();
		
	}
	
}
