package application;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import player.Player;

public class _5x5_ extends Board implements EventHandler<ActionEvent> {

	private Button[][] buttons;
	private Random turn = new Random();
	private boolean player1_turn;
	
	private Label whosTurn = new Label("");
	private Player p1;
	private Player p2;
	
	public _5x5_(Stage window, ColorTheme theme, Player p1, Player p2, boolean aiMode) {
		super(window, theme, p1, p2, aiMode, 5);
		super.aiMode = aiMode;
		
		//Display Grid
		this.displayCenterLayer();
		
		//LET THE GAME BEGIN
		this.p1 = p1;
		this.p2 = p2;
		firstTurn();
		AI_firstMove();
		
	}

	@Override
	protected void displayCenterLayer() {

		//Initializing & Designing
		
		VBox container = new VBox();
		
		//Set ID
		whosTurn.setId("whosTurn");
		
		GridPane gridPane = new GridPane();
		buttons = new Button[5][5];
		for(int row = 0; row < 5; row++) {
			
			for(int column = 0; column < 5; column++) {
				buttons[row][column] = new Button("");
				buttons[row][column].setMinSize(85, 85);
				buttons[row][column].setPrefSize(85, 85);
				buttons[row][column].setMaxSize(85, 85);
				buttons[row][column].setFont(Font.font(20));
				buttons[row][column].setOnAction(this);
				buttons[row][column].setStyle(this.theme.getButtonsTheme());
				
				//Set ID
				buttons[row][column].setId("By5x5Grid");
				
				gridPane.add(buttons[row][column], column, row);
			}
			
		}
		
		container.setAlignment(Pos.CENTER);
		container.setSpacing(15);
		container.getChildren().addAll(whosTurn, gridPane);
		gridPane.setAlignment(Pos.CENTER);
		super.board.setCenter(container);
		
	}

	@Override
	protected void firstTurn() {
		// TODO Auto-generated method stub

		if(turn.nextInt(2) == 0) {
			this.player1_turn = true;
			whosTurn.setText(this.p1.getName() + " turn");
		}
		else {
			this.player1_turn = false;
			whosTurn.setText(this.p2.getName() + " turn");
		}
		
	}
	
	@Override
	protected String nextTurn() {
		return this.player1_turn ? this.p1.getName() : this.p2.getName();
	}

	@Override
	protected void check() {
		// TODO Auto-generated method stub

		//Player One Checking Condition
		/**
		 * Check Column Match Condition
		 */
		if(
			(buttons[0][0].getText().equals("X")) &&
			(buttons[0][1].getText().equals("X")) &&
			(buttons[0][2].getText().equals("X")) &&
			(buttons[0][3].getText().equals("X")) 
		  ) {
			
			playerOneWins(0, 1, 2, 3,  new int[] {0,0,0,0});
			
		}
		if(
			(buttons[0][1].getText().equals("X")) &&
			(buttons[0][2].getText().equals("X")) &&
			(buttons[0][3].getText().equals("X")) &&
			(buttons[0][4].getText().equals("X")) 
		  ) {
			
			playerOneWins(1, 2, 3, 4,  new int[] {0,0,0,0});
			
		}
		if(
			(buttons[1][0].getText().equals("X")) &&
			(buttons[1][1].getText().equals("X")) &&
			(buttons[1][2].getText().equals("X")) &&
			(buttons[1][3].getText().equals("X")) 
		  ) {
			
			playerOneWins(0, 1, 2, 3,  new int[] {1,1,1,1});
			
		}
		if(
			(buttons[1][1].getText().equals("X")) &&
			(buttons[1][2].getText().equals("X")) &&
			(buttons[1][3].getText().equals("X")) &&
			(buttons[1][4].getText().equals("X")) 
		  ) {
			
			playerOneWins(1, 2, 3, 4,  new int[] {1,1,1,1});
			
		}
		if(
			(buttons[2][0].getText().equals("X")) &&
			(buttons[2][1].getText().equals("X")) &&
			(buttons[2][2].getText().equals("X")) &&
			(buttons[2][3].getText().equals("X")) 
		  ) {
			
			playerOneWins(0, 1, 2, 3,  new int[] {2,2,2,2});
			
		}
		if(
			(buttons[2][1].getText().equals("X")) &&
			(buttons[2][2].getText().equals("X")) &&
			(buttons[2][3].getText().equals("X")) &&
			(buttons[2][4].getText().equals("X")) 
		  ) {
			
			playerOneWins(1, 2, 3, 4,  new int[] {2,2,2,2});
			
		}
		if(
			(buttons[3][0].getText().equals("X")) &&
			(buttons[3][1].getText().equals("X")) &&
			(buttons[3][2].getText().equals("X")) &&
			(buttons[3][3].getText().equals("X")) 
		  ) {
			
			playerOneWins(0, 1, 2, 3,  new int[] {3,3,3,3});
			
		}
		if(
			(buttons[3][1].getText().equals("X")) &&
			(buttons[3][2].getText().equals("X")) &&
			(buttons[3][3].getText().equals("X")) &&
			(buttons[3][4].getText().equals("X")) 
		  ) {
			
			playerOneWins(1, 2, 3, 4,  new int[] {3,3,3,3});
			
		}
		if(
			(buttons[4][0].getText().equals("X")) &&
			(buttons[4][1].getText().equals("X")) &&
			(buttons[4][2].getText().equals("X")) &&
			(buttons[4][3].getText().equals("X")) 
		  ) {
			
			playerOneWins(0, 1, 2, 3,  new int[] {4,4,4,4});
			
		}
		if(
			(buttons[4][1].getText().equals("X")) &&
			(buttons[4][2].getText().equals("X")) &&
			(buttons[4][3].getText().equals("X")) &&
			(buttons[4][4].getText().equals("X")) 
		  ) {
			
			playerOneWins(1, 2, 3, 4,  new int[] {4,4,4,4});
			
		}
	
		/**
		 * Player One Checking Condition
		 * Checking Row winning combinations
		 */
		if(
			(buttons[0][0].getText().equals("X")) &&
			(buttons[1][0].getText().equals("X")) &&
			(buttons[2][0].getText().equals("X")) &&
			(buttons[3][0].getText().equals("X")) 
		  ) {
			
			playerOneWins(0, 0, 0, 0,  new int[] {0,1,2,3});
			
		}
		
		if(
			(buttons[1][0].getText().equals("X")) &&
			(buttons[2][0].getText().equals("X")) &&
			(buttons[3][0].getText().equals("X")) &&
			(buttons[4][0].getText().equals("X")) 
		  ) {
			
			playerOneWins(0, 0, 0, 0,  new int[] {1,2,3,4});
			
		}
		
		if(
			(buttons[0][1].getText().equals("X")) &&
			(buttons[1][1].getText().equals("X")) &&
			(buttons[2][1].getText().equals("X")) &&
			(buttons[3][1].getText().equals("X")) 
		  ) {
			
			playerOneWins(1, 1, 1, 1,  new int[] {0,1,2,3});
			
		}
		
		
		if(
			(buttons[1][1].getText().equals("X")) &&
			(buttons[2][1].getText().equals("X")) &&
			(buttons[3][1].getText().equals("X")) &&
			(buttons[4][1].getText().equals("X")) 
		  ) {
			
			playerOneWins(1, 1, 1, 1,  new int[] {1,2,3,4});
			
		}
		if(
			(buttons[0][2].getText().equals("X")) &&
			(buttons[1][2].getText().equals("X")) &&
			(buttons[2][2].getText().equals("X")) &&
			(buttons[3][2].getText().equals("X")) 
		  ) {
			
			playerOneWins(2, 2, 2, 2,  new int[] {0,1,2,3});
			
		}
		if(
			(buttons[1][2].getText().equals("X")) &&
			(buttons[2][2].getText().equals("X")) &&
			(buttons[3][2].getText().equals("X")) &&
			(buttons[4][2].getText().equals("X")) 
		  ) {
			
			playerOneWins(2, 2, 2, 2,  new int[] {1,2,3,4});
			
		}
		if(
			(buttons[0][3].getText().equals("X")) &&
			(buttons[1][3].getText().equals("X")) &&
			(buttons[2][3].getText().equals("X")) &&
			(buttons[3][3].getText().equals("X")) 
		  ) {
			
			playerOneWins(3, 3, 3, 3,  new int[] {0,1,2,3});
			
		}
		if(
			(buttons[1][3].getText().equals("X")) &&
			(buttons[2][3].getText().equals("X")) &&
			(buttons[3][3].getText().equals("X")) &&
			(buttons[4][3].getText().equals("X")) 
		  ) {
			
			playerOneWins(3, 3, 3, 3,  new int[] {1,2,3,4});
			
		}
		if(
			(buttons[0][4].getText().equals("X")) &&
			(buttons[1][4].getText().equals("X")) &&
			(buttons[2][4].getText().equals("X")) &&
			(buttons[3][4].getText().equals("X")) 
		  ) {
			
			playerOneWins(4, 4, 4, 4,  new int[] {0,1,2,3});
			
		}
		if(
			(buttons[1][4].getText().equals("X")) &&
			(buttons[2][4].getText().equals("X")) &&
			(buttons[3][4].getText().equals("X")) &&
			(buttons[4][4].getText().equals("X")) 
		  ) {
			
			playerOneWins(4, 4, 4, 4,  new int[] {1,2,3,4});
			
		}
		
		/**
		 * Player One checking condition
		 * Diagonal symbol winning condition
		 */
		if(
			(buttons[1][0].getText().equals("X")) &&
			(buttons[2][1].getText().equals("X")) &&
			(buttons[3][2].getText().equals("X")) &&
			(buttons[4][3].getText().equals("X")) 
		  ) {
			
			playerOneWins(0, 1, 2, 3,  new int[] {1,2,3,4});
			
		}
		if(
			(buttons[0][0].getText().equals("X")) &&
			(buttons[1][1].getText().equals("X")) &&
			(buttons[2][2].getText().equals("X")) &&
			(buttons[3][3].getText().equals("X")) 
		  ) {
			
			playerOneWins(0, 1, 2, 3,  new int[] {0,1,2,3});
			
		}
		if(
			(buttons[1][1].getText().equals("X")) &&
			(buttons[2][2].getText().equals("X")) &&
			(buttons[3][3].getText().equals("X")) &&
			(buttons[4][4].getText().equals("X")) 
		  ) {
			
			playerOneWins(1, 2, 3, 4,  new int[] {1,2,3,4});
			
		}
		if(
			(buttons[0][1].getText().equals("X")) &&
			(buttons[1][2].getText().equals("X")) &&
			(buttons[2][3].getText().equals("X")) &&
			(buttons[3][4].getText().equals("X")) 
		  ) {
			
			playerOneWins(1, 2, 3, 4,  new int[] {0,1,2,3});
			
		}
		if(
			(buttons[1][4].getText().equals("X")) &&
			(buttons[2][3].getText().equals("X")) &&
			(buttons[3][2].getText().equals("X")) &&
			(buttons[4][1].getText().equals("X")) 
		  ) {
			
			playerOneWins(4, 3, 2, 1,  new int[] {1,2,3,4});
			
		}
		if(
			(buttons[0][4].getText().equals("X")) &&
			(buttons[1][3].getText().equals("X")) &&
			(buttons[2][2].getText().equals("X")) &&
			(buttons[3][1].getText().equals("X")) 
		  ) {
			
			playerOneWins(4, 3, 2, 1,  new int[] {0,1,2,3});
			
		}
		if(
			(buttons[1][3].getText().equals("X")) &&
			(buttons[2][2].getText().equals("X")) &&
			(buttons[3][1].getText().equals("X")) &&
			(buttons[4][0].getText().equals("X")) 
		  ) {
			
			playerOneWins(3, 2, 1, 0,  new int[] {1,2,3,4});
			
		}
		if(
			(buttons[0][3].getText().equals("X")) &&
			(buttons[1][2].getText().equals("X")) &&
			(buttons[2][1].getText().equals("X")) &&
			(buttons[3][0].getText().equals("X")) 
		  ) {
			
			playerOneWins(3, 2, 1, 0,  new int[] {0,1,2,3});
			
		}
		
		
		
		//Player Two Checking Condition
		/**
		 * Check Column Match Condition
		 */
		if(
			(buttons[0][0].getText().equals("O")) &&
			(buttons[0][1].getText().equals("O")) &&
			(buttons[0][2].getText().equals("O")) &&
			(buttons[0][3].getText().equals("O")) 
		  ) {
			
			playerTwoWins(0, 1, 2, 3,  new int[] {0,0,0,0});
			
		}
		if(
			(buttons[0][1].getText().equals("O")) &&
			(buttons[0][2].getText().equals("O")) &&
			(buttons[0][3].getText().equals("O")) &&
			(buttons[0][4].getText().equals("O")) 
		  ) {
			
			playerTwoWins(1, 2, 3, 4,  new int[] {0,0,0,0});
			
		}
		if(
			(buttons[1][0].getText().equals("O")) &&
			(buttons[1][1].getText().equals("O")) &&
			(buttons[1][2].getText().equals("O")) &&
			(buttons[1][3].getText().equals("O")) 
		  ) {
			
			playerTwoWins(0, 1, 2, 3,  new int[] {1,1,1,1});
			
		}
		if(
			(buttons[1][1].getText().equals("O")) &&
			(buttons[1][2].getText().equals("O")) &&
			(buttons[1][3].getText().equals("O")) &&
			(buttons[1][4].getText().equals("O")) 
		  ) {
			
			playerTwoWins(1, 2, 3, 4,  new int[] {1,1,1,1});
			
		}
		if(
			(buttons[2][0].getText().equals("O")) &&
			(buttons[2][1].getText().equals("O")) &&
			(buttons[2][2].getText().equals("O")) &&
			(buttons[2][3].getText().equals("O")) 
		  ) {
			
			playerTwoWins(0, 1, 2, 3,  new int[] {2,2,2,2});
			
		}
		if(
			(buttons[2][1].getText().equals("O")) &&
			(buttons[2][2].getText().equals("O")) &&
			(buttons[2][3].getText().equals("O")) &&
			(buttons[2][4].getText().equals("O")) 
		  ) {
			
			playerTwoWins(1, 2, 3, 4,  new int[] {2,2,2,2});
			
		}
		if(
			(buttons[3][0].getText().equals("O")) &&
			(buttons[3][1].getText().equals("O")) &&
			(buttons[3][2].getText().equals("O")) &&
			(buttons[3][3].getText().equals("O")) 
		  ) {
			
			playerTwoWins(0, 1, 2, 3,  new int[] {3,3,3,3});
			
		}
		if(
			(buttons[3][1].getText().equals("O")) &&
			(buttons[3][2].getText().equals("O")) &&
			(buttons[3][3].getText().equals("O")) &&
			(buttons[3][4].getText().equals("O")) 
		  ) {
			
			playerTwoWins(1, 2, 3, 4,  new int[] {3,3,3,3});
			
		}
		if(
			(buttons[4][0].getText().equals("O")) &&
			(buttons[4][1].getText().equals("O")) &&
			(buttons[4][2].getText().equals("O")) &&
			(buttons[4][3].getText().equals("O")) 
		  ) {
			
			playerTwoWins(0, 1, 2, 3,  new int[] {4,4,4,4});
			
		}
		if(
			(buttons[4][1].getText().equals("O")) &&
			(buttons[4][2].getText().equals("O")) &&
			(buttons[4][3].getText().equals("O")) &&
			(buttons[4][4].getText().equals("O")) 
		  ) {
			
			playerTwoWins(1, 2, 3, 4,  new int[] {4,4,4,4});
			
		}
	
		/**
		 * Player Two Checking Condition
		 * Checking Row winning combinations
		 */
		if(
			(buttons[0][0].getText().equals("O")) &&
			(buttons[1][0].getText().equals("O")) &&
			(buttons[2][0].getText().equals("O")) &&
			(buttons[3][0].getText().equals("O")) 
		  ) {
			
			playerTwoWins(0, 0, 0, 0,  new int[] {0,1,2,3});
			
		}
		
		if(
			(buttons[1][0].getText().equals("O")) &&
			(buttons[2][0].getText().equals("O")) &&
			(buttons[3][0].getText().equals("O")) &&
			(buttons[4][0].getText().equals("O")) 
		  ) {
			
			playerTwoWins(0, 0, 0, 0,  new int[] {1,2,3,4});
			
		}
		
		if(
			(buttons[0][1].getText().equals("O")) &&
			(buttons[1][1].getText().equals("O")) &&
			(buttons[2][1].getText().equals("O")) &&
			(buttons[3][1].getText().equals("O")) 
		  ) {
			
			playerTwoWins(1, 1, 1, 1,  new int[] {0,1,2,3});
			
		}
		
		
		if(
			(buttons[1][1].getText().equals("O")) &&
			(buttons[2][1].getText().equals("O")) &&
			(buttons[3][1].getText().equals("O")) &&
			(buttons[4][1].getText().equals("O")) 
		  ) {
			
			playerTwoWins(1, 1, 1, 1,  new int[] {1,2,3,4});
			
		}
		if(
			(buttons[0][2].getText().equals("O")) &&
			(buttons[1][2].getText().equals("O")) &&
			(buttons[2][2].getText().equals("O")) &&
			(buttons[3][2].getText().equals("O")) 
		  ) {
			
			playerTwoWins(2, 2, 2, 2,  new int[] {0,1,2,3});
			
		}
		if(
			(buttons[1][2].getText().equals("O")) &&
			(buttons[2][2].getText().equals("O")) &&
			(buttons[3][2].getText().equals("O")) &&
			(buttons[4][2].getText().equals("O")) 
		  ) {
			
			playerTwoWins(2, 2, 2, 2,  new int[] {1,2,3,4});
			
		}
		if(
			(buttons[0][3].getText().equals("O")) &&
			(buttons[1][3].getText().equals("O")) &&
			(buttons[2][3].getText().equals("O")) &&
			(buttons[3][3].getText().equals("O")) 
		  ) {
			
			playerTwoWins(3, 3, 3, 3,  new int[] {0,1,2,3});
			
		}
		if(
			(buttons[1][3].getText().equals("O")) &&
			(buttons[2][3].getText().equals("O")) &&
			(buttons[3][3].getText().equals("O")) &&
			(buttons[4][3].getText().equals("O")) 
		  ) {
			
			playerTwoWins(3, 3, 3, 3,  new int[] {1,2,3,4});
			
		}
		if(
			(buttons[0][4].getText().equals("O")) &&
			(buttons[1][4].getText().equals("O")) &&
			(buttons[2][4].getText().equals("O")) &&
			(buttons[3][4].getText().equals("O")) 
		  ) {
			
			playerTwoWins(4, 4, 4, 4,  new int[] {0,1,2,3});
			
		}
		if(
			(buttons[1][4].getText().equals("O")) &&
			(buttons[2][4].getText().equals("O")) &&
			(buttons[3][4].getText().equals("O")) &&
			(buttons[4][4].getText().equals("O")) 
		  ) {
			
			playerTwoWins(4, 4, 4, 4,  new int[] {1,2,3,4});
			
		}
		
		/**
		 * Player Two checking condition
		 * Diagonal symbol winning condition
		 */
		if(
			(buttons[1][0].getText().equals("O")) &&
			(buttons[2][1].getText().equals("O")) &&
			(buttons[3][2].getText().equals("O")) &&
			(buttons[4][3].getText().equals("O")) 
		  ) {
			
			playerTwoWins(0, 1, 2, 3,  new int[] {1,2,3,4});
			
		}
		if(
			(buttons[0][0].getText().equals("O")) &&
			(buttons[1][1].getText().equals("O")) &&
			(buttons[2][2].getText().equals("O")) &&
			(buttons[3][3].getText().equals("O")) 
		  ) {
			
			playerTwoWins(0, 1, 2, 3,  new int[] {0,1,2,3});
			
		}
		if(
			(buttons[1][1].getText().equals("O")) &&
			(buttons[2][2].getText().equals("O")) &&
			(buttons[3][3].getText().equals("O")) &&
			(buttons[4][4].getText().equals("O")) 
		  ) {
			
			playerTwoWins(1, 2, 3, 4,  new int[] {1,2,3,4});
			
		}
		if(
			(buttons[0][1].getText().equals("O")) &&
			(buttons[1][2].getText().equals("O")) &&
			(buttons[2][3].getText().equals("O")) &&
			(buttons[3][4].getText().equals("O")) 
		  ) {
			
			playerTwoWins(1, 2, 3, 4,  new int[] {0,1,2,3});
			
		}
		if(
			(buttons[1][4].getText().equals("O")) &&
			(buttons[2][3].getText().equals("O")) &&
			(buttons[3][2].getText().equals("O")) &&
			(buttons[4][1].getText().equals("O")) 
		  ) {
			
			playerTwoWins(4, 3, 2, 1,  new int[] {1,2,3,4});
			
		}
		if(
			(buttons[0][4].getText().equals("O")) &&
			(buttons[1][3].getText().equals("O")) &&
			(buttons[2][2].getText().equals("O")) &&
			(buttons[3][1].getText().equals("O")) 
		  ) {
			
			playerTwoWins(4, 3, 2, 1,  new int[] {0,1,2,3});
			
		}
		if(
			(buttons[1][3].getText().equals("O")) &&
			(buttons[2][2].getText().equals("O")) &&
			(buttons[3][1].getText().equals("O")) &&
			(buttons[4][0].getText().equals("O")) 
		  ) {
			
			playerTwoWins(3, 2, 1, 0,  new int[] {1,2,3,4});
			
		}
		if(
			(buttons[0][3].getText().equals("O")) &&
			(buttons[1][2].getText().equals("O")) &&
			(buttons[2][1].getText().equals("O")) &&
			(buttons[3][0].getText().equals("O")) 
		  ) {
			
			playerTwoWins(3, 2, 1, 0,  new int[] {0,1,2,3});
			
		}

		
		if(isDraw()) {
			
			this.whosTurn.setText("TIE");
			disableWhile(true);
			Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
				//Restarting
				disableWhile(false);
				
				this.whosTurn.setText(nextTurn() + " turn");
				Player.setGameCount(); //Add 1
				super.gameCount.setText("Game: " + Player.getGameCount());
				this.displayCenterLayer(); //Restart
	        }));
			timeline.play();
		}
		


	}
	
	/**
	 * Disable for a while
	 * @param e Boolean Expression
	 */
	protected void disableWhile(boolean e) {
		
		for(int row = 0; row < 5; row++) {
			for(int col = 0; col < 5; col++) {
				buttons[row][col].setDisable(e);
			}
		}
		
	}
	
	/**
	 * Disable for a while if Player Wins
	 * @param e Boolean Expression
	 */
	protected void disableWhile() {
		
		for(int row = 0; row < 5; row++) {
			for(int col = 0; col < 5; col++) {
				buttons[row][col].setDisable(true);
			}
		}
		
	}
	
	/**
	 * A method to return true if the game is draw
	 */
	protected boolean isDraw() {
		//Checks if the game is draw
		
		boolean draw = true;
		
		for(int row = 0; row < 4; row++) {
			for(int col = 0; col < 4; col++) {
				if(buttons[row][col].getText().equals("")) {
					draw = false;
					break;
				}
			}
		}
		
		return draw;
	}

	/**
	 * A method to be called if the Player 1 Wins
	 */
	protected void playerOneWins(int a, int b, int c, int d, int[] rows) {
		// TODO Auto-generated method stub
		buttons[rows[0]][a].setStyle("-fx-background-color: #39FF14");
		buttons[rows[1]][b].setStyle("-fx-background-color: #39FF14");
		buttons[rows[2]][c].setStyle("-fx-background-color: #39FF14");
		buttons[rows[3]][d].setStyle("-fx-background-color: #39FF14");
		
		disableWhile(); //Disable all buttons
		
		this.whosTurn.setText(this.p1.getName() + " wins");
		Player.setGameCount(); //Add 1
		super.gameCount.setText("Game : " + Player.getGameCount());
		
		//Set Score
		this.p1.addScore();
		super.playerScore1.setText(this.p1.getScore());
		
		//Wait 2 Secs
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
			//Restarting
			this.whosTurn.setText(this.p2.getName() + " turn");
			
			this.displayCenterLayer(); //Restart Board
        }));
        timeline.play();	
		
	}

	/**
	 * A method to be called if the Player 2 Wins
	 */
	protected void playerTwoWins(int a, int b, int c, int d, int[] rows) {
		// TODO Auto-generated method stub
		buttons[rows[0]][a].setStyle("-fx-background-color: #39FF14");
		buttons[rows[1]][b].setStyle("-fx-background-color: #39FF14");
		buttons[rows[2]][c].setStyle("-fx-background-color: #39FF14");
		buttons[rows[3]][d].setStyle("-fx-background-color: #39FF14");
		
		disableWhile(); //Disable all buttons
		
		this.whosTurn.setText(this.p2.getName() + " wins");
		Player.setGameCount(); //Add 1
		super.gameCount.setText("Game : " + Player.getGameCount());
		
		//Set Score
		this.p2.addScore();
		super.playerScore2.setText(this.p2.getScore());
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
			//Restarting
			this.whosTurn.setText(this.p1.getName() + " turn");
			this.displayCenterLayer(); //Restart Board
        }));
        timeline.play();	
		
		
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

		for(int row = 0; row < 5; row++) {
			
			for(int col = 0; col < 5; col++) {
				if(event.getSource() == buttons[row][col]) {
					if(this.player1_turn) {
						if(buttons[row][col].getText() == "") {
							buttons[row][col].setStyle("-fx-background-color: #FF3131; -fx-border-color: black;");
							buttons[row][col].setText("X");
							
							this.player1_turn = false;
							this.whosTurn.setText(this.p2.getName() + " turn");
							check();
							
							if(aiMode) {
								AI_firstMove(); //AI TURN
							}
						}
					}
					else {
						if(buttons[row][col].getText() == "") {
							buttons[row][col].setStyle("-fx-background-color: #1F51FF; -fx-border-color: black;");
							buttons[row][col].setText("O");
							this.player1_turn = true;
							this.whosTurn.setText(this.p1.getName() + " turn");
							check();
						}
					}
					
				}
			}
			
		}
		
	}
	
	/**
	 * A method to make the AI MOVED
	 */
	public void AI_firstMove() {
		
		
		if(this.aiMode) {
			
			buttonToggle_AI_Turn(true); //Mag huna huna sadaw siya
			
			Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
				
				buttonToggle_AI_Turn(false); //Humana og huna huna
				
				try {
					if(!this.player1_turn) {
						
						Random random = new Random();
						int ai_row = random.nextInt(5);
						int ai_col = random.nextInt(5);
						
						while(!buttons[ai_row][ai_col].getText().equals("")) {
							ai_row = random.nextInt(5);
							ai_col = random.nextInt(5);
							//System.out.println("Print");
						}
						
						buttons[ai_row][ai_col].setStyle("-fx-background-color: #1F51FF; -fx-border-color: black;");
						buttons[ai_row][ai_col].setText("O");
						this.player1_turn = true;
						this.whosTurn.setText(this.p1.getName() + " turn");
						check();
						
					}
					} catch(Exception error) {
						System.out.println(error);
				}
			
			}));
			timeline.play();
			
			//System.out.println("Ai done moved");
			
		}
	}
	
	//Disable all buttons during AI TURN
	public void buttonToggle_AI_Turn(boolean think) {
		
		for(int row = 0; row < 5; row++) {
			for(int col = 0; col < 5; col++) {
				buttons[row][col].setDisable(think);
			}
		}
		
	}

}
