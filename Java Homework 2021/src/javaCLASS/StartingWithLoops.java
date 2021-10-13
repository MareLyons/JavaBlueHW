package javaCLASS;

import java.util.Scanner;

public class StartingWithLoops {
	
	public void numbersBetween(int x, int y) {

		//definite finite 
		while ((x)!=(y)){
			if (x < y) {
				System.out.println(x++);	
			}
			else if (y < x) {
				System.out.println(y++);
			}
		}
		System.out.println(x);

		}

	    //definite finite 
		public void exponents(double b, double a) {

			int x = 0;
			
			while (x < 6){
				System.out.println(a*(Math.pow(b, x)));
				
				 x++;
				}
		}
		
		//definite finite
		public void squareRoot(int x) {
			
			int y = 0;
			while ((Math.pow(y, 2)) <= x) {
				if (Math.pow(y, 2) ==  x){
					System.out.println(y);
					break;
				}
				y++;
				}
			if(Math.pow(y, 2) > x)
				System.out.println("does not have a root");
	
			}
		
		//definite finite
		public void amountIntegers(int n) {
			int counter = 0;
			System.out.println("  ");
			System.out.println("enter " + n + " integers");
			Scanner input = new Scanner(System.in);
			int num = input.nextInt();
			int max = 0;
					
			while (counter <= n-2){			
				counter ++;
				num = input.nextInt();
				System.out.println(counter);
				if (num > max){ 
					max = num;
				}
			}
			
			System.out.print(max);
				
			
			}
			
			

	public static void main(String[] args) {
		StartingWithLoops tester = new StartingWithLoops();
		
		//tester.numbersBetween(1, 17);
		//tester.exponents(2, 3);
		//tester.squareRoot(15);
		tester.amountIntegers(12);
}
}
