package javaCLASS;

import java.awt.Color;
import java.awt.Graphics;

public class Polygon extends Shape{

	private int arcWidth, arcHeight;
	private int width, height;
	
	public Polygon(int startx, int starty, int arcWidth, int arcHeight, int height, int width) {
		super(startx, starty);
		this.arcWidth = arcWidth;
		this.arcHeight = arcHeight;
		this.height = height;
		this.width = width;
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRoundRect(getX(), getY(), width, height, arcWidth, arcHeight);
		g.fillRoundRect(getX(), getY(), width, height, arcWidth, arcHeight);

	}
}

