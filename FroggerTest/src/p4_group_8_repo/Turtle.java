package p4_group_8_repo;

import javafx.scene.image.Image;
/**
 * 
 * @author Ahmad Nabil
 *
 */
public class Turtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	private int speed;
	int i = 1;
	boolean bool = true;
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		
		if (getX() > 600 && speed>0)
			setX(-200);
		
		if (getX() < -75 && speed<0)
			setX(600);
	}
	/**
	 * 
	 * @param xpos This is the first parameter to Turtle method for x position
	 * @param ypos This is the second parameter to Turtle method for y position
	 * @param s    This is the third parameter to Turtle method for speed
	 * @param w    This is the fourth parameter to Turtle method for width
	 * @param h    This is the fifth parameter to Turtle method for height
	 */
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		
		turtle1 = new Image("file:src/images/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/images/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/images/TurtleAnimation3.png", w, h, true, true);
		
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
}
