package javaCLASS;

import java.util.Arrays;

public class ImportantArrayAlgs {
	
	public static int biggestArray(int[] arr3) {
		int maxI = 0;
		for(int i = 1; i < arr3.length; i++) {
			if(arr3[i] > arr3[maxI]){
				maxI = i;
			}
		}	
		return(maxI);
	}

	public static String[] reverse(String[] arr) {
		for(int i=0; i < arr.length/2; i++) {
			String temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
		}	
		return arr;
	}
	
	public static double avergae(int[] arr) {
		double sum = 0;
		for(int num: arr) {
			sum += num;
		}
		return(sum/arr.length);
	}
	
	public static char[] merge(char[] arr, char[] arr2) {
		char[] newArr = new char[arr.length +arr2.length];
		
		for(int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		for(int i = arr.length; i < arr.length + arr2.length; i++) {
			newArr[i] = arr2[i];
			
		}
		return newArr;
	}

	public static void main(String[] args) {
//		biggestArray(new int[] {-1, -54, 74, 2, 7});
		System.out.println(biggestArray(new int[] {-1, -54, 74, 2, 7}));
		
		reverse(new String[] {"-1, -54, 74, 2, 7"});
		System.out.print(reverse(arr));
		
		average(new double[] {-1, -54, 74, 2, 7});
		System.out.print(average(arr));
		
		char [] ans = merge(new char[] {'5'}, new char[]{'7', '2', '7'});
		System.out.print(Arrays.to.String(ans));
		


		
	}
}
