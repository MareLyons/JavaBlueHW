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
		private final int WIDTH = 700, HEIGHT = 700, TILESPEEDX = 10,TILESPEEDY = 10,
						 GRIDCOLUMNS = 4, GRIDROWS = 4, GRIDWIDTH = (WIDTH/35), GRIDHEIGHT = (HEIGHT/35);
		private final int  TILEWIDTH = (WIDTH/4), TILEHEIGHT = (HEIGHT/4);
		
		
		// our list of Tiles		
		Tile [][] tiles =  new Tile [GRIDCOLUMNS][GRIDROWS];
		
		// booleans to keep track of the game's progress
		private boolean lost = false;
		private boolean won = false;
		
		private boolean right = false, left = false, up = false, down = false;
		
		
		// move the aliens, the lasers, and the player. Loops aliens when necessary, 
		// and randomly shoots lasers from the aliens
		public void move() {
					
						
						
						
						

////							if(noleft == false) {
//								tiles[j][i].setSpeedX(0);
//								System.out.println("stopped left");
//							}
//							noleft = true;
////							noright = false;
//						}
////							if(noright == false) {
////								tiles[j][i].setSpeedX(0);
////								System.out.println("stopped right");
////							}
////							noright = true;
////							noleft = false;
//						}
////							if(noup == false) {
////								tiles[j][i].setSpeedY(0);
////								System.out.println("stopped up");
////							}
////							noup = true;
////							nodown = false;
//						}
////							if(nodown == false) {
//								tiles[j][i].setSpeedY(0);
//								System.out.println("stopped down");
//								
//							}
//							nodown = true;
//							noup = false;
//						}
//						tiles[j][i].moveX(tiles[j][i].getSpeedX());
//						tiles[j][i].moveY(tiles[j][i].getSpeedY());
		}
	
		
		// check for collisions between alien lasers and the player
		// and between player lasers and the aliens
		// check if the aliens have reached the ground
		public void checkCollisions() {
			
			
			
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
		
		// fires a player laser. if there are currently less than 4 lasers on the screen,
		// adds to the list. if there are 4 lasers on the screen, removes a laser and 
		// replaces it with this new one
		public void fireLaser() {
			
			// your code here
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
			if (lost) 
				g.drawString("You lose", WIDTH/2-25, HEIGHT/2);
			if (won) 
				g.drawString("You win!", WIDTH/2-25, HEIGHT/2);
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
					checkCollisions();
					frame.getContentPane().repaint();
				try {Thread.sleep(20);} 
				catch (InterruptedException e) {}
			}
		}
		
		private class RightAction extends AbstractAction {
			public void actionPerformed(ActionEvent e) {
				for(int i = GRIDROWS; i >= 0; i--) {
					for(int j = 0; j <= GRIDCOLUMNS; j++) {
						if(tiles[j][i] != null) {
							tiles[j][i] = tiles[j][GRIDROWS];	
						}
					}
				}
//				if(noright == false) {
//					for(int i = 0; i < GRIDCOLUMNS; i++) {
//						for(int j = 0; j < GRIDROWS; j++) {
//							if(tiles[j][i] != null) {
//								tiles[j][i].setSpeedX(TILESPEEDX);
//								System.out.print("nay");
//							}
//						}
//					}
//				}
			}
		}
		
		private class LeftAction extends AbstractAction {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i <= GRIDROWS; i++) {
					for(int j = 0; j <= GRIDCOLUMNS; j++) {
						if(tiles[j][i] != null) {
							tiles[j][i] = tiles[j][0+i];
						}
					}
				}
//				if(noleft == false) {
//					for(int i = 0; i < GRIDCOLUMNS; i++) {
//						for(int j = 0; j < GRIDROWS; j++) {
//							if(tiles[j][i] != null) {
//								tiles[j][i].setSpeedX(-TILESPEEDX);
//								System.out.print("okay");
//							}
//						}
//					}
//				}
			}
		}
		
		private class UpAction extends AbstractAction {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i <= GRIDROWS; i++) {
					for(int j = 0; j <= GRIDCOLUMNS; j++) {
						if(tiles[j][i] != null) {
							tiles[j][i] = tiles[0+j][i];
						}
					}
				}

//				if(noup == false) {
//					for(int i = 0; i < GRIDCOLUMNS; i++) {
//						for(int j = 0; j < GRIDROWS; j++) {
//							if(tiles[j][i] != null) {
//								tiles[j][i].setSpeedY(-TILESPEEDY);
//								System.out.print("yay");
//							}
//						}
//					}
//				}
			}
		}
		
		private class DownAction extends AbstractAction {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hi");
				for(int i = 0; i <= GRIDROWS-1; i++) {
					System.out.println(i + "i");

					for(int j = GRIDCOLUMNS-1; j >= 0; j--) {
						System.out.println(j+ "j");
						if(tiles[j][i] != null)
							for(int w = GRIDROWS-1; w >= 0; w--) {	
								System.out.println(w + "w");

							if(tiles[w][i] == null) {
								tiles[w][i] = tiles[j][i];
								tiles[j][i] = null;
								break;
							}
						}
					}
				}
			}
//				if(nodown == false) {
//					for(int i = 0; i < GRIDCOLUMNS; i++) {
//						for(int j = 0; j < GRIDROWS; j++) {
//							if(tiles[j][i] != null) {
//								tiles[j][i].setSpeedY(TILESPEEDY);
//								System.out.print("wooo");
//							}
//						}
//					}
//				}
//			}
		}

		public static void main(String[] args) {
			new twentyfourtyeightfiller();
		}
	
}
