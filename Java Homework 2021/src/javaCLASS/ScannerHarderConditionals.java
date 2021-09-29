package javaCLASS;

import java.util.Scanner;

public class ScannerHarderConditionals {


	public void digitsTogether() {
		Scanner input = new Scanner(System.in);
		System.out.println("enter 4 numbers: ");
		
		int w = input.nextInt();
		int x = input.nextInt();
		int y = input.nextInt();
		int z = input.nextInt();
		
		System.out.print(z);
		System.out.print(y);
		System.out.print(x);
		System.out.print(w);


	}

	public void strOperation() {
		Scanner input = new Scanner(System.in);
		System.out.println("  ");
		System.out.println("enter a word/symbol and 2 integers: ");
		
		String myStr = input.nextLine();
		int x1 = input.nextInt();
		int x2 = input.nextInt();

		if (myStr.equals("+")) {
			System.out.print(x1+x2);
		}
		else if (myStr.equals("-")) {
			System.out.print(x1-x2);
		}
		else if (myStr.equals("*")) {
			System.out.print(x1*x2);
		}
		else if (myStr.equals("/")) {
			System.out.print(x1/x2);
		}
		else if (myStr.equals("%")) {
			System.out.print(x1%x2);
		}
		else {
			System.out.print(myStr + (char)x1+ (char)x2);
		}
	}

		public void scoringFootball() {
			Scanner input = new Scanner(System.in);
			System.out.println("  ");
			System.out.println("enter a number of touch downs, number of field goals and a total score ");
			
			int td = input.nextInt();
			int fg = input.nextInt();
			int ts = input.nextInt();
			
			if (td*7+(fg*3) == (ts)){
				System.out.print("yes");	
			}
			else {
				System.out.print("no");
			}
		}
		
		public void largestDigit() {
			Scanner input = new Scanner(System.in);
			System.out.println("  ");
			System.out.println("enter a number between 0 and 999");
			
			int num = input.nextInt();

			double d1 =((double)num%10);
			double d2 =((double)num/100);
			double d3 =((double)num%100/10);
			
			if (d1>d2 && d1>d3) {
				System.out.println((int)d1);
			}
			else if (d2>d1 && d2>d3) {
				System.out.println((int)d2);
			}
			else if (d3>d1 && d3>d2) {
				System.out.println((int)d3);
			}


		}



	
	public static void main(String[] args) {
		ScannerHarderConditionals tester = new ScannerHarderConditionals();

		tester.digitsTogether();
		
		tester.strOperation();

		tester.scoringFootball();
		
		tester.largestDigit();
	}
	
	}