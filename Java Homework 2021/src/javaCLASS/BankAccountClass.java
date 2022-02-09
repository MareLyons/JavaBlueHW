package javaCLASS;

public class BankAccountClass {
	
	private int balance;
	private String ownername;


	public BankAccountClass(String on) {
		balance = 0;
		ownername = on;
	}
	public BankAccountClass(String on, int balance) {
		this.balance = balance;
		ownername = on;
	}
	
	
	public void deposit(double newmoney) {
		balance += newmoney;
	}
	public void withdraw(int lostmoney) {
		balance -= lostmoney;
	}

	public String toString() {
		return ownername + " has " + getBalance() + " dollars in their account";
	}

	public int getBalance() {
		return balance;
	}

	
	public static void main(String[] args) {
		BankAccountClass m = new BankAccountClass("Mare");
		
		System.out.println(m);

		m.deposit(200);
		m.withdraw(10);

		System.out.println(m);
	}
	
}
