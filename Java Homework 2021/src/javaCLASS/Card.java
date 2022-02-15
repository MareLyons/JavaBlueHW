package javaCLASS;

public class Card {
	//a constructor
	//toString
	//any appropriate get methods you may need
	
	private int number;
	private String suit;

	public Card(String s, int number) {
		this.number = number;
		suit = s;
	}
	public int getNumber() {
		return number;
	}
	public String suit() {
		return suit;
	}
	public String toString() {
		return number + " of " + suit + ",";
	}
	
}
