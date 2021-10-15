package javaCLASS;

	// filler code for pong provided by Mr. David

	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Font;
	import java.awt.Graphics;
	import java.awt.Rectangle;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.util.ArrayList;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	
	import java.util.Random;

	public class Pong extends JPanel implements KeyListener {
		
		// constants that are predefined and won't change as the program runs
		//constants for the window
		private final int WIDTH = 600, HEIGHT = 600, WINDOW_HEIGHT = 650;

		//instance variables for the ball
		private int ballx = 200;
		private int bally = 200;
		private int ballspeedx = 8;
		private int ballspeedy = 3;	
		private final int BALLSIZE = 20;
		
		//instance variables for the random number generator
		int speedrange = 4;
		int speedmin = 2;
		int positionrange = 400;
		int positionmin = 100;
		
		//instance variables for the paddle
		private int paddle1x = 0;
		private int paddle1y = 300;
		
		private int paddle2x = 580;
		private int paddle2y = 300;
		
		private int paddlespeed = 7;
		
		private int PADDLEWIDTH = 20;
		private int PADDLEHEIGHT = 100;
		
		// instance variables for the score
		private int score1 = 0;
		private int score2 = 0;
		
		// instance variables for the black hole
		private int blackholex = 300;
		private int blackholey = 400;
		private int BLACKHOLEWIDTH = 50;
		private int BLACKHOLEHEIGHT = 50;
		private int BLACKHOLESPEEDY = 5;
		private int BLACKHOLESPEEDX = 5;
		
		//booleans for the ai, paddle movements and the reset text
		private boolean up1, down1, up2, down2, resetmessage, ai;	
		
		// this method moves the ball at each timestep
		public void move_ball() {
			//applies speed to ball to make it move
			bally += ballspeedy;
			ballx += ballspeedx;	
		}
		
		// this method moves the paddles at each timestep
		public void move_paddles() {
			//applies speed to paddle to make it move
			if (up1 == true){
				paddle1y -= paddlespeed;
			}
			if (down1 == true) {
				paddle1y += paddlespeed;
			}
			if (up2 == true){
				paddle2y -= paddlespeed;
			}
			if (down2 == true) {
				paddle2y += paddlespeed;
			}
		}

		// this method checks if there are any bounces to take care of,
		// and if the ball has reached a left/right wall it adds to 
		// the corresponding player's score
		public void check_collisions() {
		//checks collisions between the ball and paddles
			//left paddle
			if (ballx - BALLSIZE <= paddle1x + PADDLEWIDTH && bally + BALLSIZE >= paddle1y && bally - BALLSIZE 
				<= PADDLEHEIGHT + paddle1y) {
				ballspeedx = -ballspeedx; 
			
			}
			//right paddle
			if (ballx + BALLSIZE >= paddle2x && bally + BALLSIZE >= paddle2y && bally - BALLSIZE <= paddle2y + PADDLEHEIGHT) {
				ballspeedx = -ballspeedx; 
				}
		
		//checks collisions between the ball and the perimeter of the window and makes the ball bounce off if it hits 
		//the top/bottom
		//calls reset ball and adds to the score if it hits the left or right side
			if (ballx > WIDTH){
				resetBall();
				score1 ++;
			}
			else if (bally > HEIGHT){
				ballspeedy = -ballspeedy;
			}
			else if (bally < 0) {
				ballspeedy = -ballspeedy;
			}
			else if (ballx < 0) {
				resetBall();
				score2 ++;
			}
			//checks if the blackhole and ball have collided and if they have it spits the ball out at a random place
			//with random speed
			if (ballx + BALLSIZE <= blackholex + BLACKHOLEWIDTH && bally <= blackholey + BLACKHOLEHEIGHT && bally >= blackholey 
				&& ballx >= blackholex ) {
				ballx = generateRandom(positionrange, positionmin);
				bally = generateRandom(positionrange, positionmin);
				if (generateRandom(2, 0) == 1) {
					ballspeedx = -ballspeedx;
					ballspeedy = -ballspeedy;
				}
				}
			//checks collisions between the ball and the perimeter of the window and makes the ball bounce off if 
			//it hits any of the sides
			if (blackholex > WIDTH + BLACKHOLEWIDTH){
				BLACKHOLESPEEDX = -BLACKHOLESPEEDX;
			}
			else if (blackholey > HEIGHT + BLACKHOLEHEIGHT){
				BLACKHOLESPEEDY = -BLACKHOLESPEEDY;
			}
			else if (blackholey < 0 - BLACKHOLEHEIGHT) {
				BLACKHOLESPEEDY = -BLACKHOLESPEEDY;
			}
			else if (blackholex < 0 - BLACKHOLEWIDTH) {
				BLACKHOLESPEEDX = -BLACKHOLESPEEDX;
			}
	}
		
	// this creates the black hole that sucks the ball in and spits it out at a random place on the screen, at a random speed
	public void black_hole() {
		//applies speed to make blackhole move
		blackholey += BLACKHOLESPEEDY;
		blackholex += BLACKHOLESPEEDX;
	
	}
			
		//this creates a computer (1 player mode) on the left side that plays the ball back to the second player
		public void ai() {
			if(ai == true){
				//makes the ball go up if the ball is above it but not go out of the window
				if (bally < paddle1y) {
					up1 = true;
					down1 = false;
					checkPaddleCollisions();
				}
				//makes the ball go down if the ball is below it but not go out of the window
				else if(bally > paddle1y + PADDLEHEIGHT) {
					down1 = true;
					up1 = false;
					checkPaddleCollisions();
				}	
				// stops the paddle from moving when it is at the height of the ball
				else {
					down1= false;
					up1 = false;
				}
				
			}
		}
		
		//checks if the paddles have gone off frame and if thats true makes them stop moving
		public void checkPaddleCollisions () {
			if (paddle1y < 0) {
				up1 = false;
			}
			if (paddle1y > HEIGHT) {
				down1 = false;
			}
		}

		//brings ball back to the center, sets its speed to zero and asks the player if they want to continue playing
		public void resetBall() {
			ballx = 300;
			bally = 400;
			ballspeedx = 0;
			ballspeedy= 0;
			
			resetmessage = true;	
		}
		
		// random number generator called throughout the code
		public int generateRandom(int range, int min) {
			return (int)(Math.random()*range + min);
		}
		
		// defines what we want to happen anytime we draw the game
		// you simply need to fill in a few parameters here
		public void paint(Graphics g) {
			
			// background color is gray
			g.setColor(new Color (201, 123, 44));
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			// draw your rectangles and circles here
			// .......
			
			// writes the score of the game - you just need to fill the scores in
			Font f = new Font("Courier New", Font.BOLD, 14);
			g.setFont(f);
			g.setColor(new Color(253, 255, 207));
			g.drawString("P1 Score:" + score1, WIDTH/5, 20);
			g.drawString("P2 Score:" + score2, WIDTH*3/5, 20);
			
			//draws the ball
			g.setColor(new Color(253, 255, 207));
			g.drawOval(ballx, bally, BALLSIZE, BALLSIZE);
			g.fillOval(ballx, bally, BALLSIZE, BALLSIZE);
			
			//draws the left paddle
			g.setColor(new Color(64, 201, 188));
			g.drawRect(paddle1x, paddle1y, PADDLEWIDTH, PADDLEHEIGHT);
			g.fillRect(paddle1x, paddle1y, PADDLEWIDTH, PADDLEHEIGHT);
			//draws the right paddle
			g.setColor(new Color(64, 201, 188));
			g.drawRect(paddle2x, paddle2y, PADDLEWIDTH, PADDLEHEIGHT);
			g.fillRect(paddle2x, paddle2y, PADDLEWIDTH, PADDLEHEIGHT);
			
			//draws the black hole
			g.setColor(new Color(48, 112, 99));
			g.drawRect(blackholex, blackholey, BLACKHOLEWIDTH, BLACKHOLEHEIGHT);
			g.fillRect(blackholex, blackholey, BLACKHOLEWIDTH, BLACKHOLEHEIGHT);
			
			// draws the reset message
			if (resetmessage == true) {
				g.drawString("Paused: Push r key to play! ", WIDTH/3, HEIGHT/2);
			}
		}

		// defines what we want to happen if a keyboard button has 
		// been pressed - you need to complete this
		public void keyPressed(KeyEvent e) {
			
			int keyCode = e.getKeyCode();
			
			// changes paddle direction based on what button is pressed
			if (keyCode == KeyEvent.VK_DOWN) { 
				down2 = true;
			}
			if (keyCode == KeyEvent.VK_UP) {
				up2 = true;
			}
			if (e.getKeyChar() == 'w') {
				up1 = true;
			}
			if (e.getKeyChar() =='s') {
				down1 = true;
			}
			// turn 1-player mode on
			if (e.getKeyChar() == '1') {
				ai = true;
			}	
			// turn 2-player mode on
			if (e.getKeyChar() == '2') {
				ai = false;
				up1 = false;
				down1 =false;
				
			}
			// if the player presses r this makes the ball move again at a random speed/direction 
			if (e.getKeyChar() == 'r') {
				ballspeedx = (int)(Math.random()*speedrange + speedmin); //add random
				ballspeedy = (int)(Math.random()*speedrange + speedmin); //add random
				if (generateRandom(2, 0) == 1) {
					ballspeedx = -ballspeedx;
						ballspeedy = -ballspeedy;
				resetmessage = false;
				}
			}
		}
		
		// defines what we want to happen if a keyboard button
		// has been released - you need to complete this
		public void keyReleased(KeyEvent e) {
			
			int keyCode = e.getKeyCode();
			
			// stops paddle motion based on which button is released
			if (keyCode == KeyEvent.VK_UP) 
				up2 = false;

			if (keyCode == KeyEvent.VK_DOWN) 
				down2 = false;
	  
			if(e.getKeyChar() == 'w')
				up1 = false;
			
			if (e.getKeyChar() == 's')
				down1 = false;

		}
		
		// restarts the game, including scores, bringing the paddles to their original position and bringing the ball to center
		public void restart() {
			score1 = 0;
			score2 = 0;
			
			ballx = 300;
			bally = 400;
			ballspeedx = 0;
			ballspeedy= 0;
			
			paddle1x = 0;
			paddle1y = 300;
			paddle2x = 580;
			paddle2y = 300;
			
			
		}

		//////////////////////////////////////
		//////////////////////////////////////
		
		// DON'T TOUCH THE BELOW CODE
		
		
		// this method runs the actual game.
		public void run() {

			// while(true) should rarely be used to avoid infinite loops, but here it is ok because
			// closing the graphics window will end the program
			while (true) {
		
				// draws the game
				repaint();
				
				// we move the ball, paddle, and check for collisions
				// every hundredth of a second
				move_ball();
				move_paddles();
				check_collisions();
				black_hole();
				ai();
				
				//rests for a hundredth of a second
				try {
					Thread.sleep(10);
				} catch (Exception ex) {}
			}
		}
		
		// very simple main method to get the game going
		public static void main(String[] args) {
			new Pong();
		}
	 
		// does complicated stuff to initialize the graphics and key listeners
		// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
		// GRAPHICS!
		public Pong() {
			JFrame frame = new JFrame();
			JButton button = new JButton("restart");
			frame.setSize(WIDTH, WINDOW_HEIGHT);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(this);
			frame.add(button, BorderLayout.SOUTH);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setVisible(true);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					restart();
					Pong.this.requestFocus();
				}
			});
			this.addKeyListener(this);
			this.setFocusable(true);
			
			run();
		}
		
		// method does nothing
		public void keyTyped(KeyEvent e) {}
	}

