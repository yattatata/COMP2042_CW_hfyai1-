package p4_group_8_repo;

import javafx.scene.image.Image;
/**
 * 
 * @author Ahmad Nabil
 *
 */
public class Obstacle extends Actor {
	private int speed;
	@Override
	public void act(long now) {
		
		move(speed , 0);
		
		if (getX() > 600 && speed>0)
			setX(-200);
		
		if (getX() < -50 && speed<0)
			setX(600);
	}
	/**
	 * 
	 * @param imageLink This is the first parameter to Obstacle method for image location
	 * @param xpos      This is the second parameter to Obstacle method for x position
	 * @param ypos      This is the third parameter to Obstacle method for y position
	 * @param s         This is the fourth parameter to Obstacle method for speed
	 * @param w         This is the fifth parameter to Obstacle method for width
	 * @param h         This is the sixth parameter to Obstacle method for height
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
