package javaCLASS;

public class MathMethods {

	private double w;
	
	// an example method to use as a guideline
	public void halve(double x) {
		System.out.println(x/2);
	}
	
	// I'll give you the first method's outline to fill in. For the rest, you're in charge of 
	// declaring the entire method.
	public void square(int x) {
		double expo = Math.pow(x,2);
		System.out.println(expo);
	}
	
	// create your own methods here
	public void averageFive(int num1, int num2, int num3, int num4, int num5) {
		double sum = (num1+num2+num3+num4+num5);
		System.out.println(sum/5);
	}
		
	public void raiseToTheFourth(int y) {
		double pwr = Math.pow(y,4);
		System.out.println(pwr);
	}
	
	public void setKey(int x) {
		w = x;
	}
	
	public void multiplyByKey(int f) {
		System.out.println(w*f);
	}
	
	public void keyCubed() {
		System.out.println(Math.pow(w,3));
	}
	
	public void makeInteger(double a) {
		System.out.println((int) a);
	}
	
	public void roundToNearestWhole(double b) {
		 if(b%100 >=5) {
			System.out.println((int) b + 1);
		 if(b%100 <5) {
			System.out.println((int) b);
		 }
		 }
	}
	
		
	
		
	public static void main(String args[]) {
		
		MathMethods tester = new MathMethods();
		
		// example method
		// output: 4
		tester.halve(8);
		
		// you are in charge of making the rest of these work
		
		// output: 49
		tester.square(7);
		
		// output: 7
		tester.averageFive(7,10,5,7,6);
		
		// output: 81
		tester.raiseToTheFourth(3);
		
		// output: nothing, just save the number 4 as an instance variable
		tester.setKey(4);
		
		// output: 28
		tester.multiplyByKey(7);
		
		// output: 64
		tester.keyCubed();
		
		// output: 3
		tester.makeInteger(3.756);
		
		// output: 8
		tester.roundToNearestWhole(7.8);
	}

}

