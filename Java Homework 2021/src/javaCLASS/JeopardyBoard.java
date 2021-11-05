// Marianne Lyons
// November 5, 2021
// This code draws a Jeparody board that adds to your score
// when you click the corresponding rectangle, and turns the 
// score on that rectangle red until you press another score
package javaCLASS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JeopardyBoard{
	
	private static final String Graphics = null;
	
	// variables for the grid dimensions
	public int gridWidth = 800, gridHeight = 600, textHeight = 50;
	
	// how many questions(rows) and columns (categories) we want to have
	private final int NUMQUESTIONS = 6, NUMCATEGORIES = 5;
	
	// variable for score
	private int score = 0;
	
	//variables for rectangle dimensions and positions
	private int rectanglewidth = gridWidth/NUMCATEGORIES;
	private int rectangleheight = gridHeight/NUMQUESTIONS;
	private int rectanglex = 0;
	private int rectangley = 0;

	//varaibles to track mouse position
	private int clickedX = -1;
	private int clickedY = -1;
	

	//Draws Jeparody Board
	public void draw(Graphics g) {
		//variable for answer score on rectangles
		int answerscore = 200;
		//resets the rectangle, so that the screen is rescaleable
		rectanglewidth = gridWidth/NUMCATEGORIES;
		rectangleheight = gridHeight/NUMQUESTIONS;
		rectanglex = 0;
		rectangley = 0;
		
		//counts the rows
		for(int i = 0; i < NUMQUESTIONS; i++) {
			//counts and draws the columns
			for (int j = 0; j < NUMCATEGORIES; j++){
				// draws the teal rectangle with a dark blue outline
				g.setColor(new Color(191, 137, 0));
				g.drawRect(rectanglex, rectangley, rectanglewidth, rectangleheight);
				g.setColor(new Color(245, 228, 184));
				g.fillRect(rectanglex, rectangley, rectanglewidth, rectangleheight);
				// ensures that the answer score number is always in the center of the rectangle
				// draws the answer score number 
				//sets text color to dark blue
				g.setColor(new Color(191, 137, 0));
				//sets text color of clicked rectangle to red
				if(clickedX > rectanglex && clickedX < rectanglex + rectanglewidth && clickedY > rectangley && clickedY < rectangley + rectangleheight) {
					g.setColor(new Color(255, 0, 0));
				}
				//draws the answer score text
				int labely = (int)(rectangley + (.5) * (rectangleheight));
				int labelx = (int)(rectanglex + (.5) * (rectanglewidth));
				g.drawString(Integer.toString(answerscore), labelx, labely);
				//adds to rectanglex so the rectangles draw across the screen
				rectanglex += rectanglewidth;	
			}
			//adds 200 to the answer score number, for the next row 
			answerscore += 200;
			//resets x to draw a new row
			rectanglex = 0;
			//adds to rectangle y to draw a new row
			rectangley += rectangleheight;
			
		}
	}
		
	
	//adds to score 
	public void click(int mouseX, int mouseY) {
		//tracks mouse movement, used in draw to make the text red
		clickedX = mouseX;
		clickedY = mouseY;
		//adds 200 to score if they click on the 200 row
		if (mouseY<rectangleheight) {
			score += 200;
		}
		//adds 400 to score if they click on the 400 row
		if (mouseY>rectangleheight && mouseY<2*(rectangleheight)) {
			score += 400;
		}
		//adds 600 to score if they click on the 600 row
		if (mouseY>2*(rectangleheight) && mouseY<3*(rectangleheight)) {
			score += 600;
		}
		//adds 800 to score if they click on the 800 row
		if (mouseY>3*(rectangleheight) && mouseY<4*(rectangleheight)) {
			score += 800;
		}
		//adds 1000 to score if they click on the 1000 row
		if (mouseY>4*(rectangleheight) && mouseY<5*(rectangleheight)) {
			score += 1000;
		}
		//adds 1200 to score if they click on the 1200 row
		if (mouseY>5*(rectangleheight) && mouseY<6*(rectangleheight)) {
			score += 1200;
		}
		
	}
	

	// DO NOT TOUCH BELOW CODE //
	
	public JeopardyBoard() {

		
		JFrame window = new JFrame();
		window.setTitle("Jeopardy!");
		window.setSize(gridWidth, gridHeight + textHeight);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		JTextArea scoreDisplay = new JTextArea();
		scoreDisplay.setEditable(false);
		scoreDisplay.setText("\t\tScore: 0");
		
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {
				gridWidth = window.getWidth();
				gridHeight = window.getHeight() - textHeight;
				draw(g);
			}
		};
		canvas.setPreferredSize(new Dimension(gridWidth, gridHeight));
		
		canvas.addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				click(e.getX(), e.getY());
				scoreDisplay.setText("\t\tScore: " + score);
				window.getContentPane().repaint();
			}

			@Override
			public void mouseClicked(MouseEvent e) {}


			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		container.add(canvas);
		container.add(scoreDisplay);
		window.add(container);
		window.setVisible(true);
	}
		public static void main(String[] args) {
			new JeopardyBoard();
}

}
	





