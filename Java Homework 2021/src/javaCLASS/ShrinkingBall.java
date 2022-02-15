package javaCLASS;

import java.awt.Color;

public class ShrinkingBall extends BouncingBall{

	private int movecount = 0;
	
	public ShrinkingBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}
	public void move(){
		movecount++;
		super.move();
		
		if (movecount > 50) {
			setRad(getRad()-1); 
			movecount = 0;
		}
		if(getRad()<5) {
			setRad(5); 
		}
	}
}
