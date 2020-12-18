package p4_group_8_repo;

import javafx.scene.image.Image;
/**
 * 
 * @author Ahmad Nabil
 *
 */
public class Digit extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {	
	}
	/**
	 * 
	 * @param n   this is the first parameter to Digit method
	 * @param dim this is the second parameter to Digit method
	 * @param x   this is the third parameter to Digit method
	 * @param y   this is the fourth parameter to Digit method
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/images/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}	
}
