package p4_group_8_repo;

import java.io.File;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 * 
 * @author Ahmad Nabil
 *
 */
public class MyStage extends World{
	MediaPlayer mediaPlayer;
	boolean mute = false;
	
	@Override
	public void act(long now) {
	}
	/**
	 * MyStage constructor
	 */
	public MyStage() {
	
	setOnKeyPressed(new EventHandler<KeyEvent>() {
		public void handle(KeyEvent event){
			if(event.getCode() == KeyCode.M) {
				if(mute) 
					stopMusic();			
				else 
					playMusic();
			}
		}
	});
}
	/**
	 * This playMusic method is to play music
	 */
	public void playMusic() {
		String musicFile = "src/sound/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	    mute = true;
	}
	/**
	 * This stopMusic method is to stop the music
	 */
	public void stopMusic() {
		mediaPlayer.stop();
		mute = false;
	}
}
