package p4_group_8_repo;

import javafx.scene.image.Image;

public class Digit extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {	
	}
	
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/images/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}	
}
