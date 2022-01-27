package javaCLASS;

import java.util.Arrays;

public class EvenMorewith2dArrays {
	
	public static void createString(char[][] letters) {
		String newstr =  " ";
		for(int i = 0; i < letters.length; i++) {
			for(int j = 0; j < letters[i].length;j++) {
				newstr += (letters[i][j]);
			}
		}
		System.out.println(newstr);
	}
	
	//not done
	public static void createDiagonal(int n) {
		char[][] arr = new char [n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n;j++) {
				if(i == j) {
					arr[i][j]= 'n';
				}
				else if((i+j) == (n-1))
					arr[i][j]= 'n';
			}
		}
		for(char[] row : arr) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	public static void createTriangle(int n) {
		int[][] arr = new int [n][n];
		int num = 1;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new int [i+1];
			for(int j = 0; j < arr[i].length;j++) {
				arr[i][j] = num;
				num++;
			}
		}
		for(int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	public static void addZeros(int[][] arr) {
		int[][] arr2 = new int [arr.length][2*arr[0].length];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0, w=0; j < arr[i].length*2;j+=2, w++) {
				arr2[i][j] = arr[i][w];
				}
			}
		for(int[] row : arr2) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	public static void reverseIt(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][arr[i].length-1];
				arr[i][arr[i].length-j-1] = temp;		
			}
		}
		for(int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}
	}

	public static void main(String[] args) {
		createString((new char [][] {{'h','e','l'}, {'l','o'}}));
        createDiagonal(5);
		createTriangle(4);
		addZeros((new int [][] {{1,2,3}, {4,5,6}}));
		reverseIt((new int [][] {{1,2,3}, {4,5,6}}));
		}	
	}
