package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class would sets up the color themes in the game
 * 
 */

public class ColorTheme {
	
	//List of Names of the Theme in ArrayList
	private ArrayList<String> themeNames = new ArrayList<String>();
	
	/**
	 * Keys  : Name of Theme
	 * Value : Background Color in CSS Style
	 */
	private Map<String, ArrayList<String>> colorThemeList = new HashMap<String, ArrayList<String>>();
	
	private int totalThemes = 1; //Default selector at 0 index
	
	//Initializes the themes
	public ColorTheme() {
		
		/**
		 * 
		 * This is where you add a theme
		 * Color Themes (including border line in each buttons)
		 * Key : Name of the Theme
		 * Value : ArrayList in String type
		 * 
		 * Elements of the ArrayList 
		 * ::::::::::::::::::::::::::::
		 * Index 0 : Background Color
		 * Index 1 : Border Line Color
		 * ::::::::::::::::::::::::::::
		 * 
		 * NOTE : Dari ra mag add og Name sa theme and iyang background color and border line color in CSS style
		 * 
		 */
		
		ArrayList<String> frost = new ArrayList<String>();
		frost.add("-fx-background-color: linear-gradient(#000428, #004e92);"); //INDEX 0
		frost.add("-fx-border-color: #1071E5");								   //INDEX 1
		this.colorThemeList.put("Frost", frost); 
		
		ArrayList<String> endlessRiver = new ArrayList<String>();
		endlessRiver.add("-fx-background-color : linear-gradient(#43cea2, #185a9d);");
		endlessRiver.add("-fx-border-color: #000000");
		this.colorThemeList.put("Endless River", endlessRiver); 
		
		ArrayList<String> duskColor = new ArrayList<String>();
		duskColor.add("-fx-background-color : linear-gradient(#FFD89B, #19547B);");
		duskColor.add("-fx-border-color: #4C535D");
		this.colorThemeList.put("Dusk Color", duskColor); 
		
		ArrayList<String> tranquil = new ArrayList<String>();
		tranquil.add("-fx-background-color : linear-gradient(#EECDA3, #EF629F);");
		tranquil.add("-fx-border-color: #EF629F");
		this.colorThemeList.put("Tranquil", tranquil); 
		
		ArrayList<String> royal = new ArrayList<String>();
		royal.add("-fx-background-color : linear-gradient(#141E30, #243B55);");
		royal.add("-fx-border-color: #4C535D");
		this.colorThemeList.put("Royal", royal); 
		
		ArrayList<String> purpleLove = new ArrayList<String>();
		purpleLove.add("-fx-background-color : linear-gradient(#cc2b5e, #753a88);");
		purpleLove.add("-fx-border-color: #753a88");
		this.colorThemeList.put("Purple Love", purpleLove); 
		
		ArrayList<String> celestial = new ArrayList<String>();
		celestial.add("-fx-background-color : linear-gradient(#C33764 , #1D2671);");
		celestial.add("-fx-border-color: #000000");
		this.colorThemeList.put("Celestial", celestial); 
		
		/**
		 * Character color picker
		 */
		
		/**
		 * This inserts all keys into the ArrayList type String
		 */
		for(String theme : this.colorThemeList.keySet()) {
			this.themeNames.add(theme);
		}
		
	}
	
	/**
	 * Gets the name of the theme
	 * @return	Returns a String type of name of the Theme
	 */
	public String getThemeName() {
		return this.themeNames.get(totalThemes);
	}
	
	/**
	 * Gets the current theme
	 * @return
	 */
	public String getcurrentTheme() {
		return this.colorThemeList.get(this.themeNames.get(totalThemes)).get(0);
	}
	
	/**
	 * A getter method to get the theme
	 * @return	Returns a CSS style -fx-background color of the Theme
	 */
	public String getBackgroundTheme() {
		
		this.totalThemes++;
		if(this.totalThemes == this.colorThemeList.size()) {
			this.totalThemes = 0;
			
			return this.colorThemeList.get(this.themeNames.get(totalThemes)).get(0);
		}
		
		else {
			//System.out.println(themeNames.get(totalThemes));
			return this.colorThemeList.get(this.themeNames.get(totalThemes)).get(0);
		}
		
	}
	
	/**
	 * A getter method to get the color for the Buttons (including border line color
	 * @return
	 */
	public String getButtonsTheme() {
		return this.colorThemeList.get(this.themeNames.get(totalThemes)).get(0) + " " + this.colorThemeList.get(this.themeNames.get(totalThemes)).get(1);
	}
	
}
