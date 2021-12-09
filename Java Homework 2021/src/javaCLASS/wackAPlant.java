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
    private final int NUMTUBES = 10, NUMAPPEARING = 5, PLANTWIDTH = windowWidth/20, PLANTHEIGHT = windowHeight/20,
    PLANTSHIFTX = 30, PLANTSHIFTY = 15; //shifts ensure that plant is centered on the tube
    
	
    //tube variables
    private int TUBEWIDTH = windowWidth/8;
	private int TUBEHEIGHT = windowHeight/8;

    //locations of the tube and plants
    private int[] x, y;		
    
    //keeps tracks of which plants show up
    private boolean[] showing;	
    
    //variables for the ranges of random x and y points, for tube locations, shifts make sure tubes are on grass and within width of window
    private int yrange = (int)(windowHeight * (.2)), ymin = (int)(windowHeight * (.6));
    private int xrange = windowWidth-(2*TUBEWIDTH), xmin = 0 +(TUBEHEIGHT);
  
    //keeps track of score
    private int score;
    
    //boolean for drawing the first plants
    private boolean initialize = true;
   
    //extra feature instance variables
    //boolean for special feature GIANT PLANT, keeps track of when that should be happening
    private int roundcount = 0;
    
    //extra feature large plant dimesions
    private int GIANTPLANTWIDTH = windowWidth/10, GIANTPLANTHEIGHT = windowHeight/10,
    GIANTPLANTSHIFTX = 10, GIANTPLANTSHIFTY = 40;
 
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

    //draws all display
    public void draw(Graphics g) {
    	int plantcount = 0; 
    	
    	// the entire display window
    	g.drawImage(bgImg, 0, 0, windowWidth, windowHeight, null);
    	
    	// draws tubes at random x and y
        for(int i = 0; i < x.length; i++) {
        	g.drawImage(tubeImg, x[i], y[i], TUBEWIDTH, TUBEHEIGHT, null);

        }
        
        //draws my first "round" of plants
        if(initialize) {
        	while(plantcount < NUMAPPEARING) { //draws the proper amount of plants
        			//draws the plant above the tube 
        			g.drawImage(plantImg, x[plantcount]+PLANTSHIFTX, y[plantcount]-PLANTSHIFTY, PLANTWIDTH, PLANTHEIGHT, null); //shifts ensure that plant is centered on the tube
        			showing[plantcount] = true;//fills in showing to remeber which plants are already drawn
        			plantcount++;//moves onto the next index
        	}
        	plantcount = 0;//makes the index not go out of bounds, so  plants can be redrawn and proper amount of plants are drawn
        	initialize = false;//makes sure this loop doesnt happen again
        }
        
        //draws the plants when plants (indexes) that are being drawn not changing
        for(int i = 0; i < showing.length; i++) {
        	if(showing[i]){//checks if plant is already showing and thus should be redrawn in same place
            	if(roundcount % 10 != 0) { //checks if special feature should be happening 
            		g.drawImage(plantImg, x[i]+PLANTSHIFTX, y[i]-PLANTSHIFTY, PLANTWIDTH, PLANTHEIGHT, null); //draws the plant above the tube if speacial feature shouldnt happen //shifts ensure that plant is centered on the tube
            		}
            	else if (roundcount % 10 == 0) {//checks if the special feature should be happening, occurs every 10 rounds
            		g.drawImage(plantImg, x[i]+GIANTPLANTSHIFTX, y[i]-GIANTPLANTSHIFTY, GIANTPLANTWIDTH, GIANTPLANTHEIGHT, null); //draws the GIANT plant above the tube, //shifts ensure that plant is centered on the tube
            	}
        	}
        }
    }

        

    // what you want to happen when the plant is clicked (add to score and have plant dispear)
    public void click(int mouseX, int mouseY) {
    	for(int i = 0; i < x.length; i++) {
    		//checks if the mouse clicks on the plant // 30 and 15 shift plant so it is in the center of tube, 
    		if(mouseX < (x[i]+PLANTSHIFTX) + (PLANTWIDTH) && mouseX > (x[i]+PLANTSHIFTX) && mouseY < (y[i]-PLANTSHIFTY) + (PLANTHEIGHT) && mouseY > (y[i]-PLANTSHIFTY)) {
    			//if it clicks on the plant...
    			if (roundcount % 10 == 0) { //checks if giant plant (special feature) is in play
    				score += 5; //adds 5 to score if they click giant plant
    			}
    			else {
    				score ++; //adds 1 to score if they click normal plant
    			}
    			showing[i]=false; //makes plant disappear after it has been clicked
    		}
    	}
    }
    	
    
    
    // what you want to happen when the time for the current round ends (change  which plants are drawn radomly)
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
    	//changes variables to make sizing fit in the case the user resizes window
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