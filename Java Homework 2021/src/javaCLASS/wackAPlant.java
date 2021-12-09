package javaCLASS;
//Marianne Lyons Wack a Plant

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class wackAPlant {

	// size of the display area
    private int windowWidth = 800, windowHeight = 600, textHeight = 35; 
    
    //imports images
    private Image plantImg, bgImg, tubeImg;

    // time gap between new plants popping up (new round starting) (in milliseconds)
    private final int TIMESTEP = 2000;
   
    //plant variables
    private final int NUMTUBES = 10, NUMAPPEARING = 5, PLANTWIDTH = windowWidth/20, PLANTHEIGHT = windowHeight/20;
	
    //tube variables
    private int TUBEWIDTH = windowWidth/8;

	private int TUBEHEIGHT = windowHeight/8;

    //locations of the tube and plants
    private int[] x, y;		
    //keeps tracks of which plants show up
    private boolean[] showing;	
    
    //variables for the ranges of random x and y points, str
    private int yrange = (int)(windowHeight * (.2)), ymin = (int)(windowHeight * (.6));
    private int xrange = windowWidth-(2*TUBEWIDTH), xmin = 0 +(TUBEHEIGHT);
  
    //keeps track of score
    private int score;
    
    //boolean for drawing the first plants
    private boolean initialize = true;
   
    //extra feature instance variables
    //boolean for special feature big plant
    private int roundcount = 0;
    
    //extra feature large plant dimesions
    private int GIANTPLANTWIDTH = windowWidth/10, GIANTPLANTHEIGHT = windowHeight/10;
 
    public void setup() {
    	//loads images used
		plantImg = Toolkit.getDefaultToolkit().getImage("plant.png");
		bgImg = Toolkit.getDefaultToolkit().getImage("background.png");
		tubeImg = Toolkit.getDefaultToolkit().getImage("tube.png");
		
        //initializes x and y array
        x = new int[NUMTUBES];
        y = new int[NUMTUBES];
       
        //initializes showing array
        showing = new boolean[NUMTUBES];
        
        //fills x and y array with random coordinates within the ranges 
        for(int i = 0; i < x.length; i++) {
                x[i] = (int)(Math.random()*xrange + xmin); // created random x
                y[i] = (int)(Math.random()*yrange + ymin); // created random y
        }
    }

    public void draw(Graphics g) {
    	int plantcount = 0; 
    	
    	// the entire display window
    	g.drawImage(bgImg, 0, 0, windowWidth, windowHeight, null);
    	
    	// draws tubes at random x and y
        for(int i = 0; i < x.length; i++) {
        	g.drawImage(tubeImg, x[i], y[i], TUBEWIDTH, TUBEHEIGHT, null);

        }
        
        //the next 2 ifs and the else draw my plants
        //draws my first "round" of plants
        if(initialize) {
        	while(plantcount < NUMAPPEARING) { //draws the proper amount of plants
        			g.drawImage(plantImg, x[plantcount]+30, y[plantcount]-15, PLANTWIDTH, PLANTHEIGHT, null); //draws the plant above the tube
        			showing[plantcount] = true;//fills in showing to remeber which indexes are already drawn
        			plantcount++;//moves onto the next index
        	}
        	plantcount = 0;//makes the index not go out of bounds, so  plants can be redrawn
        	initialize = false;//makes sure this loop doesnt happen again
        }
        
        //draws the plants when which indexes that are being drawn are staying the same
        for(int i = 0; i < showing.length; i++) {
        	if(showing[i]){
            	if(roundcount % 10 != 0) { //checks if special feature should be happening 
            		g.drawImage(plantImg, x[i]+30, y[i]-15, PLANTWIDTH, PLANTHEIGHT, null); //draws the plant above the tube if it shouldnt happen 30 and 15 shift plant so it is in the center of tube
            		}
            	else if (roundcount % 10 == 0) {//checks if the special feature should be happening
            		g.drawImage(plantImg, x[i]+10, y[i]-40, GIANTPLANTWIDTH, GIANTPLANTHEIGHT, null); //draws the GIANT plant above the tube 10 and 40 shift plant so it is in the center of tube
            	}
        	}
        }
    }

        

    // what you want to happen when the mouse is clicked
    public void click(int mouseX, int mouseY) {
    	for(int i = 0; i < x.length; i++) {
    		//checks if the mouse clicks on the plant // 30 and 15 shift plant so it is in the center of tube
    		if(mouseX < (x[i]+30) + (PLANTWIDTH) && mouseX > (x[i]+30) && mouseY < (y[i]-15) + (PLANTHEIGHT) && mouseY > (y[i]-15)) {
    			//if it clicks on the plant...
    			if (roundcount % 10 == 0) {
    				score += 5; //adds to score if they click giant plant
    			}
    			else {
    				score ++; //adds to score if they click normal plant
    			}
    			showing[i]=false; //makes plant disappear
    		}
    	}
    }
    	
    
    
    // what you want to happen when the time for the current round ends
    public void timeAdvance() {
    	int plantcount = 0;//resets plant count so we can redraw plants
    	showing = new boolean[NUMTUBES];
    	while(plantcount < NUMAPPEARING) {//draws the proper amount of plants
    		showing[(int)(Math.random()* NUMTUBES + 0)] = true;//indicates that this random index now has a plant
    		plantcount = 0;
    		for(int i = 0; i < showing.length; i++){//checks how many plants have been drawn, so that the correct number get drawn
        		if(showing[i] == true) {
        			plantcount ++; 
        		}
    		}
    	}
    	//keeps track of when extra feature should happen
        roundcount ++;
    }
    	
    // reset the games when user presses the button
    public void reset() {
    	//changes variables to make sizing work, if user resizes window
    	yrange = (int)(windowHeight * (.2)); ymin = (int)(windowHeight * (.6));
        xrange = windowWidth - (2*TUBEWIDTH); xmin = 0 +(TUBEHEIGHT);

    	//randomizes the new xs and ys to reset tube placements
        for(int i = 0; i < x.length; i++) {
    		x[i] = (int)(Math.random()*xrange + xmin);
    		y[i] = (int)(Math.random()*yrange + ymin);
        }
        //resets score
        score = 0;  
    }


    // DO NOT TOUCH BELOW CODE //

    public wackAPlant() {
    	
    	setup();

        JFrame window = new JFrame();
        window.setTitle("Whack A Mole");
        window.setSize(windowWidth, windowHeight + textHeight);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JTextArea scoreDisplay = new JTextArea();
        scoreDisplay.setEditable(false);
        scoreDisplay.setText("\t\tScore: 0");
        
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
                window.getContentPane().repaint();
			}
        });
        
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(windowWidth, textHeight));
        topPanel.add(resetButton);
        scoreDisplay.setBackground(topPanel.getBackground());
        
        topPanel.add(scoreDisplay);

        

        JPanel canvas = new JPanel() {
            public void paint(Graphics g) {
                draw(g);
                scoreDisplay.setText("\t\tScore: " + score);
            }
        };
        canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));

        canvas.addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {
                click(e.getX(), e.getY());
                window.getContentPane().repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        
        window.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                windowWidth = window.getWidth();
                windowHeight = window.getHeight() - textHeight;
                topPanel.setPreferredSize(new Dimension(windowWidth, textHeight));
                canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));
            }
        });

        container.add(topPanel);
        container.add(canvas);
        window.add(container);
        window.setVisible(true);
        canvas.revalidate();
        window.getContentPane().repaint();
        
        new Timer(TIMESTEP, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	timeAdvance();
            	window.getContentPane().repaint();
            }
        }).start();
    }
    

    public static void main(String[] args) {
        new wackAPlant();
    }

}