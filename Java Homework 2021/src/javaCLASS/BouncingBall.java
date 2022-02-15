package javaCLASS;

import java.awt.Color;

public class BouncingBall extends Ball{

	public BouncingBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super(startx, starty, startrad, startxspeed, startyspeed, startcolor);

	
	}
	public void move(){
		super.move();
		if(getX() > WIDTH-getRad()) {
			setXSpeed(getXSpeed() * -1);
		}
		else if(getX() < 0){
			setXSpeed(getXSpeed() * -1);
		}
		if(getY() > HEIGHT-getRad()) {
			setYSpeed(getYSpeed() * -1);
		}
		else if(getY() < 0) {
			setYSpeed(getYSpeed() * -1);
		}
	}
}
