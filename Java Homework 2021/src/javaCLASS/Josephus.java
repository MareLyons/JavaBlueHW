package javaCLASS;

import java.util.ArrayList;

public class Josephus {
	
	public static int josephus(int n) {
		
		ArrayList<Integer> people = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			people.add(i);
		}
		
		int die = 1;
		
		while(people.size() > 1) {
			people.remove(die);
			
			die = (die + 1)%people.size();
			
		}
		
		return(people.get(0));

	}
	
	public static void main(String[] args) {
		
		System.out.println(josephus(6));
			
	}

}
