package javaCLASS;
import java.util.Scanner;


public class MoreWithLoops {
	
	private static Scanner input = new Scanner(System.in);

	public void checkInteger() {
		
		int x = 5;
		
		System.out.println("  ");
		System.out.println("enter a number");
		int num = input.nextInt();
	
		while (num != x) {
			System.out.println("  ");
			System.out.println("enter a number");
			num = input.nextInt();
		if (x == num) {
		    System.out.println("You guessed the #");
		}
		}
	}
	public void negToPos(){
			
		System.out.println("enter another number");
		int num = input.nextInt();
		
		for (int i = -num; i <= num; i++) {
			System.out.print(i);
			System.out.println("  ");

		}
		}
	
	public void hiInt(){
			
		int count = 0;
		System.out.println("  ");
		System.out.println("enter a third number");
		int num = input.nextInt();
			
		while(count < num) {
			System.out.print("hi ");
			count ++;
		}
		}
		
	public void lesserDivisors(){

		System.out.println("  ");
		System.out.println("enter a fourth number");
		int num = input.nextInt();
				
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				System.out.print(i);
				System.out.println("  ");
			}
		}
			}

			
	

	public void simpleGame(){

		System.out.println("  ");
		System.out.println("would you like to play a game?");
		String answer = input.nextLine();
		
		while (answer.equals("yes")) {
			System.out.println("would you like to play a game?");
			answer = input.nextLine();
		
			if (answer.equals("no")) {
			System.out.print("gameover");
			}
		}
		}
	
	public void lcm() {
		System.out.println("  ");
		System.out.println("enter 2 numbers");
		int num1 = input.nextInt();
		int num2 = input.nextInt();

		for (int i = Math.max(num1,num2); i <= num1*num2; i+= Math.max(num1,num2)) {
			
			if (i%Math.min(num1,num2)==0) {
				System.out.println(i);
			break;
			}
		}
	}
	

		
		
		
	
		public static void main(String[] args) {
			MoreWithLoops tester = new MoreWithLoops();

			//tester.checkInteger();
			
			//tester.negToPos();
			
			//tester.hiInt();
			
			//tester.lcm();
			
			//tester.lesserDivisors();
			
			tester.simpleGame();
			


}
}

		
		

