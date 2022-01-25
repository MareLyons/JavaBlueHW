package javaCLASS;

public class BankAccountClass {
	
	private int money;
	private String ownername;
	private double interest;

	public BankAccountClass(String on, int money, double interest) {
		this.money = money;
		this.interest = interest;
		ownername = on;
	}
	
	public BankAccountClass(String on, double interest) {
		money = 0;
		this.interest = interest;
		ownername = on;
	}
	
	//deposit(int n): this method should add the given amount of money to the current total in the bank.
	public void desposit(int newmoney) {
		money += newmoney;
	}
	//withdraw(int n): this method should subtract the given amount of money from the current total.
	public void withdraw(int lostmoney) {
		money -= lostmoney;
	}
	//addInterest(): this method should calculate this month's interest and add it to the current total.
	public void addInterest() {
		money += money * (interest/12);
	}
	//toString(): this method should simply return a display of how much money is in the account.
	public String toString() {
		return ownername + " has " + money + " dollars in their account";
	}
	
	public static void main(String[] args) {
		BankAccountClass m = new BankAccountClass("Mare", 1.06);
		
		m.desposit(100);
		m.withdraw(20);
		m.addInterest();
		
		System.out.println(m);
	}
	
	
}
