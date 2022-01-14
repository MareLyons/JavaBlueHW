package javaCLASS;

import java.util.Arrays;

public class Morewith2DArrays {
	
	public static void nByM(int n, int m){
		int[][] arr = new int [n][m];
		int num = 1;
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
	
	public static void max(double[][] arrdoub) {
		int maxI = 0;
		int maxJ = 0;
		for(int i = 1; i < arrdoub.length; i++) {
			for(int j = 0; j < arrdoub[i].length;j++) {
				if(arrdoub[i][j] > arrdoub[maxI][maxJ]){
				maxI = i;
				maxJ = j;
				}
			}
		}	
		System.out.println(arrdoub[maxI][maxJ]);
	}

	public static void average(int[][] intarr) {
		double sum = 0;
		int count = 0;
		for(int i = 0; i < intarr.length; i++) {
			for(int j = 0; j < intarr[i].length;j++) {
				sum += intarr[i][j];
				count += 1;
			}
		}
		System.out.println(sum/count);
	}
	
	
	public static void sumRow(int[][] intarr) {
		int[] newArr = new int[intarr.length];
		int rowsum = 0;
		for(int i = 0; i < intarr.length; i++) {
			for(int j = 0; j < intarr[i].length;j++) {
			rowsum += intarr[i][j];
			newArr[i] = rowsum;
			}
			rowsum = 0;
		}
		System.out.println(Arrays.toString(newArr));

	}
	
	public static void ifMagic(int[][] intarr) {
		int[] newArr = new int[intarr.length];
		int rowssum = 0;
		int columnsum = 0;
		int diagonalsum = 0;
		for(int i = 0; i < intarr.length; i++) {
			for(int j = 0; j < intarr[i].length;j++) {
				rowssum += intarr[i][j];
				newArr[i] = rowssum;
			}
			rowssum = 0;
			}
		for(int i = 0; i < intarr.length; i++) {
			for(int j = 0; j < intarr[i].length;j++) {
				columnsum += intarr[i][j];
				newArr[i] = columnsum;
			}
			columnsum = 0;
		}
		for(int i = 0; i < intarr.length; i++) {
				diagonalsum += intarr[i][i];
				newArr[i] = diagonalsum;
			}
			diagonalsum = 0;

		if(newArr[0] == newArr[1] && newArr[0] == newArr[2]) {
			System.out.print("yes this is magic");
		}
		else {
			System.out.print("no this is not magic");
		}
	}



	public static void main(String[] args) {
		nByM(5,6);
		max(new double [][] {{10.1,12.2}, {26,3.8}, {1,2}});
		average(new int [][] {{10,12}, {26,38}, {1,2}});
		sumRow(new int [][] {{5,6}, {3,5,6}, {4,5}});
		ifMagic(new int [][] {{4,5,2}, {2,4,5}, {5,2,4}});	
	}
}
