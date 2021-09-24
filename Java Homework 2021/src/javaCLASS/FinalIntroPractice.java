package javaCLASS;

public class FinalIntroPractice {
	
	// create your methods here
	public void distance(double x1, double y1, double x2, double y2) {
		System.out.println(Math.sqrt((Math.pow(x1-x2,2))+(Math.pow((y1-y2),2))));
	}
	
	public void quadratic(double a, double b, double c) {
		System.out.println((-b+(Math.sqrt((Math.pow(b,2)-(4*(a)*(c))))))/(2*a));
		System.out.println((-b-(Math.sqrt((Math.pow(b,2)-(4*(a)*(c))))))/(2*a));
	}
	public void charAverage(char char1, char char2) {
		int average = (char1+char2)/(2);
		System.out.println((char)average);
	}	
	
	
	public static void main(String[] args) {
		
		FinalIntroPractice tester = new FinalIntroPractice();
		
		// prints out the distance between two points
		// output should be 6.83
		tester.distance(1, -2.5, 3.1, 4);
		
		// prints out a solution to y = ax^2 + bx + c, where the 
		// three parameters are a, b, and c. Use the quadratic equation
		// output should be 2 or -2 (challenge: give both solutions)
		tester.quadratic(1, 0, -4);
		
		// prints out the 'average' of two characters
		// output should be 'W'
		tester.charAverage('m', 'A');
	}

}
