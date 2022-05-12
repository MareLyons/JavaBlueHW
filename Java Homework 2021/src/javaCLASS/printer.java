package javaCLASS;

import java.awt.Color;
import java.util.Arrays;

public class printer {
	
	int filler = 0;
	
	public static void flip() {
	int[][] pixels = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
	System.out.print(pixels.length);
	
		for(int i = 0; i < pixels.length; i++) {
			for(int j = 0; j < pixels.length/2; j++) {
				int temp = pixels[i][j];
				pixels[i][j] = pixels[i][pixels[i].length-1];
				pixels[i][pixels[i].length-j-1] = temp;	
    	}
    }
    for(int[] row : pixels) {
		System.out.println(Arrays.toString(row));
	}
	}
	public static void main(String[] args) {
		flip();
	}
}
