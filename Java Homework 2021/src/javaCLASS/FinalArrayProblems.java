package javaCLASS;
import java.util.Arrays;

public class FinalArrayProblems {
	
	//Write a method that takes an array of doubles as parameter. 
	//Your method should print the index-weighted sum of this array. 
	//Index-weighting means multiplying each value of the array by it's 
	//index. So the first value would be multiplied by 0, the next by 1,
	//and so on. Then add these scaled values.
	public static void indexSum(double[] arr){
		double count = 0, weight = 0, sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			weight = count * arr[i]; 
			sum +=weight;
			count++;
		}
		System.out.print(sum);	
	}
	
	//Write a method that takes an array of characters, and converts 
	//it to a single string. However, this string will only contain 
	//the lowercase letters found in the array (non-lowercase characters 
	//can be ignored). Hint: use += to add a character to the end of a string.
	public static void charToString(char[] arr){
		String total = (" ");

		for(int i = 0; i < arr.length; i++) {
			if (arr[i] >= 97 && arr[i] <=122) {
				total += arr[i];	
			}
		}
		System.out.print((total));
		
	}
	
	//Write a method that takes an array of integers and an integer as 
	//parameters. The method should determine whether any two adjacent 
	//numbers in the array sum to the integer.
	public static void intToSum(int[] arr, int n){
		String solution = (" no");
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] + arr[i+1] == n) {
				solution = (" yes");
			}
		}
		System.out.print(solution);
	}
	
 
	public static void ifAnagram(int[] arr, int[] arr2){
		if(arr.length == arr2.length) {
			Arrays.sort(arr);
			Arrays.sort(arr2);

			if(Arrays.equals(arr, arr2)) {
				System.out.print(" anagram!!!!");
			}
			else {
				System.out.print(" not an anagram :(");	
			}	
		}
	}
	
	public static void main(String[] args) {
		indexSum(new double[] {30, 4.2, 5, 6});
		charToString(new char[] {'d', 'o', 'g', 's'});
		intToSum(new int[] {2,7,4,5,6,7}, (9));
		ifAnagram(new int[] {2,7,4,5,6,7},new int[] {5,6,4,2,7,7});
    }
}
