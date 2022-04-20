package javaCLASS;

import java.util.ArrayList;

public class CW48 {

	
	//Write a method that returns a collection holding the index of 
	//each relative maximum in an array of doubles. A relative maximum 
	//is greater than the numbers on either side of it. 
	
	public static ArrayList<Double> relativeMAX(ArrayList<Double> doubList) {
		ArrayList<Double> relativemax = new ArrayList<Double>();

		for(int i = 0; i < doubList.size(); i++) {
			if(i == 0) {
				if(doubList.get(i)>doubList.get(i+1)){
					relativemax.add(doubList.get(i));
				}
			}
			else if(i == doubList.size()-1) {
				if(doubList.get(i)>doubList.get(i-1)){
					relativemax.add(doubList.get(i));
				}
			}
			else {
				if(doubList.get(i)>doubList.get(i-1) && doubList.get(i)> doubList.get(i+1)){
					relativemax.add(doubList.get(i));
				}
			}
		}
	return(relativemax);
		
}


	
	
public static void main(String[] args) {
		
	ArrayList<Double> doubList = new ArrayList<Double>();
	doubList.add(1.1);
	doubList.add(2.0);
	doubList.add(1.2);
	doubList.add(4.0);
	doubList.add(5.0);
	System.out.println(relativeMAX(doubList));
		
}
}
