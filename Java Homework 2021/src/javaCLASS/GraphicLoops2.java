package javaCLASS;
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

	public class GraphicLoops2 extends JPanel {
		
		// constants that are predefined and won't change as the program runs
		private final int WIDTH = 1000, HEIGHT = 590;


		// defines what we want to happen anytime we draw the graphics
		public void paint(Graphics g) {
			
			// background color is gray
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			// call your methods here
			
			drawBall(g,10);
			growingCircles(g);
			tenByTenCircles(g);
			drawCheckerboard(g);
			
			
		}
		// defines what we want to happen anytime we draw the graphics
		public void drawBall(Graphics g, int n) {	
			g.setColor(Color.red);
			for(int i = 0; i < n; i++) {
					g.fillOval(i*20, 500, 10, 10);
				}
					}
		//constant			
		public void tenByTenCircles(Graphics g) {
			g.setColor(Color.blue);
			for(int i = 0; i < 200; i+=20) {
				for(int j = 0; j < 200; j+=20) {
				    g.fillOval(i, j, 20, 20);
		
				}
			}
				
			}	
		
		public void growingCircles(Graphics g) {
			g.setColor(Color.blue);
			for(int i = 0, r = 3; i < 30; i++) {
				g.fillOval(i*35, 300, r, r);
				if (i>15) 
					r-=2;
				else 
					r+=2;		
				}
			}
				
		//constant			
		public void drawCheckerboard(Graphics g) {
			for(int i = 0; i <= 20; i++) {
				g.setColor(Color.red);
				g.fillRect(i*20, 220, 10, 100);
				for(int j = 0; j <= 20; j++) {
				    g.fillRect(300, j*20, 100, 10);
		
				}
			}
				
			}	
		

		
	

		//////////////////////////////////////
		//////////////////////////////////////
		
		// DON'T TOUCH THE BELOW CODE
		
		
		// this method runs the actual program.
		public void run() {

			// while(true) should rarely be used to avoid infinite loops, but here it is ok because
			// closing the graphics window will end the program
			while (true) {
		
				// draws
				//repaint();
				
				//rests for a hundredth of a second
				try {
					Thread.sleep(10);
				} catch (Exception ex) {}
			}
		}
		
		// very simple main method to get the game going
		public static void main(String[] args) {
			new GraphicLoops2();
		}
	 
		// does complicated stuff to initialize the graphics and key listeners
		// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
		// GRAPHICS!
		public GraphicLoops2() {
			JFrame frame = new JFrame();
			frame.setSize(WIDTH, HEIGHT);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(this);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setVisible(true);
			this.setFocusable(true);
			
			run();
		}
	}


