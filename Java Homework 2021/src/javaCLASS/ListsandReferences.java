package javaCLASS;

import java.util.ArrayList;

public class ListsandReferences {
//	Write a method that takes a list of characters as a parameter. 
//	These characters should then be concatenated to form one String. 
//    For example: ['h','e','l','l','o']     -->     "hello"
	public static String concatenated(ArrayList<Character> charList) {
		String total = "";
		for(int i = 0; i < charList.size(); i++) {
			total = total + charList.get(i);	
		}
		return total;
		
	}
//
//Write a method that takes a list of doubles as parameter. It should then do the 
//following: average the numbers in the list. Set the first value in the list to this 
//average. Repeat this step, but now set the second element in the list to the average 
//with this new value. Repeat until you have changed each element in the list to an average. 
//     For example: [3.0, 6.0, 1.0, 8.0, 19.0] -->  [7.4, 8.3, 8.7, 10.3, 10.7]
	public static ArrayList<Double> superAverage(ArrayList<Double> doubList) {
		
		for(int i = 0; i < doubList.size(); i++) {
			double average = 0;
			double sum = 0;

			for(int j = 0; j < doubList.size(); j++) {
				sum += doubList.get(j);
				average = sum/doubList.size();
			}
			doubList.remove(i);
			doubList.add(i,average);
		}
		return doubList;
	}
//
//Write a method that takes an array of integers as parameter. It should then do 
//	the following: add the first element to the list. Next, add the first two elements 
//	to the list. Next, add the first 3 elements to the list. Continue this until you reach a step
//	where you add all the elements of the array to the list.
//    For example: [3, 1, 4, 2]  --> [3, 3, 1, 3, 1, 4, 3, 1, 4, 2]
	public static ArrayList<Integer> superAddition(int[]arr) {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		for(int i = 0; i <= arr.length; i++) {
			for(int j = 0; j < i; j++) {
				intList.add(arr[j]);
			}
		}
		return(intList);
	}
	
	public static void main(String[] args) {
		ArrayList<Character> charList = new ArrayList<Character>();
		charList.add('h');
		charList.add('e');
		charList.add('l');
		charList.add('l');
		charList.add('o');
		System.out.println(concatenated(charList));
		
		ArrayList<Double> doubList = new ArrayList<Double>();
		doubList.add(3.0);
		doubList.add(6.0);
		doubList.add(1.0);
		doubList.add(8.0);
		doubList.add(19.0);
		System.out.println(superAverage(doubList));
		
		System.out.println(superAddition(new int[] {3, 1, 4, 2}));
	}

}
