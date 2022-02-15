package javaCLASS;

public class Deck {
	//a constructor (which fills the array with the 52 possible different cards)
	//shuffle (which randomly mixes the Cards. How you shuffle the deck is up to you. If you'd like a challenge, try to simulate a real-life shuffle)
	//sort (which sorts the cards by num. Ignore the suit when sorting, so a sorted deck will be: 2,2,2,2,3,3,3,3,4,4,...)
	
	private Card[] deck;
	
	public Deck() {
		
		deck = new Card[52];
		
		for(int i = 1; i <= 13;i++) {
			deck[i-1] = new Card("clubs", i);
		}
		for(int i = 1; i <= 13;i++) {
			deck[i-1+13] = new Card("hearts", i);
		}
		for(int i = 1; i <= 13;i++) {
			deck[i-1+26] = new Card("diamonds", i);
		}
		for(int i = 1; i <= 13;i++) {
			deck[i-1+39] = new Card("spades", i);
		}
	}
	
	public String getRandom() {
		int i = (int)(Math.random()* 52 + 0);
		return deck[i].toString();
	}
	
	public Card[] getFirstN(int n) {
		Card[] cardarr = new Card[n];
		for(int i = 0; i < n; i++) {
			cardarr[i] = deck[i];
		}
			return(cardarr);
	}
	
	public void shuffle() {
		int[] indarr = new int[52];

		for(int i = 0; i < deck.length; i++) {
			int num = (int)(Math.random()* 52 + 0);
			for(int j = 0; j < indarr.length; j++) {
				if (num != indarr[i]) {
					indarr[i] = num;
				}
				else {
					num = (int)(Math.random()* 52 + 0);
				}
				}
			Card temp = deck[i];
			deck[i] = deck[num];
			deck[num] = temp;
		}
			
	}

	
	public Card[] sort() {
		
		for(int i = 0; i < deck.length; i++) {
			int min =Integer.MAX_VALUE;
			int minI = i;
			for(int j = 0; j < deck.length; j++) {
					if(deck[j].getNumber() < min){
						min = deck[j].getNumber();
						minI = j;
					}
				}
			Card temp = deck[i];
			deck[i] = deck[minI];
			deck[minI] = temp;
		}
		return deck;
	}

	
	public String toString() {
		String output = "";
				
		for(Card c:deck) {
			output += c.toString();
		}
		return output;
	}
}
