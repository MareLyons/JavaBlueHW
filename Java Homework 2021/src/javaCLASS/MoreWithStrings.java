package javaCLASS;

import java.util.Arrays;

public class MoreWithStrings {

	public static boolean twoSame(String str) {
		String firsttwo = (str.substring(0,2));
		String lasttwo = (str.substring(str.length()-1,str.length()));
		return(firsttwo.contains(lasttwo));
	}

	public static void ifInside(String str, String str2) {
		for(int i = 0; i < str2.length(); i++) {
			if(str.contains(str2.substring(i,i+1))) {
				System.out.print("yes ");
			}
			else{
				System.out.print("no ");
			}
		}
	}
	
	public static void manyWords(String str) {
		int wordcount = 1;
		for(int i = 0; i < str.length(); i++) {
			if(str.substring(i, i+1).equals(" ")) {
				wordcount ++;
		}
		
		}
		System.out.println(wordcount);
	}
	
	public static void noE(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(str.substring(i, i+1).equals("e")) {
				str  =  str.substring(0,i) + str.substring(i+1);
			}
		}
		System.out.print(str);

	}
	
	public static void stringToArray(String str) {
		String [] newArr =  str.split(" ");

		System.out.println(Arrays.toString(newArr));
	}

	
	public static void main(String[] args) {
		System.out.println(twoSame("sand"));
		ifInside("hello",  "leg");
		manyWords("I love CS");
		noE("take out the e");
		stringToArray("I love CS");
	}
}
