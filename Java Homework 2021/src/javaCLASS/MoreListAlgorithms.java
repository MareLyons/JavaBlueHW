package javaCLASS;

import java.util.ArrayList;

public class MoreListAlgorithms {
	
	public static ArrayList<Integer> randNums(int n, int x) {
		
		ArrayList<Integer> numList = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			numList.add((int) (Math.random()*2*x + -x));	
		}
		return(numList);	
	}

	public static void posNeg(ArrayList<Integer> intList) {
		
		ArrayList<Integer> negList = new ArrayList<Integer>();
		ArrayList<Integer> posList = new ArrayList<Integer>();
		
		for(int i = 0; i < intList.size(); i++) {
			if(intList.get(i) >= 0) {
				posList.add(intList.get(i));
			}
			else {
				negList.add(intList.get(i));
			}
		}
		System.out.print(negList);	
		System.out.print(posList);
	}

	public static void reverse(ArrayList<Double> doubList) {
		for(int i = 0; i < doubList.size(); i++) {
			doubList.add(0, doubList.remove(i));
		}
	}
	
	public static void main(String[] args) {
		
		System.out.print(randNums(3,5));
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(-3);
		intList.add(-4);
		intList.add(0);
		posNeg(intList);
		
		ArrayList<Double> doubList = new ArrayList<Double>();
		doubList.add(1.2);
		doubList.add(2.2);
		doubList.add(3.2);
		doubList.add(4.2);
		doubList.add(5.2);
		System.out.print(doubList);
		reverse(doubList);
		System.out.print(doubList);



		
	}
}
