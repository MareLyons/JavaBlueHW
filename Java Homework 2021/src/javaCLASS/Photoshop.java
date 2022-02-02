package javaCLASS;
//Marianne Lyons Photoshop 

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class Photoshop extends Component {

	// the name of the output file. will be determined by which methods are called
    private String outputName;
    
    // the 2d array of colors representing the image
    private Color[][] pixels;
    
    // the width and height of the image 
    private int w,h;

    // this method increases each color's rgb value by a given amount
    public void brighten(int amount) {
        outputName = "brightened_" + outputName;
        
        //goes through every pixel
        for(int i = 0; i < pixels.length; i++) {
    		for(int j = 0; j < pixels[i].length;j++) { 
    			//acess the rgb of the old color and adds how much the user wants it to be brightened by
    			int r = pixels[i][j].getRed() + amount;  
    			int g = pixels[i][j].getGreen() + amount; 
    			int b = pixels[i][j].getBlue() + amount; 
    			
    			//makes sure the rgb values stay within 0 and 255
    			if (r>255) r=255;
    			else if(r<0) r=0;
    			if (g>255) g=255;
    			else if(g<0) g=0;
    			if (b>255) b=255;
    			else if(b<0) b=0;
    			
    			//sets the pixel equal to the new, brightened color
    			pixels[i][j] = new Color(r,g,b);	
    		}
        }
    }
    
 
    // flip an image either horizontally or vertically.
    public void flip(boolean horizontally) {
        outputName = (horizontally?"h":"v") + "_flipped_" + outputName;
        
        //checks if the user wants a horizontal flip
        //if they want a horizontal flip...
        if(horizontally == true) {
        	//goes through half of the pixels width wise
        	for(int i = 0; i < h; i++) {
    			for(int j = 0; j < w/2; j++) {
    				//creates a temp variable to hold original pixel
    				Color temp = pixels[i][j];
    				//makes the pixel equal to its "opposite" pixel across the x axis
    				pixels[i][j] = pixels[i][w-1-j];
    				//makes the "opposite" pixel equal to the orignal pixel on the x axis
    				pixels[i][w-1-j] = temp;
    	    	}
    		}
        }
        
        //if the user wants a vertical flip...
    	else{
        	//goes through half of the pixels height wise
    		for(int i = 0; i < h/2; i++) {
    			for(int j = 0; j < w; j++) {
    				//creates a temp variable to hold original pixel
    				Color temp = pixels[i][j];
    				//makes the pixel equal to its "opposite" pixel across the y axis
    				pixels[i][j] = pixels[h-1-i][j];
    				//makes the "opposite" pixel equal to the orignal pixel on the y axis
    				pixels[h-1-i][j] = temp;
    	    	}
    		}
        }
    }
        
    
    // negates an image (makes its colors the opposite)
    public void negate() {
        outputName = "negated_" + outputName;
        
        //goes through every pixel
        for(int i = 0; i < pixels.length; i++) {
    		for(int j = 0; j < pixels[i].length;j++) { 
    			//acess the rgb of the old color and flips it to be the opposite side of the rgb value
    			int r = 255 - pixels[i][j].getRed() ; 
    			int g = 255 - pixels[i][j].getGreen(); 
    			int b = 255 - pixels[i][j].getBlue(); 
    			//makes sure the rgb values stay within 0 and 255
    			if (r>255) r=255;
    			else if(r<0) r=0;
    			if (g>255) g=255;
    			else if(g<0) g=0;
    			if (b>255) b=255;
    			else if(b<0) b=0;
    			//sets the pixel equal to the new, negated color
    			pixels[i][j] = new Color(r,g,b);
    		}
        }		
    }
    
    
    // this makes the image 'simpler' by redrawing it using only a few colors
    public void simplify() {
    	// the list of colors to compare to. Feel free to change/add colors
		Color[] colorList = {Color.BLUE, Color.RED,Color.ORANGE, Color.MAGENTA,
            Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.CYAN};
    outputName = "simplified_" + outputName;
    	//variable to keep track of what color is the closest
    	int closestI = 0;
    	//variable to keep track of what the current smallest diff between color and pixel color is
    	double smallestdistance = 0;
    	
    	//goes through every pixel
    	for(int i = 0; i < pixels.length; i++) {
    		for(int j = 0; j < pixels[i].length;j++) { 
    			//sets the first smallest distance to the first color in the list
    			smallestdistance = distance(pixels[i][j],colorList[0]);
    			//goes through every color
        		for(int w = 0; w < colorList.length;w++) { 		
        			//keeps track of the color distance being tested
        			double colordistance = distance(pixels[i][j],colorList[w]);
        				//checks if the distance from the current color being tested is smaller than the formerly smallest distance
    					if(Math.abs(colordistance) < Math.abs(smallestdistance)){
    						//if true then sets the smallest distance to the distance from the current color being tested
    						smallestdistance = Math.abs(colordistance);
    						//sets the closest index to the new smallest distance
    						closestI = w;
    					}
        		}
        		//makes the current pixel equal to its closest color
				pixels[i][j] = colorList[closestI];
				//resets closest I  
            	closestI = 0;
    		}	
    	}
    }

    
    // finds the distance between two colors (helper method for simplify)
    public double distance(Color c1, Color c2) {
        
    	//gets the first color rgb values
    	int r1 = c1.getRed();
    	int g1 = c1.getGreen();
    	int b1 = c1.getBlue();
    	
    	//gets the second color rgb values
    	int r2 = c2.getRed();
    	int g2 = c2.getGreen();
    	int b2 = c2.getBlue();
    	
    	//calculated the distance between the two colors, through their rgb values
    	return java.lang.Math.sqrt(Math.pow(r2-r1,2)+Math.pow(g2-g1,2)+Math.pow(b2-b1,2));	
    }
    
    
    
    // blurs an image (by averaging the 8 pixels around it)
    public void blur() {
		outputName = "blurred_" + outputName;
		
		//saves the pixels and surrounding pixels rgb sum
		int surroundingpixelsred = 0;
		int surroundingpixelsgreen = 0;
		int surroundingpixelsblue = 0;
		
		//creates a paraell 2D array to store the newly blurred pixels
		Color[][] pixelsnew = new Color [h][w];//W AND H ARE OFF??

		//goes through every pixel
		for(int i = 1; i < pixels.length-1; i++) {
    		for(int j = 1; j < pixels[i].length-1;j++) { 
    			//sums the pixel and its 8 surrounding pixels red values
    			surroundingpixelsred = pixels[i][j].getRed()+pixels[i][j-1].getRed()+pixels[i-1][j].getRed()+pixels[i-1][j-1].getRed()
    					+pixels[i+1][j].getRed()+pixels[i][j+1].getRed()+pixels[i+1][j+1].getRed()+pixels[i-1][j+1].getRed()+pixels[i+1][j-1].getRed();
    			//sums the pixel and its 8 surrounding pixels green values
    			surroundingpixelsgreen = pixels[i][j].getGreen()+pixels[i][j-1].getGreen()+pixels[i-1][j].getGreen()+pixels[i-1][j-1].getGreen()
    					+pixels[i+1][j].getGreen()+pixels[i][j+1].getGreen()+pixels[i+1][j+1].getGreen()+pixels[i-1][j+1].getGreen()+pixels[i+1][j-1].getGreen();
    			//sums the pixel and its 8 surrounding pixels blue values
    			surroundingpixelsblue = pixels[i][j].getBlue()+pixels[i][j-1].getBlue()+pixels[i-1][j].getBlue()+pixels[i-1][j-1].getBlue()
    					+pixels[i+1][j].getBlue()+pixels[i][j+1].getBlue()+pixels[i+1][j+1].getBlue()+pixels[i-1][j+1].getBlue()+pixels[i+1][j-1].getBlue();
    			
    			//finds the average of the rgb values of the pixel and its surrounding 8 pixels
    			int redaverage = surroundingpixelsred/9;
    			int greenaverage = surroundingpixelsgreen/9;
    			int blueaverage = surroundingpixelsblue/9;
    			
    			//sets the pixel to the average found
    			pixelsnew[i][j] = new Color(redaverage,greenaverage,blueaverage);    			
    		}
		}
		//these loops fill the outside of the loop with the pixels from the orignal value, 
		//as the prior for loop does not touch the outline of the image
		for(int i = 0; i < h; i++) {
    			pixelsnew[i][0] = pixels[i][0];
    			pixelsnew[i][w-1] = pixels[i][w-1];
    		}
    	for(int j = 0; j < w; j++) { 
    			pixelsnew[0][j] = pixels[0][j];
    			pixelsnew[h-1][j] = pixels[h-1][j];
    		}
		//AFTER all the storage pixels have been changed and boarder is created this makes the original pixels 2D array equal to the edged pixel array
		pixels = pixelsnew;
    }
    
    
    
    // this highlights the edges in the image, turning everything else black. 
    public void edge() {
        outputName = "edged_" + outputName;
		
        //saves the pixels and surrounding pixels rgb sum
        int redsum = 0;
		int greensum = 0;
		int bluesum = 0;
		
		//creates a paraell 2D array to store the newly "edged" pixels
		Color[][] pixelsnew = new Color [h][w];

		//goes through every pixel
		for(int i = 1; i < pixels.length-1; i++) {
    		for(int j = 1; j < pixels[i].length-1;j++) { 
    			//sums the pixel and its 8 surrounding pixels red values
    			redsum = pixels[i][j-1].getRed()+pixels[i-1][j].getRed()+pixels[i-1][j-1].getRed()+pixels[i+1][j].getRed()
    					+pixels[i][j+1].getRed()+pixels[i+1][j+1].getRed()+pixels[i-1][j+1].getRed()+pixels[i+1][j-1].getRed();
    			//sums the pixel and its 8 surrounding pixels green values
    			greensum = pixels[i][j-1].getGreen()+pixels[i-1][j].getGreen()+pixels[i-1][j-1].getGreen()+pixels[i+1][j].getGreen()
    					+pixels[i][j+1].getGreen()+pixels[i+1][j+1].getGreen()+pixels[i-1][j+1].getGreen()+pixels[i+1][j-1].getGreen();
    			//sums the pixel and its 8 surrounding pixels blue values
    			bluesum = pixels[i][j-1].getBlue()+pixels[i-1][j].getBlue()+pixels[i-1][j-1].getBlue()+pixels[i+1][j].getBlue()
    					+pixels[i][j+1].getBlue()+pixels[i+1][j+1].getBlue()+pixels[i-1][j+1].getBlue()+pixels[i+1][j-1].getBlue();
    			
    			//takes the original pixel multiples it by 8 and subtracts the sums
    			//creates the edged affect
    			int r = (8*(pixels[i][j].getRed()) - redsum); 
    			int g = (8*(pixels[i][j].getGreen()) - greensum); 
    			int b = (8*(pixels[i][j].getBlue()) - bluesum); 
    			
    			//makes sure the rgb values stay within 0 and 255
    			if (r>255) r=255;
    			else if(r<0) r=0;
    			if (g>255) g=255;
    			else if(g<0) g=0;
    			if (b>255) b=255;
    			else if(b<0) b=0;
    			
    			//makes the storage pixel equal to the edged pixels
    			pixelsnew[i][j] = new Color(r,g,b);  
    		}
		}
		//these loops create a 1x1 pixel boarder around the image, as the prior for loop does not touch the
		//outline of the image

		for(int i = 0; i < h; i++) {
    			pixelsnew[i][0] = Color.BLACK;
    			pixelsnew[i][w-1] = Color.BLACK;
    		}
    	for(int j = 0; j < w; j++) { 
    			pixelsnew[0][j] = Color.BLACK;
    			pixelsnew[h-1][j] = Color.BLACK;
    		}
		//AFTER all the storage pixels have been changed and boarder is created this makes the original pixels 2D array equal to the edged pixel array
		pixels = pixelsnew;
    }
    
    
    
    //extra feature that pink scales the image
    public void extra(boolean pink) {
        outputName = (pink?"p":"t") + "_scaled_" + outputName;
        
        System.out.println(pink);
        
        //checks if the use wants to pinken their image
        if(pink == true) {
        	//if yes, goes through every pixel
	        for(int i = 0; i < pixels.length; i++) {
	    		for(int j = 0; j < pixels[i].length;j++) { 
	    			//sets every other pixel to just its red value, setting its green and blue to zero
	    			if(j%2==0) {
	    				int r = pixels[i][j].getRed();
	    				int g = 0;
	    				int b = 0;
	    				//sets the pixel to red scaled version
	    				pixels[i][j] = new Color(r,g,b); 
	    			}
	    			//sets every other pixel to just its blue value, setting its green and red to zero
	    			else {
	    				int r = 0;
	    				int g = 0;
	    				int b = pixels[i][j].getBlue();
	    				//sets the pixel to blue scaled version
	    				pixels[i][j] = new Color(r,g,b); 
	    			}
	    		}
	        }
    	}
        //checks if the user wants to teal scale their image
        else {
        	//if yes, goes through every pixel
        	for(int i = 0; i < pixels.length; i++) {
        		for(int j = 0; j < pixels[i].length;j++) { 
	    			if(j%2==0) {
        			//sets every other pixel to just its green value, setting its red and blue to zero
        				int r = 0;
        				int g = pixels[i][j].getGreen();
        				int b = 0;
        				//sets the pixel to green scaled version
        				pixels[i][j] = new Color(r,g,b); 
	    			}
	    			else {
	        		//sets every other pixel to just its blue value, setting its red and green to zero
	    				int r = 0;
	    				int g = 0;
	    				int b = pixels[i][j].getBlue();
	    				//sets the pixel to blue scaled version
	    				pixels[i][j] = new Color(r,g,b); 
	    			}
        		}
        	}
        }
    }
    
    // *************** DON'T MESS WITH THE BELOW CODE **************** //
    
    // feel free to check it out, but don't change it unless you've consulted 
    // with Mr. David and understand what the code's doing
    
    public void run() {
    	JFileChooser fc = new JFileChooser();
//		File workingDirectory = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+ "Images");
//		fc.setCurrentDirectory(workingDirectory);
		fc.showOpenDialog(null);
		File my_file = fc.getSelectedFile();
		if (my_file == null)
			System.exit(-1);
		
		// reads the image file and creates our 2d array
        BufferedImage image;
		try {
			image = ImageIO.read(my_file);
		
	        BufferedImage new_image = new BufferedImage(image.getWidth(),
	                        image.getHeight(), BufferedImage.TYPE_INT_ARGB);
	        create_pixel_array(image);
			outputName = my_file.getName();
			
			// runs the manipulations determined by the user
			System.out.println("Enter the manipulations you would like to run on the image.\nYour "
					+ "choices are: brighten, flip, negate, blur, edge, extra or simplify.\nEnter each "
					+ "manipulation you'd like to run, then type in 'done'.");
			Scanner in = new Scanner(System.in);
			String action = in.next().toLowerCase();
			while (!action.equals("done")) {
	    			try {
		    			if (action.equals("brighten")) {
		    				System.out.println("enter an amount to increase the brightness by");
		    				int brightness = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, brightness);
		    			}
		    			else if (action.equals("flip")) {
		    				System.out.println("enter \"h\" to flip horizontally, anything else to flip vertically.");
		        			Method m = getClass().getDeclaredMethod(action, boolean.class);
		        			m.invoke(this, in.next().equals("h"));
		    			}
		    			else if (action.equals("extra")) {
		    				System.out.println("enter p to scale your image pink and anything else to scale it teal");
		        			Method m = getClass().getDeclaredMethod(action, boolean.class);
		        			m.invoke(this, in.next().equals("p"));
		    			}
		    			else {
		        			Method m = getClass().getDeclaredMethod(action);
		        			m.invoke(this, new  Object[0]);
		    			}
		    			System.out.println("done. enter another action, or type 'done'");
	    			}
	    			catch (NoSuchMethodException e) {
	    				System.out.println("not a valid action, try again");
	    			} catch (IllegalAccessException e) {e.printStackTrace();System.exit(1);} 
	    			catch (IllegalArgumentException e) {e.printStackTrace();System.exit(1);}
	    			catch (InvocationTargetException e) {e.printStackTrace();System.exit(1);}
	    			
	    			action = in.next().toLowerCase();
	    		} 
	        in.close();
	        
	        // turns our 2d array of colors into a new png file
	        create_new_image(new_image);
	        File output_file = new File("Images/" + outputName);
	        ImageIO.write(new_image, "png", output_file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
		
    
    public void create_pixel_array(BufferedImage image) {
        w = image.getWidth();
        h = image.getHeight();
        pixels = new Color[h][];
        for (int i = 0; i < h; i++) {
            pixels[i] = new Color[w];
            for (int j = 0; j < w; j++) {
                pixels[i][j] = new Color(image.getRGB(j,i));
            }
        }
    }

    public void create_new_image(BufferedImage new_image) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
            		new_image.setRGB(j, i, pixels[i][j].getRGB());
            }
        }
    }

    public static void main(String[] args) {
		new Photoshop();
	}

    public Photoshop() {
		run();
    }
}