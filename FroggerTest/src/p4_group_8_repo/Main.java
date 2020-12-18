package p4_group_8_repo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * 
 * @author Ahmad Nabil
 *
 */

public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	int compareScore;
	int hiScore;
	Obstacle lorry11, lorry12, lorry13, lorry14, lorry21, lorry22;
	Obstacle car11, car12, car13, car14, car21, car22;
	Newlevel level_text; // --------------------------------
	/**
	 * This is the main method
	 * @param args a string array
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MyStage main_scene = new MyStage(); 
		Scene mainscene = new Scene(main_scene,600,900);
		Menu mainMenu = new Menu();
		main_scene.add(mainMenu);
		primaryStage.setScene(mainscene);
		primaryStage.show();
		primaryStage.setResizable(false);
		
		main_scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle (KeyEvent event) {
				if(event.getCode() == KeyCode.SPACE) {

					hiScore = currentHighscore();
					background = new MyStage();
				    Scene scene  = new Scene(background,600,848);

					BackgroundImage froggerback = new BackgroundImage("file:src/images/BG_Img.png"); //frogger background image
					background.add(froggerback);
					
					background.add(new Log("file:src/images/log3.png", 150, 0, 166, 0.75));
					background.add(new Log("file:src/images/log3.png", 150, 220, 166, 0.75));
					background.add(new Log("file:src/images/log3.png", 150, 440, 166, 0.75));
					background.add(new Log("file:src/images/logs.png", 300, 0, 276, -2));
					background.add(new Log("file:src/images/logs.png", 300, 400, 276, -2));
					background.add(new Log("file:src/images/log3.png", 150, 50, 329, 0.75));
					background.add(new Log("file:src/images/log3.png", 150, 270, 329, 0.75));
					background.add(new Log("file:src/images/log3.png", 150, 490, 329, 0.75));
					
					background.add(new Turtle(500, 376, -1, 130, 130));
					background.add(new Turtle(300, 376, -1, 130, 130));
					
					background.add(new WetTurtle(700, 376, -1, 130, 130));
					background.add(new WetTurtle(600, 217, -1, 130, 130));
					background.add(new WetTurtle(400, 217, -1, 130, 130));
					background.add(new WetTurtle(200, 217, -1, 130, 130));
					
					background.add(new End(10,102));
					background.add(new End(135,102));
					background.add(new End(265,102));
					background.add(new End(393,102));
					background.add(new End(521,102));
					
					animal = new Animal("file:src/images/froggerUp.png");
					background.add(animal);
					
					//Lane 1
					lorry11 = new Obstacle("file:src/images/truck1Right.png", 0, 649, 1, 120, 120);
					lorry12 = new Obstacle("file:src/images/truck1Right.png", 300, 649, 1, 120, 120);
					lorry13 = new Obstacle("file:src/images/truck1Right.png", 600, 649, 1, 120, 120);
					lorry14 = new Obstacle("file:src/images/truck1Right.png", 720, 649, 1, 120, 120);
					background.add(lorry11);
					background.add(lorry12);
					background.add(lorry13);
					background.add(lorry14);
					
					//Lane 2
					car11 = new Obstacle("file:src/images/car1Left.png", 100, 597, -1, 50, 50);
					car12 = new Obstacle("file:src/images/car1Left.png", 250, 597, -1, 50, 50);
					car13 = new Obstacle("file:src/images/car1Left.png", 400, 597, -1, 50, 50);
					car14 = new Obstacle("file:src/images/car1Left.png", 550, 597, -1, 50, 50);
					background.add(car11);
					background.add(car12);
					background.add(car13);
					background.add(car14);
					
					//Lane 3
					lorry21 = new Obstacle("file:src/images/truck2Right.png", 0, 540, 1, 200, 200);
					lorry22 = new Obstacle("file:src/images/truck2Right.png", 500, 540, 1, 200, 200);
					background.add(lorry21);
					background.add(lorry22);
					
					//Lane 4
					car21 = new Obstacle("file:src/images/car1Left.png", 500, 490, -1, 50, 50);
					background.add(car21);
					
					level_text = new Newlevel(20, 427, 100);
					background.add(level_text);
					background.add(new Digit(0, 30, 570, 10));
					background.start();
					primaryStage.setScene(scene);
					primaryStage.show();
					primaryStage.setResizable(false);
					start();  
				}
				
				if (event.getCode() == KeyCode.I) {
                    main_scene.add(new Info(1000));
				}
				
				if (event.getCode() == KeyCode.ESCAPE) {
					main_scene.add(new Menu());
				}
				}
			});
		}
		 /**
		  * createTimer Method
		  */
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.levelUp()) {
            		int levels = animal.getLevels();
            		System.out.println(levels);
            		switch(levels) {
            		case 2:
            			levelTwo();
            			break;
            		case 3:
            			levelThree();
            			break;
            		
            		case 4:
            			levelFour();
            			break;
            			
            		case 5:
            			levelFive();
            			break;
            		}	
            	}
            	if (animal.loselives()) {
            		setLives(animal.getlives());
            	}
            	if (animal.getStop()) {
                	if (animal.getPoints() > hiScore) {
                		try {
    						writeHiScore(animal.getPoints());
    					} catch (IOException e) {
    						e.printStackTrace();
    					}
                	}
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your Score is "+animal.getPoints()+"!\nPrevious Highest score was "+hiScore);
            		alert.show();
            	}

            }
        };
    }
	/**
	 * @param n This receives the current lives of player
	 */
	public void setLives (int n) {
		background.add(new Lives(n));
		if (n==0) {
			stop();
			if (animal.getPoints() > hiScore) {
	    		try {
					writeHiScore(animal.getPoints());
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	}
			background.stop();
			background.stopMusic();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Game Over - Out Of Lives");
    		alert.setHeaderText("Your Score is "+animal.getPoints()+"!\nPrevious Highest score was "+hiScore);
    		alert.show();
		}
		
	}
	/**
	 * start Method
	 */
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
    	{
    		if (timer != null) {
    			 timer.stop();
    		}
    	}  
    }
    /**
     * levelTwo Method
     */
    public void levelTwo() {
    	level_text.increment();
    	background.remove(car21);
    	car21 = new Obstacle("file:src/images/car1Left.png", 500, 490, -3, 50, 50);
    	car22 = new Obstacle("file:src/images/car1Left.png", 300, 490, -3, 50, 50);
    	background.add(car21);
    	background.add(car22);
    }
    /**
     * levelThree Method
     */
    public void levelThree() {
    	level_text.increment();
    	background.remove(lorry11);
    	background.remove(lorry12);
    	background.remove(lorry13);
    	background.remove(lorry14);
    	lorry11 = new Obstacle("file:src/images/truck1Right.png", 0, 649, 2, 120, 120);
    	lorry12 = new Obstacle("file:src/images/truck1Right.png", 300, 649, 2, 120, 120);
    	lorry13 = new Obstacle("file:src/images/truck1Right.png", 600, 649, 2, 120, 120);
    	lorry14 = new Obstacle("file:src/images/truck1Right.png", 720, 649, 2, 120, 120); 
    	background.add(lorry11);
    	background.add(lorry12);
    	background.add(lorry13);
    	background.add(lorry14);	
    }
    /**
     * levelFour Method
     */
    public void levelFour() {
    	level_text.increment();
    	background.remove(car21);
    	background.remove(car22);
    	car21 = new Obstacle("file:src/images/car1Left.png", 500, 490, -6, 50, 50);
    	car22 = new Obstacle("file:src/images/car1Left.png", 300, 490, -6, 50, 50);
    	background.add(car21);
    	background.add(car22);
    }
    /**
     * levelFive Method
     */
    public void levelFive() {
    	level_text.increment();
    	background.remove(lorry21);
    	background.remove(lorry22);
    	lorry21 = new Obstacle("file:src/images/truck2Right.png", 0, 540, 3, 200, 200);
		lorry22 = new Obstacle("file:src/images/truck2Right.png", 500, 540, 3, 200, 200);
		background.add(lorry21);
		background.add(lorry22);
    	
    }
    
    /**
     * Writes New HighScore in data file
     * @param newHiScore First parameter added to writeHiScore
     * @throws IOException throws exception
     */
    public void writeHiScore(int newHiScore) throws IOException {

        File output = new File("src/p4_group_8_repo/scores.dat");
        FileWriter writer = new FileWriter(output);
        PrintWriter printWriter = new PrintWriter(writer);

        printWriter.printf("%d", newHiScore);
        printWriter.close();
    }
    /**
     * This method fetches the current highscore from score.dat file
     * @return current Highscore
     */
    public int currentHighscore() { 
    	FileReader readFile = null;
    	BufferedReader reader = null;
    	try
    	{
    		readFile = new FileReader("src/p4_group_8_repo/scores.dat");
    		reader = new BufferedReader(readFile);
    		return Integer.parseInt(reader.readLine());
    	}
    	catch (Exception e)
    	{
    		return 0;
    	}
    	finally
    	{
    		try {
    			if (reader != null)
				reader.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
    	}
    }
    /**
     * @param n This is the first parameter to setNumber method
     */
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 570 - shift, 10));
    		  shift+=30;
    		}
    }

}

