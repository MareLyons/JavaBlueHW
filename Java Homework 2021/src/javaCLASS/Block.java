package javaCLASS;

import java.awt.Graphics;
import java.awt.Color;

public class Block{
	
private int x, y, speed;
private Color color;


//	Create a Block class. This class should hold 4 instance variables - x, y, color, and speed. 
//	The class should have at least 3 methods: a constructor, draw(Graphics g), and move(). I'll 
//	let you figure out what these methods should do. 


	public Block(int x, int y, Color color, int speed) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.speed = speed;
	
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, 6, 6);
	}
	
	public void move() {
		y += speed;
	}
	
	public int getY(){
		return(y);
	}
	

}
