package javaCLASS;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FallingBlocks extends JPanel {
	
	private int WIDTH = 800, HEIGHT = 600, NUMBLOCKS = 50;
	private final int BOXWIDTH = 10, BOXHEIGHT = 10;
	
	//declares list of x and y values 
	int [] blockX = new int[NUMBLOCKS];
	int [] blockY = new int[NUMBLOCKS];;
	
	// my random color lists 
	int [] r = new int[NUMBLOCKS];
	int [] gr = new int[NUMBLOCKS];
	int [] b = new int[NUMBLOCKS];

	
	
	// fills in arrays with random x and y values
	public void initializeArrays() {
		
		// fills list of x values
		for(int i = 0; i < NUMBLOCKS-1; i++){
			blockX[i] = (int)(Math.random()*WIDTH-BOXWIDTH+0);
		}
		//fills list of y values 
		for(int j = 0; j < NUMBLOCKS-1; j++){
			blockY[j] = (int)(Math.random()*HEIGHT-+0);
			System.out.println(blockY[j]);
		}
		//fills my r gr b lists with random values
		for(int i = 0; i < NUMBLOCKS-1; i++){
			r[i] = (int)(Math.random()*255-+0);
		}
		for(int i = 0; i < NUMBLOCKS-1; i++){
			gr[i] = (int)(Math.random()*255-+0);
		}
		for(int i = 0; i < NUMBLOCKS-1; i++){
			b[i] = (int)(Math.random()*255-+0);
		}
			
	}
	
	// change your arrays here to make the blocks move
	public void moveblocks() {
		for (int j = 0; j < NUMBLOCKS-1; j++){
			// makes boxes move down
			blockY[j]+=2;
			// resets boxes to the top when they reach the bottom
			if (blockY[j] >= HEIGHT){
				blockY[j] = 0;
			}
		}		
	}
	
	public void paint(Graphics g) {
		// give a white background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		// draws rectangles at given random x and y from the list
		for(int i = 0; i < NUMBLOCKS-1; i++){
			for (int j = 0; j < 1; j++){
				//makes random color
				g.setColor(new Color(r[i],gr[i],b[i]));
				g.drawRect(blockX[i], blockY[i], BOXWIDTH, BOXHEIGHT);
				g.fillRect(blockX[i], blockY[i], BOXWIDTH, BOXHEIGHT);
			}
		}
	}
	
	// ******** DON'T TOUCH BELOW CODE ***************
	
	// don't touch this method!
	public FallingBlocks() {
		initializeArrays();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);

		while (true) {
			moveblocks();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			WIDTH = frame.getSize().width;
			HEIGHT = frame.getSize().height;
		}
	}

	// don't touch this method!
	public static void main(String[] args) {
		new FallingBlocks();
	}

}