package javaCLASS;
import java.util.ArrayList;

public class GettingtoKnowLists {

	public static ArrayList<Character> everySecond(ArrayList<Character>charList) {
		for(int i = 0; i < charList.size(); i++) {
			charList.remove(i);
		}
		return(charList);	
	}


	public static ArrayList<String> arrayToString(String [] array) {
		ArrayList<String> myList = new ArrayList<String>();
		
		for(int i = 0; i < array.length; i++) {
			myList.add(0, array[i]);
		}
		return(myList);	
	}

	public static ArrayList<Double> doubles(ArrayList<Double> doubleList) {
		for(int i = 0; i < doubleList.size(); i++) {
			doubleList.set(i,doubleList.get(i)*2);
		}
		return(doubleList);	
	}

	public static ArrayList<Character> alphabet(int n) {
		ArrayList<Character> alphabetList = new ArrayList<Character>();
		int alphabetcount = 97;
		for(int i = 0; i < n; i++) {
			if(alphabetcount%2 == 0) {
				alphabetList.add((char)(alphabetcount));
			}
			else if(alphabetcount%2 != 0) {
				alphabetList.add(0,(char)(alphabetcount));
			}
			alphabetcount++;
		}
		return(alphabetList);	
	}
	
	public static void main(String[] args) {
		
		ArrayList<Character> charList = new ArrayList<Character>();
		charList.add('a');
		charList.add('b');
		charList.add('c');
		charList.add('d');
		charList.add('e');
		System.out.println(everySecond(charList));
		
		
		System.out.println(arrayToString(new String[]{"lists", "are", "great"}));
		
		ArrayList<Double> doubleList = new ArrayList<Double>();
		doubleList.add(18.2);
		doubleList.add(18.0);
		doubleList.add(2.2);
		doubleList.add(200.1);
		System.out.println(doubles(doubleList));

		System.out.println(alphabet(8));
		
	}
}

