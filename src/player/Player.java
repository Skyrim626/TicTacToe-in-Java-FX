package player;

/**
 * This class would handle the Name & Score of the Player in the game, 
 * such as calculating the score and sets the Name of the Player
 */
public class Player {
	
	private String name;
	private int score = 0;
	private static int gameCount = 1;
	
	/**
	 * A constructor for instantiating the name of the Player
	 * @param name	String representation for initializing the Name of the Player
	 */
	public Player(String name) {
		this.name = name;
	}
	
	public Player() {
		
	}
	
	/**
	 * A getter method to get the score of the Player
	 * @return	Returns the score in Integer Type Value to the Player
	 */
	public String getScore() {
		
		return Integer.toString(this.score);
		
	}
	
	/**
	 * A method to add a score to the Player
	 */
	public void addScore() {
		this.score++;
	}
	
	/**
	 * A getter method to get the name of the Player
	 * @return	Returns a String type Name of the Player
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the game count
	 * @return	Returns the game count
	 */
	public static String getGameCount() {
		return Integer.toString(gameCount);
	}
	
	/**
	 * Sets the game count by 1 for every play
	 */
	public static void setGameCount() {
		gameCount++;
	}
	
	/**
	 * Resets the GameCount when the User Go Back to the Main Menu
	 */
	public static void resetGameCount() {
		gameCount = 1;
	}
	
}
