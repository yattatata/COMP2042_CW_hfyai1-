package p4_group_8_repo;

import javafx.scene.image.Image;
/**
 * 
 * @author Ahmad Nabil
 *
 */
public class End extends Actor{
	boolean activated = false;
	@Override
	public void act(long now) {
	}
	/**
	 * 
	 * @param x This is the first parameter to End method
	 * @param y This is the second parameter to End method
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/images/End.png", 60, 60, true, true));
	}
	/**
	 *  this setEnd method is to display a succesful frog at the end
	 */
	public void setEnd() {
		setImage(new Image("file:src/images/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	/**
	 * 
	 * @return returns a boolean 
	 */
	public boolean isActivated() {
		return activated;
	}
	
}
