package javaCLASS;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Shape{
	
	private int width;
	private int height;
	
	public Oval(int startx, int starty, int width, int height) {
		super(startx, starty);
		this.height = height;
		this.width = width;
	}

	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawOval(height, width, getX(), getY());	
		g.fillOval(height, width, getX(), getY());
	}
}

