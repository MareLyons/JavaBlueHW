package twentyfourtyeight;

	// Space Invaders Filler Code by Mr. David, edited to make work for 2048

	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.event.ActionEvent;
	import java.awt.event.KeyEvent;
	import java.util.ArrayList;
	import javax.swing.AbstractAction;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.KeyStroke;


	public class twentyfourtyeightfiller {
		
		// constants for various aspects of the game
		// feel free to change them to make the game harder/easier
		private final int WIDTH = 700, HEIGHT = 700,
						 GRIDCOLUMNS = 4, GRIDROWS = 4, GRIDWIDTH = (WIDTH/35), GRIDHEIGHT = (HEIGHT/35);
		private final int  TILEWIDTH = (WIDTH/4), TILEHEIGHT = (HEIGHT/4);
		
		
		// our list of Tiles		
		Tile [][] tiles =  new Tile [GRIDCOLUMNS][GRIDROWS];
		
		// booleans to keep track of the game's progress
		private boolean lost = false, full = true, blocked;
		private boolean won = false;

		
		// move the aliens, the lasers, and the player. Loops aliens when necessary, 
		// and randomly shoots lasers from the aliens
		public void move() {
		}
	
		
		// check for collisions between alien lasers and the player
		// and between player lasers and the aliens
		// check if the aliens have reached the ground
		public void checkWin() {	
			
			blocked = false;

				for(int i = 0; i < GRIDROWS; i++) {
					for(int j = 0; j < GRIDCOLUMNS; j++) {
						if(tiles[j][i] != null) { 
							try {
								if(tiles[j+1][i] != null && tiles[j][i].GetValue() != tiles[j+1][i].GetValue()) {
									blocked = true;
								}
							}
							catch(ArrayIndexOutOfBoundsException e) {
								
							}
							
							try {
								if(tiles[j][i+1] != null && tiles[j][i].GetValue() != tiles[j][i+1].GetValue()) {
									blocked = true;
								}
							}
							catch(ArrayIndexOutOfBoundsException e) {
								
							}
							
							try {
								if(tiles[j-1][i] != null && tiles[j][i].GetValue() != tiles[j-1][i].GetValue()) {
									blocked = true;
								}
							}
							catch(ArrayIndexOutOfBoundsException e) {
									
							}
							
							try {
								if(tiles[j][i-1] != null && tiles[j][i].GetValue() != tiles[j][i-1].GetValue()) {
									blocked = true;
								}
							}
							catch(ArrayIndexOutOfBoundsException e) {
								
							}
						}
						
					}
				}

			
			
			full = true;
			for(int i = 0; i < GRIDROWS; i++) {
				for(int j = 0; j < GRIDCOLUMNS; j++) {
					if(tiles[j][i] == null) {
						full = false;
					}
				}
			}
			
	
			if(blocked == true && full == true) {
				lost = true;
			}
			
			for(int i = 0; i < GRIDROWS; i++) {
				for(int j = 0; j < GRIDCOLUMNS; j++) {
					if(tiles[j][i] != null) {
						if(tiles[j][i].GetValue() == 2048) {
							won = true;
						}
					}
				}
			}

		}
			
		
		// set up your variables, lists, etc here
		public void setup() {
			int count = 0;
			while(count < 2) {
				int randomx = (int) (Math.random()*4 + 0);
				int randomy = (int) (Math.random()*4 + 0);
				if(tiles[randomy][randomx] == null) {
					tiles[randomy][randomx] = (new Tile((randomx * TILEWIDTH)+GRIDWIDTH , (randomy * TILEHEIGHT)+GRIDHEIGHT,TILEWIDTH-GRIDHEIGHT,TILEHEIGHT-GRIDHEIGHT, "Images/2.png", 2,0,0));
					count++;
				}
			}	
		}
		
		
		// draw a black background along with your lasers, aliens, and player here
		public void draw(Graphics g) {
			g.setColor(new Color(237, 237, 223));
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			// your code here
			for(int i = 0; i < GRIDCOLUMNS+1; i++) {
				g.setColor(Color.GRAY);
				g.fillRect(0, TILEHEIGHT * i, WIDTH, GRIDHEIGHT);
			}
			for(int i = 0; i < GRIDROWS+1; i++) {
				g.setColor(Color.GRAY);
				//Draws rectangle +40 accounts for java error
				g.fillRect(TILEWIDTH * i, 0, GRIDWIDTH, HEIGHT+40);
			}
			
			for(int i = 0; i < GRIDCOLUMNS; i++) {
				for(int j = 0; j < GRIDROWS; j++) {
					if(tiles[j][i] != null) {
						tiles[j][i].draw(g);
					}
				}
			}
			
			
			g.setColor(Color.blue);
			if (lost) {
				for(int i = 0; i < GRIDROWS; i++) {
					for(int j = 0; j < GRIDCOLUMNS; j++) {
						tiles[j][i] = null;
					}
				}
				g.drawString("You lose", WIDTH/2-25, HEIGHT/2);
			}
			if (won) {
				for(int i = 0; i < GRIDROWS; i++) {
					for(int j = 0; j < GRIDCOLUMNS; j++) {
						tiles[j][i] = null;
					}
				}
				g.drawString("You win!", WIDTH/2-25, HEIGHT/2);
			}
		}
		
		// ******* DON'T TOUCH BELOW CODE ************//
		
		public twentyfourtyeightfiller() {
			setup();
			JFrame frame = new JFrame();
			frame.setSize(WIDTH+20, HEIGHT+40);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel canvas = new JPanel() {
				public void paint(Graphics g) {draw(g);}
			};
			canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Left");
			canvas.getActionMap().put("Left", new LeftAction());
			
			canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Right");
			canvas.getActionMap().put("Right", new RightAction());

			
			canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "Up");
			canvas.getActionMap().put("Up", new UpAction());
			
			canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "Down");
			canvas.getActionMap().put("Down", new DownAction());
			
			frame.add(canvas);
			frame.setVisible(true);
			
			while (true) {
					move();
					checkWin();
					frame.getContentPane().repaint();
				try {Thread.sleep(20);} 
				catch (InterruptedException e) {}
			}
		}
		
		//makes the tiles move right when the user presses the right arrow, and combine if they reach an equal value tile
		private class RightAction extends AbstractAction {
			public void actionPerformed(ActionEvent e) {
				//goes through the tiles 
				for(int i = GRIDROWS-1; i >= 0; i--) {
					for(int j = 0; j < GRIDCOLUMNS; j++) {
						//checks if the tile isnt empty or if it isnt on the edge of the board
						if(tiles[j][i] != null && i != 3) {
							//if thats true goes through the tiles rowwise, starting all the way right
							for(int w = GRIDROWS-1; w > i; w--) {
								//if the tile in the row is empty...
								if(tiles[j][w] == null) {
									//moves the current tile to that empty spot
									tiles[j][w] = tiles[j][i];
									tiles[j][w].x = (TILEWIDTH * w)+(GRIDWIDTH);
									//makes where the tile was null
									tiles[j][i] = null;
									break;
								}
								//if the tile in the row isnt empty, but its equal to the current tiles value...
								else if(tiles[j][w] != null && tiles[j][w].GetValue() == tiles[j][i].GetValue()){
									//combines the tiles to make them equal to the next largest tile (their sum)
									tiles[j][w] = (new Tile(tiles[j][w].x, tiles[j][w].y,TILEWIDTH-GRIDHEIGHT,TILEHEIGHT-GRIDHEIGHT, "Images/" + 2*tiles[j][i].GetValue()+".png", (2*tiles[j][i].GetValue()),0,0));
									//makes where the tile was null
									tiles[j][i] = null;
									break;
								}
							}
						}
					}
				}
				//after the tiles have been moved this spawns a new 2 tile
				int randomx = (int) (Math.random()*4 + 0);
				int randomy = (int) (Math.random()*4 + 0);
				if(tiles[randomy][randomx] == null) {
					tiles[randomy][randomx] = (new Tile((randomx * TILEWIDTH)+GRIDWIDTH , (randomy * TILEHEIGHT)+GRIDHEIGHT,TILEWIDTH-GRIDHEIGHT,TILEHEIGHT-GRIDHEIGHT, "Images/2.png", 2,0,0));
				}
			}
		}

		//makes the tiles move left when the user presses the left arrow, and combine if they reach an equal value tile
		private class LeftAction extends AbstractAction {
			public void actionPerformed(ActionEvent e) {
				//goes through the tiles 
				for(int i = 0; i < GRIDROWS; i++) {
					for(int j = 0; j < GRIDCOLUMNS; j++) {
						//checks if the tile isnt empty or if it isnt on the edge of the board
						if(tiles[j][i] != null && i != 0) {
							//if thats true goes through the tiles rowwise, starting all the way right
							for(int w = 0; w < i; w++) {
								//if the tile in the row is empty...
								if(tiles[j][w] == null) {
									//moves the current tile to that empty spot
									tiles[j][w] = tiles[j][i];
									tiles[j][w].x = (TILEWIDTH * w)+(GRIDWIDTH);
									//makes where the tile was null
									tiles[j][i] = null;
									break;
								}
								//if the tile in the row isnt empty, but its equal to the current tiles value...
								else if(tiles[j][w] != null && tiles[j][w].GetValue() == tiles[j][i].GetValue()){
									//combines the tiles to make them equal to the next largest tile (their sum)
									tiles[j][w] = (new Tile(tiles[j][w].x, tiles[j][w].y,TILEWIDTH-GRIDHEIGHT,TILEHEIGHT-GRIDHEIGHT, "Images/" + 2*tiles[j][i].GetValue()+".png", 2*tiles[j][i].GetValue(),0,0));
									//makes where the tile was null
									tiles[j][i] = null;
									break;
								}
							}
						}
					}
				}
				//after the tiles have been moved this spawns a new 2 tile
				int randomx = (int) (Math.random()*4 + 0);
				int randomy = (int) (Math.random()*4 + 0);
				if(tiles[randomy][randomx] == null) {
					tiles[randomy][randomx] = (new Tile((randomx * TILEWIDTH)+GRIDWIDTH , (randomy * TILEHEIGHT)+GRIDHEIGHT,TILEWIDTH-GRIDHEIGHT,TILEHEIGHT-GRIDHEIGHT, "Images/2.png", 2,0,0));
				}
			}
		}
		
		//makes the tiles move up when the user presses the up arrow, and combine if they reach an equal value tile
		private class UpAction extends AbstractAction {
			public void actionPerformed(ActionEvent e) {
				//goes through the tiles 
				for(int i = 0; i < GRIDROWS; i++) {
					for(int j = 0; j < GRIDROWS; j++) {
						//checks if the tile isnt empty or if it isnt on the edge of the board
						if(tiles[j][i] != null && j != 0) {
							//if thats true goes through the tiles columnwise, starting all the way right
							for(int w = 0; w < j; w++) {	
								//if the tile in the column is empty...
								if(tiles[w][i] == null) {
									//moves the current tile to that empty spot
									tiles[w][i] = tiles[j][i];
									tiles[w][i].y = (TILEWIDTH * w)+GRIDWIDTH;
									//makes where the tile was null
									tiles[j][i] = null;
									break;
								}
								//if the tile in the column isnt empty, but its equal to the current tiles value...
								else if(tiles[w][i] != null && tiles[w][i].GetValue() == tiles[j][i].GetValue()){
									//combines the tiles to make them equal to the next largest tile (their sum)
									tiles[w][i] = (new Tile(tiles[w][i].x, tiles[w][i].y,TILEWIDTH-GRIDHEIGHT,TILEHEIGHT-GRIDHEIGHT, "Images/" + 2*tiles[j][i].GetValue()+".png", 2*tiles[j][i].GetValue(),0,0));
									//makes where the tile was null
									tiles[j][i] = null;
									break;
								}
							}
						}
					}
				}
				//after the tiles have been moved this spawns a new 2 tile
				int randomx = (int) (Math.random()*4 + 0);
				int randomy = (int) (Math.random()*4 + 0);
				if(tiles[randomy][randomx] == null) {
					tiles[randomy][randomx] = (new Tile((randomx * TILEWIDTH)+GRIDWIDTH , (randomy * TILEHEIGHT)+GRIDHEIGHT,TILEWIDTH-GRIDHEIGHT,TILEHEIGHT-GRIDHEIGHT, "Images/2.png", 2,0,0));
				}

			}
		}
		
		//makes the tiles move down when the user presses the down arrow, and combine if they reach an equal value tile
		private class DownAction extends AbstractAction {
			public void actionPerformed(ActionEvent e) {
				//goes through the tiles 
				for(int i = 0; i < GRIDROWS; i++) {
					for(int j = GRIDCOLUMNS-1; j >= 0; j--) {
						//checks if the tile isnt empty or if it isnt on the edge of the board
						if(tiles[j][i] != null && j != 3) {
							//if thats true goes through the tiles columnwise, starting all the way right
							for(int w = GRIDROWS-1; w > j; w--){	
								//if the tile in the column is empty...
								if(tiles[w][i] == null) {
									//moves the current tile to that empty spot
									tiles[w][i] = tiles[j][i];
									tiles[w][i].y = (TILEWIDTH * w)+GRIDWIDTH;
									//makes where the tile was null
									tiles[j][i] = null;
									break;
								}
								//if the tile in the column isnt empty, but its equal to the current tiles value...
								else if(tiles[w][i] != null && tiles[w][i].GetValue() == tiles[j][i].GetValue()){
									//combines the tiles to make them equal to the next largest tile (their sum)
									tiles[w][i] = (new Tile(tiles[w][i].x, tiles[w][i].y,TILEWIDTH-GRIDHEIGHT,TILEHEIGHT-GRIDHEIGHT, "Images/" + 2*tiles[j][i].GetValue()+".png", 2*tiles[j][i].GetValue(),0,0));
									//makes where the tile was null
									tiles[j][i] = null;
									break;
								}
							}
						}
					}
				}
				//after the tiles have been moved this spawns a new 2 tile
				int randomx = (int) (Math.random()*4 + 0);
				int randomy = (int) (Math.random()*4 + 0);
				if(tiles[randomy][randomx] == null) {
					tiles[randomy][randomx] = (new Tile((randomx * TILEWIDTH)+GRIDWIDTH , (randomy * TILEHEIGHT)+GRIDHEIGHT,TILEWIDTH-GRIDHEIGHT,TILEHEIGHT-GRIDHEIGHT, "Images/2.png", 2,0,0));
				}
			}
		}

		public static void main(String[] args) {
			new twentyfourtyeightfiller();
		}
	
}
