package javaCLASS;

public class operationsandmethods {


	public static void printInt(int yourInteger) {
		
		char newInteger = (char) yourInteger;

		System.out.println(newInteger);
	}


	public static void lastDigit(int anotherInteger){
		
		
		System.out.println(anotherInteger%10);
	}
	
	public static void averages(int num1, int num2) {
		
		double sum = (num1+num2);
		
		double average = (sum/2);

		System.out.println(average);
	}
	

	public static void main(String[] args) {
	
		printInt(97);
		
		lastDigit(5032);
		
		averages(16, 17);
	
	}
}