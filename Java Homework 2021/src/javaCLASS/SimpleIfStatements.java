package javaCLASS;

public class SimpleIfStatements {
	
	// create your methods here
	public void ifPositive(double x) {
		if (x>0) {
			System.out.println("yes");
		}
		else if (x<0) {
			System.out.println("no");
		}
		else {
			System.out.println("thats zero");
		}

	}
	
	public void oddEven(double x) {
		if (x%2 == 0) {
			System.out.println("even");
		}
		else if (x%2 == 1) {
			System.out.println("odd");
		}
	}

	public void upperLower(char x) {
		if (x>64 && x<91) {
			System.out.println("Uppercase");
		}
		else if (x>96 && x<123) {
			System.out.println("Lowercase");
		}
		else {
			System.out.println("Neither");
		}
	}
	
	public void multipleOf10(double x) {
		if (x%10 == 0) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}
	
	public void largestDouble(double x, double y, double z) {
		if (x>y && x>z) {
			System.out.println(x);
		}
		if (y>x && y>z) {
			System.out.println(y);
		}
		if (z>y && z>x) {
			System.out.println(z);
		}
	}
	
	
	public static void main(String[] args) {	
		
		SimpleIfStatements tester = new SimpleIfStatements();
		
		tester.ifPositive(-2);
		
		tester.oddEven(21);
		
		tester.upperLower('#');
		
		tester.multipleOf10(99);
		
		tester.largestDouble(4.4, 3.4, 3);
		
		
		


	}
}