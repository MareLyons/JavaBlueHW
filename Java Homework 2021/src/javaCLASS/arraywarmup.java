package javaCLASS;

import java.util.Arrays;

public class arraywarmup {

	
	public static void  printWord(String[] arr) {
		for(String num:arr) {
			System.out.print(num + " ");
		}	
	}
	
	public static void newArr(int n) {
		int [] arr2  = new int[n];
		for(int i = 0; i < n; i++) {
			arr2[i] = i+1;
		}
		System.out.println(Arrays.toString(arr2));
		}
	
	public static void average(int [] arr) {
		double sum = 0;
		for(int num: arr) {
		sum += num;
		}
		System.out.println(sum/arr.length);
	}

	public static void doubling(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = arr[i]*2;
		}
		System.out.println(Arrays.toString(arr));
	}

	
	public static void fibO(int n) {
		int[] arr = new int[n];
		arr[0] = 0;
		
		if(n > 1){
			
			arr[1] = 1;
			
			for(int i = 2; i < arr.length; i++)
				arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void ifDivisable(int[] arr) {
		String[] newArr = new String[arr.length-1];	
		for(int i = 1; i < arr.length-1; i++) {
			if(arr[1] % arr[0] == 0) { 
				newArr[0] = "yes";
			}
				else {
					newArr[0] = "no";
				}
			if(arr[i+1] % arr[i] == 0) { 
				newArr[i] = "yes";
			}
			else {
				newArr[i] = "no";
			}
		}
		System.out.println(Arrays.toString(newArr));
	}
	
	public static void risingAvg(int[] arr){
		
		double[] avg = new double[arr.length];
		
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			avg[i] = (double)sum/(i+1);
		}
		System.out.println(Arrays.toString(avg));
	}
	
	public static void main(String[] args) {
		//printWord(new String[ ] {"okay", "dog", "cat", "mouse", "CS"});
		//newArr(6);
		//average(new int[] {-1, -54, 74, 2, 7});
		//doubling(new int[] {-2, 2, 7, 18, 0});
		//fibO(8);
		ifDivisable(new int[] {8, 3, 12, 5, 15, 45});
		//risingAvg(new int[] {5, 5, 2, 4, 5, 6, 7});
    }
}
	
