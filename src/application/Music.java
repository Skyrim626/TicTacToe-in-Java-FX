package application;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music {
	
	private ArrayList<MediaPlayer> musics = new ArrayList<MediaPlayer>();
	//private int count = 0;
	//private boolean mute = false;
	
	private Random randomMusic;
	
	/**
	 * This is where you can add some music in the Music Class Constructor
	 */
	Music() {
		
		//Adding Music
		
		/*
		 * Base After Base Music
		 */
		String file = new File("Music/backgroundMusic1.mp3").getPath();
		Media music = new Media(Paths.get(file).toUri().toString());
		this.musics.add(new MediaPlayer(music));
		
		
		
		/*
		 * MC ORSEN - WARNING (Sped Up)
		 */
		file = new File("Music/MC ORSEN - WARNING (Sped Up).mp3").getPath();
		music = new Media(Paths.get(file).toUri().toString());
		this.musics.add(new MediaPlayer(music));
		
		/*
		 * DJVI  Cycles.mp3
		 */
		file = new File("Music/DJVI  Cycles.mp3").getPath();
		music = new Media(Paths.get(file).toUri().toString());
		
		this.musics.add(new MediaPlayer(music));
		
	}
	
	public void playCurrentMusic() {
		
		//System.out.println(this.musics.size());
		randomMusic = new Random();
		int selected = randomMusic.nextInt(this.musics.size());
		
		//this.musics.get(selected).setCycleCount(MediaPlayer.INDEFINITE); //loop music
		
		//A method for next Song in the list (this is sequence)
		this.musics.get(selected).setOnEndOfMedia(() -> {
			//Move to the next song in the list
			this.musics.get(selected).stop();
			int nextSong = randomMusic.nextInt(this.musics.size() - 1);
			this.musics.get(nextSong).play();
		}); 
		
		this.musics.get(selected).play();
		
		
	}

}