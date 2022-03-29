package javaCLASS;

	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.util.ArrayList;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;

	public class ListFallingBlocks {		
		private final int WIDTH = 700, HEIGHT = 600;
		
		private ArrayList<Block> blocks = new ArrayList<Block>();

		public void draw(Graphics g) {
			// draws a white background
			g.setColor(Color.WHITE);
			g.fillRect(0,0, WIDTH, HEIGHT);
					
			for(Block b: blocks) {
				System.out.print("cool");
				b.draw(g);
			}
		}
		
		// move all the blocks in the list by their respective speed
		// if the block moves off the screen, it should be removed 
		// from the list.
		public void update() {
			for(int i = 0; i < blocks.size(); i++) {
				blocks.get(i).move();
				System.out.print("yes");

				
				if (blocks.get(i).getY()>HEIGHT) {
					blocks.remove(i);
					
				i--;
				}
			}
		}
		
		// adds a new block to the list with a random speed, 
		// and location at x,y.
		public void addBlock(int x, int y) {
			int r = (int)(Math.random()*255 + 0); 
			int g = (int)(Math.random()*255 + 0); 
			int b = (int)(Math.random()*255 + 0); 
			Color color = new Color(r,g,b);
			System.out.print("okay");

	
			blocks.add(new Block(x, y, color, (int)(Math.random()*10 + 1)));

		}
		
		// ***** DON'T TOUCH BELOW CODE ******** //
		
		public  ListFallingBlocks() {
			JFrame frame = new JFrame();
			frame.setSize(WIDTH, HEIGHT);
			frame.setLocationRelativeTo(null);
			JPanel c = new JPanel() {
				public void paintComponent(Graphics g) {
					draw(g);
				}
			};
			frame.add(c);
			c.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {}
				public void mousePressed(MouseEvent e) {
					addBlock(e.getX(), e.getY());}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
			});
			JLabel l = new JLabel();
			c.add(l);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			while (true) {
//				System.out.print("hi");
				l.setText("Number of Blocks: " + blocks.size());
				frame.repaint();
				update();
				try {
					Thread.sleep(60);
				}
				catch(InterruptedException e) {
					System.out.print("yes");
				}
			}
		}
		
		public static void main(String[] args) {
			new ListFallingBlocks();
		}
	}


