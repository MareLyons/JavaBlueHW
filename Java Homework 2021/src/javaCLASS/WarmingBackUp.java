package javaCLASS;

import java.util.Arrays;

public class WarmingBackUp {

	
	public static boolean alphabet(String str) {
			for(int i = 1; i < str.length()-1; i++) {
				if(str.charAt(i) < str.charAt(i-1)) {
					return false;
				}
			}
			return true;
	}
	
	public static String highestGrade(String [] names, int [] grades) {
		int maxI = 0;
		for(int i = 0; i < names.length; i++) {
			if (grades[maxI] > grades[i]) {
				maxI = i;
			}
		}
		return names[maxI];
	}
	

	public static int[] oddPerfSquares(int n) {
		int[] squares = new int[n];
		
		for(int i = 0, j = 1; i < n; i++, j+=2) {
			squares[i] = j*j;
		}
		return squares;
	}
	
	public static String every3(String str) {
		String newStr = "";
		for(int i = 0; i < str.length(); i+=3) {
			if(i % 2 == 0) {
				newStr += str.substring(i, i+3);
			}
		}
		if(str.length() % 6 < 3) {
			newStr += str.substring(str.length()- str.length()%6);
		}
		return newStr;
	}
	
	public static void main(String[] args) {
		System.out.print(alphabet("abcdef"));
		
		System.out.print(highestGrade(new String[] {"adam", "eric", "sarah", "mare"},(new int[] {90, 75, 89, 99})));

		System.out.print(Arrays.toString(oddPerfSquares(9)));
		
		System.out.print(every3("abcdefghijklmnop"));
	}
}
