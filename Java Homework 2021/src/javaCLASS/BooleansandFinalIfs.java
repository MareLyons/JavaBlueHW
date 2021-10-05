package javaCLASS;

import java.util.Scanner;

public class BooleansandFinalIfs {
	
	private int  a, b, c, d, e;
	
	public void binaryCode(int num1, int num2, int num3, int num4, int num5) {

		System.out.println("Binary Code:");

		if (num5 == 1) {
			a = (int)(Math.pow(2,0));	
		}
		else if (num5 == 0) {
			System.out.print(0);
		}
		
		if (num4 == 1) {
			b = (int)(Math.pow(1,2));
		}
		else if (num4 == 0) {
			System.out.print(0);
			
		}
		
		if (num3 == 1) {
			c = (int)(Math.pow(2,2));
		}
		else if (num3 == 0) {
			System.out.print(0);
		}
		
		if (num5 == 1) {
			d = (int)(Math.pow(3,2));
		}
		else if (num5 == 0) {
			System.out.print(0);
		}
		
		if (num5 == 1) {
			e = (int)(Math.pow(4,2));
		}
		else if (num5 == 0) {
			System.out.print(0);
		}
		
		int sum = a+b+c+d+e;
		System.out.println(sum);
		
	}
	
	public void stringSwitch() {
		Scanner input = new Scanner(System.in);
		System.out.println("  ");
		System.out.println("enter 2 strings: ");
		
		String str1 = input.nextLine();
		String str2 = input.nextLine();
		
		String value1 = str1;
		String value2 = str2;
		
		System.out.println(str1);
		System.out.println(str2);
		
		str1 = value2;
		str2 = value1;
		
		System.out.println(str1);
		System.out.println(str2);

	}
	public void digitRemainder() {
		Scanner input = new Scanner(System.in);
		System.out.println("  ");
		System.out.println("enter a 5 digit #: ");
		
		int num = input.nextInt();
		
		double d12 =((int)num/1000);
		double d4 =((int)num%10);
		double d5 =((int)num%1000/100);
		double d6 =((int)num%100/10);

		System.out.println((int)d12);
		System.out.println((int)d4);
		System.out.println((int)d5);
		System.out.println((int)d6);
	
		
		System.out.println((int)(d12%d4));
		System.out.println((int)(d12%d5));
		System.out.println((int)(d12%d6));	
	}
	
	public void letterSum(int num1, int num2) {

		System.out.println("Letter Sum:");

		double sum = num1+ num2;
		
		if (sum < 91 && sum > 64){
			System.out.println((char)sum);
		}
		else if (sum <= 123 && sum >= 97){
			System.out.println((char)sum);
		}
		else if (sum < 97 && sum > 93) {
			System.out.println('a');
		}
		else if (sum > 123) {
			System.out.println('z');
		}
		else if (sum < 65) {
			System.out.println('A');
		}
		else if (sum >= 91 && sum <= 93) {
			System.out.println('Z');
		}
		
	}
	
	
	
	public static void main(String[] args) {
		BooleansandFinalIfs tester = new BooleansandFinalIfs();

		tester.binaryCode(1,1,1,1,1);
		
		tester.stringSwitch();
		
		tester.digitRemainder();
		
		tester.letterSum(120,5);
	}

}
