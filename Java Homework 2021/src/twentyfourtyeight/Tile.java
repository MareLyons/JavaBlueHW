package twentyfourtyeight;

	// SpaceThing class for SpaceInvaders by Mr. David
	// no need to edit this class

	import java.awt.Graphics;
	import java.awt.Image;
	import java.awt.Rectangle;
	import java.io.File;
	import java.io.IOException;

	import javax.imageio.ImageIO;

	public class Tile extends Rectangle {
		
		private Image img;
		private int value;
		private int speedx;
		private int speedy;
		
		// constructor takes a location and the name of the image file as parameters
		public Tile(int x, int y, int w, int h, String imgName, int value, int speedx, int speedy) {
			super(x, y, w, h);
			this.value = value;
			this.speedx = speedx;
			this.speedy = speedy;
			try {
				img = ImageIO.read(new File(imgName)).getScaledInstance(w, h, Image.SCALE_SMOOTH);
			} catch (IOException e) {
				System.out.println("Image file not found");
			}
		}
		
		// moves x by the inputted amount
		public void moveX(int dX) {
			x += dX;
		}
		
		// moves y by the inputted amount
		public void moveY(int dY) {
			y += dY;
		}
		
		public int GetValue() {
			return(value);
		}
		
		//returns the speed
		public int getSpeedX() {
			return(speedx);
		}
		
		public int getSpeedY() {
			return(speedy);
		}
		
		//sets the speed
		public void setSpeedX(int newspeedx) {
			speedx = newspeedx;
		}
		
		public void setSpeedY(int newspeedy) {
			speedy = newspeedy;
		}
		
		
		// draws the image corresponding with this alien/player
		public void draw(Graphics g) {
			g.drawImage(img, x, y, width, height,  null);
		}
	}

