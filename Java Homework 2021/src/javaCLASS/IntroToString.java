package javaCLASS;

public class IntroToString {
	
	//string is an object
	public static void secondHalf(String str){
		String print = str.substring(((str.length())/2));
		System.out.println(print);
	}

	public static void concatenateThis(String str, String str2){
		String newstr = str.substring(1);
		String newstr2 = str2.substring(1);
		System.out.println(newstr + newstr2);
	}
	
	public static void ifAdverb(String adverb){
		if(adverb.substring(adverb.length()-2).equals("ly")) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	
	}
	
	public static void switchOrder(String str) {
		
		for(int i = str.length()-1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
	}
	
	public static void wordSquare(String str) {
		for(int i = 0; i < str.length(); i++) {
				System.out.println(str);
				str = str.substring(1) + (str.charAt(0));
			}
	}
	
	public static void stringSandwitch(String littles, String bigs) {
		
		for(int i= 0; i <= bigs.length() - littles.length(); i++) {
			if(bigs.substring(i, i+littles.length()).equals(littles)){
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	
	
		
	}
	public static void main(String[] args) {
		secondHalf("hi there");
		concatenateThis("hello", "there");
		ifAdverb("quickly");
		stringSandwitch("happy", "py");
		 wordSquare("hello");
		switchOrder("hello");
		
	}

}
