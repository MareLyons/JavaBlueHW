package javaCLASS;

import java.util.Arrays;

public class MoreArrayPractice {

	public static void  negPos(int[] arr) {
		String[] stringarr = new String[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				stringarr[i] = "neg";
			}
			else if (arr[i] > 0) {
				stringarr[i] = "pos";
			}
			}
		System.out.print(Arrays.toString(stringarr));
		}
		
	
	public static boolean  inChar(char[] arr, char n) {
		boolean charinarray = false;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == n){
				charinarray = true;	
			}
		}
		System.out.println(" ");
		return(charinarray);
	}
	
	public static int  inString(String[] arr, String n) {
		int count = 0;
		for(int i = 0; i < arr.length; i++)
			if (arr[i] == n){
				return(i);
			}
		return count;
	}
		
	public static void commonNumbers(int[] arr1, int[] arr2) {
		
		for(int i = 0; i<arr1.length; i++) {
			for(int j = 0; j <arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
						System.out.print(arr1[i] + " ");
				}
			}
		}
	}
	
	public static int[] digits(int n) {
		int[] arr = new int[String.valueOf(n).length()];
		
		for(int i = arr.length-1; i >= 0; i--) {
			arr[i] = n % 10;
			n /= 10;
		}
		return(arr);
	}
	
	public static void uniqueNums(int[]arr) {
	    for (int i = 0; i < arr.length; i++) {
	        boolean unique = false;
	        for (int j = 0; j < i; j++)
	            if (arr[i] == arr[j]) {
	            	unique = true;
	                break;
	            }
	        if (!unique)
	            System.out.print(arr[i] + " ");
	   		 	
			}
		}
	
	
	public static String[] combineWords(char[]arr, char[] arr2) {
		String[] words = new String[arr.length];
		String word = ("");
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr2.length; j++) {
			 word = ("" + word + arr2[j]);
		}
		words[i] = arr[i]+word;
		}
		return(words);
	}
	

	public static void main(String[] args) {
		negPos(new int[ ] {1, -1, 7, -54, 5});
		
		System.out.println(inChar(new char[ ] {'c', 'd', 'z', 'a', 'g'}, 'c'));
		
		System.out.println(inString(new String[ ] {"wow", "cool", "compute", "stem", "mare"}, "mare"));
		
		commonNumbers(new int[ ] {1, -1, 7, -54, 5}, new int[ ] {1, -1, 7, -54, 5});
		
		System.out.println(Arrays.toString(digits(320)));
		
		uniqueNums(new int[ ] {2, 4, 2, 6, 7});
		
		System.out.println(Arrays.toString(combineWords((new char[ ] {'w', 'c'}), new char[ ] {'a', 'v', 'e'})));
		
	}
}
