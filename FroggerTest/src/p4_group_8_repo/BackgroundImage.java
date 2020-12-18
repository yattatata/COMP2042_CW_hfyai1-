package p4_group_8_repo;

import javafx.scene.image.Image;
/**
 * 
 * @author Ahmad Nabil
 *
 */
public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {}
	/**
	 * 
	 * @param imageLink This is the first parameter to BackgroundImage method
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 848, true, true));	
	}

}
