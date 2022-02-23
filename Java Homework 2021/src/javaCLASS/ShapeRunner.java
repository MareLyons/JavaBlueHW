package javaCLASS;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import pokemon.Dratini;
import pokemon.Mareep;
import pokemon.Mew;
import pokemon.Pokemon;

public class ShapeRunner {
	
	private Shape[] shapes;
	
	// this method should move all the shapes in the list
	public void moveShapes() {
		
		for(int i = 0; i < shapes.length; i++) {
			shapes[i].move(3,3);
		}
	}
	
	// fill in your shape list here
	public void setup() {
		
		shapes = new Shape[] {new Rect(50,50,50,50), new Oval(20, 20, 30, 30), new Polygon(300, 300, 5, 5, 40, 40)};

	}
	
	// DON'T TOUCH BELOW CODE
	
	public void run() {
		while (true ) {
			moveShapes();
			frame.repaint();
			try {
				Thread.sleep(75);
			} catch (Exception ex) {}
		}
	}
	
	public static void main(String[] args) {
		new ShapeRunner(); 
	}
	private JFrame frame;
	public ShapeRunner() {
		setup();
		frame = new JFrame() {
			public void paint(Graphics g) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, 600, 600);
				
				for (Shape s: shapes)
					s.draw(g);
			}
		};
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		run();
	}
}