package p4_group_8_repo;

import javafx.scene.image.Image;
/**
 * 
 * @author Ahmad Nabil
 *
 */
public class Log extends Actor {

	private double speed;
	
	@Override
	public void act(long now) {
		move(speed , 0);
		
		if (getX()>600 && speed>0)
			setX(-180);
		
		if (getX()<-300 && speed<0)
			setX(700);
	}
	/**
	 * 
	 * @param imageLink This is the first parameter to Log method
	 * @param size      This is the second parameter to Log method
	 * @param xpos      This is the third parameter to Log method
	 * @param ypos      This is the fourth parameter to Log method
	 * @param s         This is the fifth parameter to Log method
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	/**
	 * 
	 * @return returns a boolean true if speed <0
	 */
	public boolean getLeft() {
		return speed < 0;
	}
}
