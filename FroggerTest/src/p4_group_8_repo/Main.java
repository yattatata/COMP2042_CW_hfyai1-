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

public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	int compareScore;
	int hiscore;
	
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
					hiscore = currentHighscore();
					background = new MyStage();
				    Scene scene  = new Scene(background,600,840);

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
					background.add(new Obstacle("file:src/images/truck1Right.png", 0, 649, 1, 120, 120));
					background.add(new Obstacle("file:src/images/truck1Right.png", 300, 649, 1, 120, 120));
					background.add(new Obstacle("file:src/images/truck1Right.png", 600, 649, 1, 120, 120));
					background.add(new Obstacle("file:src/images/truck1Right.png", 720, 649, 1, 120, 120));
					background.add(new Obstacle("file:src/images/car1Left.png", 100, 597, -1, 50, 50));
					background.add(new Obstacle("file:src/images/car1Left.png", 250, 597, -1, 50, 50));
					background.add(new Obstacle("file:src/images/car1Left.png", 400, 597, -1, 50, 50));
					background.add(new Obstacle("file:src/images/car1Left.png", 550, 597, -1, 50, 50));
					background.add(new Obstacle("file:src/images/truck2Right.png", 0, 540, 1, 200, 200));
					background.add(new Obstacle("file:src/images/truck2Right.png", 500, 540, 1, 200, 200));
					background.add(new Obstacle("file:src/images/car1Left.png", 500, 490, -5, 50, 50));
					background.add(new Digit(0, 30, 570, 10));
					background.start();
					primaryStage.setScene(scene);
					primaryStage.show();
					primaryStage.setResizable(false); // prevents user from resizing the window
					start();  
				}
				if (event.getCode() == KeyCode.I) {
                    main_scene.add(new Help(1000));
				}
				}
			});
		}
		 
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
                	if (animal.getPoints() > hiscore) {
                		try {
    						writeScore(animal.getPoints());
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
            		alert.setHeaderText("Your Score is "+animal.getPoints()+"!\nPrevious Highscore was"+hiscore);
            		//alert.setContentText("Highest Possible Score: 850");
            		alert.show();
            	}
            	if (animal.loselives()) {
            		setLives(animal.getlives());
            	}
            }
        };
    }
	public void setLives (int n) {
		background.add(new Lives(n));
		if (n==0) {
			stop();
			if (animal.getPoints() > hiscore) {
	    		try {
					writeScore(animal.getPoints());
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	}
			background.stop();
			background.stopMusic();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Game Over - Out Of Lives");
    		alert.setHeaderText("Your Score is "+animal.getPoints()+"!\nHighScore is "+hiscore);
    		//alert.setContentText("Highest Possible Score: 850");
    		alert.show();
		}
		
	}
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
    /*
     * Writes New HighScore in scores.dat file
     */
    public void writeScore(int newScore) throws IOException {

        File output = new File("C:\\Users\\yungi\\git\\COMP2042_CW_hfyai1-\\FroggerTest\\src\\p4_group_8_repo\\scores.dat");
        FileWriter writer = new FileWriter(output);
        PrintWriter printWriter = new PrintWriter(writer);

        printWriter.printf("%d", newScore);
        printWriter.close();
    }

   /* public void readScore() throws IOException {
        int i, space = 0, power = 2;
        try (FileReader hiscore = new FileReader("C:\\Users\\yungi\\git\\COMP2042_CW_hfyai1-\\FroggerTest\\src\\p4_group_8_repo\\scores.txt")) {
            while ((i = hiscore.read()) != -1) {
                int char2int = (char)i - '0';
                background.add(new Digit(char2int, 130 - space, 30, 25));
                space-=20;
                compareScore += (Math.pow(10, power)) * char2int;
                power--;
            }
        }
        catch(IOException e) {
            System.out.println("no file");
        }
    }*/
    /*
     * Reads Previous HighScore
     */
    public int currentHighscore() { 
    	FileReader readFile = null;
    	BufferedReader reader = null;
    	try
    	{
    		readFile = new FileReader("C:\\Users\\yungi\\git\\COMP2042_CW_hfyai1-\\FroggerTest\\src\\p4_group_8_repo\\scores.dat");
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
