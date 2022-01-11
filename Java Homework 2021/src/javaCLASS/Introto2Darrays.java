package javaCLASS;

import java.util.Arrays;

public class Introto2Darrays {
	
	//1.
	//A. 6   
	//B. 1
	//C. Out of Bounds
	//D. 3
	//E. j
	//F. Out of Bounds
	//G. (99 + 6) -- > 105
	//H. 105 + 3 --> 108
	//I. (7, 6)
	
//2.
public static void nByN(int n) {
	int[][] arr = new int [n][n];
	int num = 0;
	for(int i = 0; i < arr.length; i++) {
		for(int j = 0; j < arr[i].length;j++) {
			arr[i][j] = num;
			num ++;
		}
	}
	for(int[] row : arr) {
		System.out.println(Arrays.toString(row));
	}
	
}

//3.
public static void howMany(String[][] arrstr) {
	System.out.print(arrstr.length);
	System.out.println(arrstr[0].length);
}

//4. 
public static void create2D(int a, int b, int c, int d, int e, int f){
	int[][] arr = {{a}, {b,c}, {d,e,f}};
	for(int[] row : arr) {
		System.out.println(Arrays.toString(row));
	}
}

	public static void main(String[] args) {
		nByN(5);
		howMany(new String [][] {{"dog","cat"}, {"fish","turtle"}, {"cow","horse"}});
		create2D(1,2,3,4,5,6);
	}

	


}
