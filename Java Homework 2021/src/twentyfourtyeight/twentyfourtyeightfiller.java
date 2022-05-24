package twentyfourtyeight;

	// Space Invaders Filler Code by Mr. David, edited to make work for 2048
    //By Marianne Lyons

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
		
		// constants for the board and tile dimensions
		private final int WIDTH = 700, HEIGHT = 700,
						 GRIDCOLUMNS = 4, GRIDROWS = 4, GRIDWIDTH = (WIDTH/35), GRIDHEIGHT = (HEIGHT/35);
		private final int  TILEWIDTH = (WIDTH/4), TILEHEIGHT = (HEIGHT/4);

		//list of Tiles		
		Tile [][] tiles =  new Tile [GRIDCOLUMNS][GRIDROWS];
		
		// booleans to keep track of the game's progress
		private boolean lost = false, full = true, blocked = true;
		private boolean won = false;


		// checks if the player has won or lost the game
		public void checkWin() {	
			
			blocked = false;
			//checks if there are possible moves for the board or if it is "blocked"
			//goes through all the tiles
			for(int i = 0; i < GRIDROWS; i++) {
				for(int j = 0; j < GRIDCOLUMNS; j++) {
					if(tiles[j][i] != null) { 
						//makes sure there is no out of bounds exception
						try {
							//checks if the tile below the current tile doesnt equal the current tiles value
							if(tiles[j+1][i] != null && tiles[j][i].GetValue() != tiles[j+1][i].GetValue()) {
								//if so blocked is still true
								blocked = true;
							}
						}
						catch(ArrayIndexOutOfBoundsException e) {
								
						}
						//makes sure there is no out of bounds exception	
						try {
							//checks if the tile to the right of the current tile doesnt equal the current tiles value
							if(tiles[j][i+1] != null && tiles[j][i].GetValue() != tiles[j][i+1].GetValue()) {
								//if so blocked is still true
								blocked = true;
							}
						}
						catch(ArrayIndexOutOfBoundsException e) {
								
						}
						//makes sure there is no out of bounds exception	
						try {
							//checks if the tile above the current tile doesnt equal the current tiles value
							if(tiles[j-1][i] != null && tiles[j][i].GetValue() != tiles[j-1][i].GetValue()) {
								//if so blocked is still true
								blocked = true;
							}
						}
						catch(ArrayIndexOutOfBoundsException e) {
									
						}
						//makes sure there is no out of bounds exception	
						try {
							//checks if the tile to the right of the current tile doesnt equal the current tiles value
							if(tiles[j][i-1] != null && tiles[j][i].GetValue() != tiles[j][i-1].GetValue()) {
								//if so blocked is still true
								blocked = true;
							}
						}
						catch(ArrayIndexOutOfBoundsException e) {
								
						}
					}
						
				}
			}

			//checks if the board if full (all the spots have tiles)
			full = true;
			//goes through all the tiles
			for(int i = 0; i < GRIDROWS; i++) {
				for(int j = 0; j < GRIDCOLUMNS; j++) {
					//checks if it is empty
					if(tiles[j][i] == null) {
						//if so the board is not full
						full = false;
					}
				}
			}
			
			//checks if blocked and full are true...
			if(blocked == true && full == true) {
				//in which case the player has lost
				lost = true;
			}
			
			//goes through all the tiles
			for(int i = 0; i < GRIDROWS; i++) {
				for(int j = 0; j < GRIDCOLUMNS; j++) {
					if(tiles[j][i] != null) {
						//checks if any tile is 2048
						if(tiles[j][i].GetValue() == 2048) {
							//if so the play has won!!
							won = true;
						}
					}
				}
			}
		}
			
		
		//draws the starting board
		public void setup() {
			int count = 0;
			//draws two 2 tiles on random spots on the board
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
			//fills ion the background color gray
			g.setColor(new Color(237, 237, 223));
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			//draws the dark gray grid columns
			for(int i = 0; i < GRIDCOLUMNS+1; i++) {
				g.setColor(Color.GRAY);
				g.fillRect(0, TILEHEIGHT * i, WIDTH, GRIDHEIGHT);
			}
			//draws the dark gray grid rows
			for(int i = 0; i < GRIDROWS+1; i++) {
				g.setColor(Color.GRAY);
				//draws rows +40 accounts for java graphics error
				g.fillRect(TILEWIDTH * i, 0, GRIDWIDTH, HEIGHT+40);
			}
			//goes through the tile list
			for(int i = 0; i < GRIDCOLUMNS; i++) {
				for(int j = 0; j < GRIDROWS; j++) {
					if(tiles[j][i] != null) {
						//draws the tile if it isnt susposed to be empty
						tiles[j][i].draw(g);
					}
				}
			}
			
			
			g.setColor(Color.red);
			//if the player has lost
			if (lost) {
				//clears the board
				for(int i = 0; i < GRIDROWS; i++) {
					for(int j = 0; j < GRIDCOLUMNS; j++) {
						tiles[j][i] = null;
					}
				}
				//draws "you lose" in the center of the board
				g.drawString("You lose", WIDTH/2-25, HEIGHT/2);
			}
			//if the player has won
			if (won) {
				//clears the board
				for(int i = 0; i < GRIDROWS; i++) {
					for(int j = 0; j < GRIDCOLUMNS; j++) {
						tiles[j][i] = null;
					}
				}
				//draws "you win" in the center of the board
				g.drawString("You win!", WIDTH/2-25, HEIGHT/2);
			}
		}
		
		
		//FILLER
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
					checkWin();
					frame.getContentPane().repaint();
				try {Thread.sleep(20);} 
				catch (InterruptedException e) {}
			}
		}
		
		//all below classes make the tiles move
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
