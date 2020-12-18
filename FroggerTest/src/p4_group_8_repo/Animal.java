package p4_group_8_repo;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
/**
 * 
 * @author Ahmad Nabil
 *
 */
public class Animal extends Actor {
	
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	
	int points = 0;
	int end = 1;
	private boolean second = false;
	boolean noMove = false;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	boolean loselives = true;

	
	boolean levelUp = true;
	int levels = 6;
	
	int lives = 4;
	int carD = 0;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	/**
	 * 
	 * @param imageLink parameter receives imagelink to Animal method
	 */
	public Animal(String imageLink) {
		
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		reset();
		
		imgW1 = new Image("file:src/images/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/images/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/images/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/images/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/images/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/images/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/images/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/images/froggerRightJump.png", imgSize, imgSize, true, true);
		
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				
				if (noMove) {}
				
				else {
				if (second) {
					if (event.getCode() == KeyCode.W||event.getCode() == KeyCode.UP) {	  
		                move(0, -movement);
		                changeScore = false;
		                setImage(imgW1);
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.A||event.getCode() == KeyCode.LEFT) {	            	
		            	 move(-movementX, 0);
		            	 setImage(imgA1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.S||event.getCode() == KeyCode.DOWN) {	            	
		            	 move(0, movement);
		            	 setImage(imgS1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.D||event.getCode() == KeyCode.RIGHT) {	            	
		            	 move(movementX, 0);
		            	 setImage(imgD1);
		            	 second = false;
		            }
				}
				else if (event.getCode() == KeyCode.W||event.getCode() == KeyCode.UP) {	            	
	                move(0, -movement);
	                setImage(imgW2);
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.A||event.getCode() == KeyCode.LEFT) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.S||event.getCode() == KeyCode.DOWN) {	            	
	            	 move(0, movement);
	            	 setImage(imgS2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.D||event.getCode() == KeyCode.RIGHT) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD2);
	            	 second = true;
	            }
	        }
			}
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				
				if (noMove) {}
				
				else {
				if (event.getCode() == KeyCode.W ||event.getCode() == KeyCode.UP) {	  
					if (getY() < w) {
						changeScore = true;
						w = getY();
						points+=10;
					}
	                move(0, -movement);
	                setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A||event.getCode() == KeyCode.LEFT) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S||event.getCode() == KeyCode.DOWN) {	            	
	            	 move(0, movement);
	            	 setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D||event.getCode() == KeyCode.RIGHT) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD1);
	            	 second = false;
	            }
	        }
			}
			
		});
	}
	
	@Override
	public void act(long now) {
		@SuppressWarnings("unused")
		int bounds = 0;
		if (getY()<0 || getY()>734) {
			reset();
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/images/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/images/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/images/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				reset();
				loselives = true;
				carDeath = false;
				setImage(new Image("file:src/images/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/images/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/images/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/images/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/images/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				reset();
				loselives = true;
				waterDeath = false;
				setImage(new Image("file:src/images/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		
		if (getX()>600) {
			move(-movement*2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
				loselives = true;
			}
			points+=50;
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			levelUp();				//LEVELS ------------------------
			levelUp = true;		//LEVELS ------------------------
			reset();
		}
		else if (getY()<413){
			waterDeath = true;
		}
	}
	/**
	 * 
	 * @return checks if player has finished game
	 */
	public boolean getStop() {
		return end==6;
	}
	/**
	 * 
	 * @return returns points value
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * 
	 * @return returns boolean
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	/**
	 * 
	 * @return returns boolean
	 */
	public boolean levelUp() { 
		if (levelUp) {
			levelUp = false;
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @return get current level value
	 */
	public int getLevels() {
		return end;
	}
	/**
	 * resets frog starting location
	 */
	public void reset() {
		setX(300);
		setY(725+movement);
		carD = 0;
	}
	/**
	 * 
	 * @return returns a boolean 
	 */
	public boolean loselives() {
		if(loselives) {
			lives--;
			loselives = false;
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @return returns lives value
	 */
	public int getlives() {
		return lives;
	}
}
