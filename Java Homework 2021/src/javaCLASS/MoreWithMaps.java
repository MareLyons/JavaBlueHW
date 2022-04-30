package javaCLASS;

import java.util.HashMap;
import java.util.Map;

public class MoreWithMaps {
	
	public static void companyValues(Map<String, Integer> Map,String companyname) {
		if(companyname.equals("average")) {
			int sum = 0;
			for(int i: Map.values()) {
				sum += i;
			}
			System.out.println(sum/Map.size());;
		}
		else if(Map.containsKey(companyname) != true) {
			int maxI = 0;
			for(int i: Map.values()) {
				if(i > maxI) {
					maxI = i;
				}
			}
			System.out.print(maxI);
		}
		else {
			System.out.print(Map.get(companyname));	
		}
	}
	
	public static void doubleONine(Map<String, String> hitlist, String name) {
		String curr = hitlist.get(name);
		System.out.print(name + "-->" + hitlist.get(name) + ", ");
		while(!name.equals(curr)) {
			System.out.print(curr + "-->" + hitlist.get(curr)+ ", ");
			curr = hitlist.get(curr);
		}	
	}
	
	public static void morseCode(Map<String, String> morsecode, String word) {
		for(int i = 0; i < word.length(); i++) {
			System.out.print(morsecode.get(word.substring(i, i+1)));
		}
	}


	public static void main(String[] args) {

		HashMap<String, Integer> Map = new HashMap<String, Integer>();

		Map.put("apple", 1000);

		Map.put("ibm", 0);

		Map.put("tesla", 500);
		
		companyValues(Map, "average");


 

		HashMap<String, String> hitlist = new HashMap<String, String>();

		hitlist.put("Ryan", "Yumna");

		hitlist.put("Cooper", "Anika");

		hitlist.put("Anika", "Ryan");

		hitlist.put("Yumna", "Cooper");
		
		doubleONine(hitlist, "Ryan");
		
		HashMap<String, String> morsecode = new HashMap<String, String>();

//		morsecode.put("a", "* _");
//		morsecode.put("b", "_ * * *");
//		morsecode.put("c", "_ * _ *");
//		morsecode.put("d", "_ * *");
//		morsecode.put("e", "*");
//		morsecode.put("f", "* * _ *");
//		morsecode.put("g", "_ _ *");
//		morsecode.put("h", "* * * *");
//		morsecode.put("i", "* *");
//		morsecode.put("j", "* _ _ _");
//		morsecode.put("k", "_ * _");
//		morsecode.put("l", "* _ * *");
//		morsecode.put("m", "_ _");
//		morsecode.put("n", "_ *");
//		morsecode.put("o", "_ _ _");
//		morsecode.put("p", "* _ _ *");
//		morsecode.put("q", "_ _ * _");
//		morsecode.put("r", "* _ *");
//		morsecode.put("s", "* * *");
//		morsecode.put("t", "_");
//		morsecode.put("u", "* * _");
//		morsecode.put("v", "* * * _");
//		morsecode.put("w", "* _ _");
//		morsecode.put("x", "_ * * _");
//		morsecode.put("y", "_ * _ _");
//		morsecode.put("x", "_ _ * *");
		
		morsecode.put("a", "a");
		morsecode.put("b", "b");
		morsecode.put("c", "c");
		morsecode.put("d", "d");
		morsecode.put("e", "e");
		morsecode.put("f", "f");
		morsecode.put("g", "g");
		morsecode.put("h", "h");
		morsecode.put("i", "i");
		morsecode.put("j", "j");
		morsecode.put("k", "k");
		morsecode.put("l", "l");
		morsecode.put("m", "m");
		morsecode.put("n", "n");
		morsecode.put("o", "o");
		morsecode.put("p", "p");
		morsecode.put("q", "q");
		morsecode.put("r", "r");
		morsecode.put("s", "s");
		morsecode.put("t", "t");
		morsecode.put("u", "u");
		morsecode.put("v", "v");
		morsecode.put("w", "w");
		morsecode.put("x", "x");
		morsecode.put("y", "y");
		morsecode.put("x", "x");
		morseCode(morsecode, "doggery");
	}

}
