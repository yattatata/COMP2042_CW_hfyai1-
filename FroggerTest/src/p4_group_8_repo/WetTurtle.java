package p4_group_8_repo;

import javafx.scene.image.Image;
/**
 * 
 * @author Ahmad Nabil
 *
 */
public class WetTurtle extends Actor{
	
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	
	private int speed;
	int i = 1;
	boolean bool = true;
	boolean sunk = false;
	
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} 
				else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	/**
	 * 
	 * @param xpos This is the first parameter to WetTurtle method for x position
	 * @param ypos This is the second parameter to WetTurtle method for y position
	 * @param s    This is the third parameter to WetTurtle method for speed
	 * @param w    This is the fourth parameter to WetTurtle method for width
	 * @param h    This is the fifth parameter to WetTurtle method for height
	 */
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		
		turtle1 = new Image("file:src/images/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/images/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image("file:src/images/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("file:src/images/TurtleAnimation4Wet.png", w, h, true, true);
		
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	} 
	/**
	 * 
	 * @return returns true if sunk
	 */
	public boolean isSunk() {
		return sunk;
	}
}
