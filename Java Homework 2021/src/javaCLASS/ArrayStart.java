package javaCLASS;

import java.util.Scanner;

public class ArrayStart{
	
	public static  void display(int[] arr) {
		for(int num: arr) { 
			System.out.print(num + ", ");
			}
		}
	public static  void onetoN(int n) {
		int [] list  = new int[n];
		for(int i = 1; i <= n; i++) { 
			list[i-1]+=i;
			}
		System.out.println(" ");
		display(list);
		}
	public static void swap(int[] arr2) {
		int firstnum =  arr2[0];
		arr2[0] = arr2[arr2.length-1];
		arr2[arr2.length-1] = firstnum;
		System.out.println(" ");
		display(arr2);
	}
	public static void userArray(int n) {
		int [] list2  = new int[n];
		for(int i=0; i < n; i++) {
			System.out.println("enter a number: ");
			Scanner input = new Scanner(System.in);
			int num = input.nextInt();
			list2[i] = num;
		}
		display(list2);
	}

	public static void reverse(int[] arr3) {
		for(int i=arr3.length-1; i >= 0; i--) {
			System.out.print(arr3[i] + ", ");
		}
	
		
	}
	//oneToN: this should create an array holding the numbers 1 to n (inclusive), where n is an integer parameter. Then print it (use your display method to print!).
	//swap: this should swap the first and last elements of a parameter array, then print it.
	//userArray: a method that takes in integers from the user and adds them to an array until they have typed in n (a parameter) numbers - use a scanner. Then print the array 
	//reverse: reverses the array that's given as a parameter. Then print the reversed array. You may either create a new array that contains the reversed elements (easier), or reverse the original array (harder).

		// this line should have a slope of 2
		
	
	public static void main(String[] args) {
		//display(new int[ ] {1, 54, 74, 2, 7});
		//onetoN(4);
		//swap(new int[ ] {20, 1, 2, 3, 22});
		//userArray(5);
		reverse(new int[ ] {1, 2, 3, 4, 5});

}
}



	
