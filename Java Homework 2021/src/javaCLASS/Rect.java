package javaCLASS;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends Shape {

	private int width;
	private int height;
	
	public Rect(int startx, int starty, int width, int height) {
		super(startx, starty);
		this.height = height;
		this.width = width;
	
	}

	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(height, width, getX(), getY());
		g.fillRect(height, width, getX(), getY());
	}
}
