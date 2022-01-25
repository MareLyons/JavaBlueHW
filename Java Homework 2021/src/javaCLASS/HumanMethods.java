package javaCLASS;

public class HumanMethods {

	private int age, age2;
	private char gender, gender2;
	
	// an example method to use as a guideline
	public void age(int x) {
		age = x;
	}
	public void gender(char y) {
		gender = y;
	}
	
	public void age2(int x) {
		age2 = x;
	}
	public void gender2(char y) {
		gender2 = y;
	}
	
	public void canVote() {
		if (age >= 18) {
			System.out.println("yes you can vote");
		}
		else if (age < 18){
			System.out.println("no you cannot vote");
		}
	}
		
	public void needsTetnus() {
		if (age % 4 == 0) {
			System.out.println("yes, you need a tetnus shot");
		}
		else {
			System.out.println("no, you do not need a tetnus shot");
		}
	}
	
	public void ifToddler() {
		if (age < 4 && gender == 'g') {
			System.out.println("Toddler Girl");
		}
		else if (age < 4 && gender == 'b') {
			System.out.println("Toddler Boy");
		}
		else {
			System.out.println("Not a Todler");
		}
	}
	
	public void movieDiscount() {
		if (age < 12 || age > 65) {
			System.out.println("yes you get a discount");
		}
		else {
			System.out.println("no discount");
		}		
	}
	public void ifTeenager() {
		if (age >= 12 && age <=18) {
			System.out.println("teenager");
		}
		else {
			System.out.println("not a teenager");
		}		
	}
	



		public static void main(String[] args) {	
			
			HumanMethods tester = new HumanMethods();
			
			tester.age(4);
			
			tester.gender('b');
			
			tester.age2(4);
			
			tester.gender2('b');
			
			tester.canVote();
			
			tester.needsTetnus();
			
			tester.ifToddler();
			
			tester.movieDiscount();
			
			tester.ifTeenager();
					
	
	
		}
}
	
