package javaCLASS;
// Photoshop program that can run several manipulations on 
// an image
// filler code by Mr. David

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
    

    // this method increases each color's rgb value by a given amount.
    // don't forget that rgb values are limited to the range [0,255]
    public void brighten(int amount) {
        outputName = "brightened_" + outputName;
        
        for(int i = 0; i < pixels.length; i++) {
    		for(int j = 0; j < pixels[i].length;j++) { 
    			//acess the rgb of the old color
    			int r = pixels[i][j].getRed() + amount; 
    			int g = pixels[i][j].getGreen() + amount; 
    			int b = pixels[i][j].getBlue() + amount; 
    			
    			if (r>255) r=255;
    			else if(r<0) r=0;
    			if (g>255) g=255;
    			else if(g<0) g=0;
    			if (b>255) b=255;
    			else if(b<0) b=0;

    			pixels[i][j] = new Color(r,g,b);
    			
    		}
        }
        
        // your code here
    }
    
    // flip an image either horizontally or vertically.
    public void flip(boolean horizontally) {
        outputName = (horizontally?"h":"v") + "_flipped_" + outputName;

        if(horizontally == true) {
        	for(int i = 0; i < pixels.length; i++) {
        		for(int j = 0; j < .5*(pixels[i].length);j++) { 
        			Color filler = pixels[i][j];
        			pixels[i][j] = pixels[pixels.length-i][j];
        			pixels[pixels[i].length-i][j] = filler;
        		}
        	}
        }

        else{
            for(int i = 0; i < .5*(pixels.length); i++) {
        		for(int j = 0; j < pixels[i].length;j++) { 
        			Color filler = pixels[i][j];
        			pixels[i][j] = pixels[i][pixels[i].length-j];
        			pixels[i][pixels[i].length-j] = filler;
        		}
            }
        }
        
   }
    
    // negates an image
    // to do this: subtract each pixel's rgb value from 255 
    // and use this as the new value
    public void negate() {
        outputName = "negated_" + outputName;
        
        for(int i = 0; i < pixels.length; i++) {
    		for(int j = 0; j < pixels[i].length;j++) { 
    			//acess the rgb of the old color
    			int r = 255 - pixels[i][j].getRed() ; 
    			int g = 255 - pixels[i][j].getGreen(); 
    			int b = 255 - pixels[i][j].getBlue(); 
    			
    			if (r>255) r=255;
    			else if(r<0) r=0;
    			if (g>255) g=255;
    			else if(g<0) g=0;
    			if (b>255) b=255;
    			else if(b<0) b=0;

    			pixels[i][j] = new Color(r,g,b);
    		}
        }
    			
    }
    
    // this makes the image 'simpler' by redrawing it using only a few colors
    // to do this: for each pixel, find the color in the list that is closest to
    // the pixel's rgb value. 
    // use this predefined color as the rgb value for the changed image.
    public void simplify() {
    	// the list of colors to compare to. Feel free to change/add colors
		Color[] colorList = {Color.BLUE, Color.RED,Color.ORANGE, Color.MAGENTA,
            Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.CYAN};
    outputName = "simplified_" + outputName;
    
    	int closestI = 0;
    	
    	for(int i = 0; i < pixels.length; i++) {
    		for(int j = 0; j < pixels[i].length;j++) { 
        		for(int w = 0; w < colorList.length;w++) { 
        			double smallestdistance = distance(pixels[i][j],colorList[0]);
        			double colordistance = distance(pixels[i][j],colorList[w]);
    					if(Math.abs(colordistance) < Math.abs(smallestdistance)){
    						smallestdistance = Math.abs(colordistance);
    						closestI = w;
    					}
        		}
				pixels[i][j] = colorList[closestI];
    		}	
        }
    	closestI = 0;
    }

    
    // optional helper method (recommended) that finds the 'distance' 
    // between two colors.
    // use the 3d distance formula to calculate
    public double distance(Color c1, Color c2) {
        
    	int r1 = c1.getRed();
    	int g1 = c1.getGreen();
    	int b1 = c1.getBlue();
    	
    	int r2 = c2.getRed();
    	int g2 = c2.getGreen();
    	int b2 = c2.getBlue();
    	
    		return java.lang.Math.sqrt((r2-r1)^2+(g2-g1)^2+(b2-b1)^2);	
    }
    
    // this blurs the image
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values 
    // with the current pixel's own rgb value. 
    // divide this sum by 9, and set it as the rgb value for the blurred image
    public void blur() {
		outputName = "blurred_" + outputName;
		
		int surroundingpixelsred = 0;
		int surroundingpixelsgreen = 0;
		int surroundingpixelsblue = 0;
		
		for(int i = 1; i < pixels.length-1; i++) {
    		for(int j = 1; j < pixels[i].length-1;j++) { 
    			surroundingpixelsred = pixels[i][j].getRed()+pixels[i][j-1].getRed()+pixels[i-1][j].getRed()+pixels[i-1][j-1].getRed()
    					+pixels[i+1][j].getRed()+pixels[i][j+1].getRed()+pixels[i+1][j+1].getRed()+pixels[i-1][j+1].getRed()+pixels[i+1][j-1].getRed();
    			
    			surroundingpixelsgreen = pixels[i][j].getGreen()+pixels[i][j-1].getGreen()+pixels[i-1][j].getGreen()+pixels[i-1][j-1].getGreen()
    					+pixels[i+1][j].getGreen()+pixels[i][j+1].getGreen()+pixels[i+1][j+1].getGreen()+pixels[i-1][j+1].getGreen()+pixels[i+1][j-1].getGreen();
    			
    			surroundingpixelsblue = pixels[i][j].getBlue()+pixels[i][j-1].getBlue()+pixels[i-1][j].getBlue()+pixels[i-1][j-1].getBlue()
    					+pixels[i+1][j].getBlue()+pixels[i][j+1].getBlue()+pixels[i+1][j+1].getBlue()+pixels[i-1][j+1].getBlue()+pixels[i+1][j-1].getBlue();
    			
    			int redaverage = surroundingpixelsred/9;
    			int greenaverage = surroundingpixelsgreen/9;
    			int blueaverage = surroundingpixelsblue/9;
    			
    			pixels[i][j] = new Color(redaverage,greenaverage,blueaverage);    			
    		}
		}
		// your code here
	}
    
    // this highlights the edges in the image, turning everything else black. 
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values. 
    // now, multiply the current pixel's rgb value by 8, then subtract the sum.
    // this value is the rgb value for the 'edged' image
    public void edge() {
        outputName = "edged_" + outputName;
        
        int redsum = 0;
		int greensum = 0;
		int bluesum = 0;
		
		for(int i = 1; i < pixels.length-1; i++) {
    		for(int j = 1; j < pixels[i].length-1;j++) { 
    			redsum = pixels[i][j-1].getRed()+pixels[i-1][j].getRed()+pixels[i-1][j-1].getRed()+pixels[i+1][j].getRed()
    					+pixels[i][j+1].getRed()+pixels[i+1][j+1].getRed()+pixels[i-1][j+1].getRed()+pixels[i+1][j-1].getRed();
    			
    			greensum = pixels[i][j-1].getGreen()+pixels[i-1][j].getGreen()+pixels[i-1][j-1].getGreen()+pixels[i+1][j].getGreen()
    					+pixels[i][j+1].getGreen()+pixels[i+1][j+1].getGreen()+pixels[i-1][j+1].getGreen()+pixels[i+1][j-1].getGreen();
    			
    			bluesum = pixels[i][j-1].getBlue()+pixels[i-1][j].getBlue()+pixels[i-1][j-1].getBlue()+pixels[i+1][j].getBlue()
    					+pixels[i][j+1].getBlue()+pixels[i+1][j+1].getBlue()+pixels[i-1][j+1].getBlue()+pixels[i+1][j-1].getBlue();
    			
    			int r = (8*(pixels[i][j].getRed()) - redsum); 
    			int g = (8*(pixels[i][j].getGreen()) - greensum); 
    			int b = (8*(pixels[i][j].getBlue()) - bluesum); 
    			
    			pixels[i][j] = new Color(r,g,b);  
    		}
		}

    }
    
    public void extra() {
        outputName = "pink_" + outputName;
        
        for(int i = 0; i < pixels.length; i++) {
    		for(int j = 0; j < pixels[i].length;j++) { 
    			if(j%2==0) {
    				int r = pixels[i][j].getRed();
    				int g = 0;
    				int b = 0;
  
    				pixels[i][j] = new Color(r,g,b); 
    			}
    			else {
    				int r = 0;
    				int g = 0;
    				int b = pixels[i][j].getBlue();
  
    				pixels[i][j] = new Color(r,g,b); 
    			}
 
    		}
    	}

        // your code here
    }
    
    // *************** DON'T MESS WITH THE BELOW CODE **************** //
    
    // feel free to check it out, but don't change it unless you've consulted 
    // with Mr. David and understand what the code's doing
    
    

    public void run() {
    	JFileChooser fc = new JFileChooser();
		File workingDirectory = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+ "Images");
		fc.setCurrentDirectory(workingDirectory);
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