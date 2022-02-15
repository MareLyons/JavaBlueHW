package javaCLASS;
import java.awt.Color;

public class ColorChangingBall extends BouncingBall{
	
	private int movecount = 0;
	
	public ColorChangingBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super(startx, starty, startrad, startxspeed, startyspeed, startcolor);

	}

	public void move(){
		movecount++;
		super.move();
		
		if (movecount > 50) {
			int r = (int)(Math.random()* 255 + 0);
			int g = (int)(Math.random()* 255 + 0);
			int b = (int)(Math.random()* 255 + 0);
			setColor(new Color (r,g,b));
			movecount = 0;
		}
	}
}


