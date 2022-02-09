package javaCLASS;

public class CreditCard extends InterestAccount{

	public CreditCard(String on, int balance, double interest) {
		super(on, balance, interest);
	}
//A CreditCard class, which extends the InterestAccount class. 
	//This account also gathers interest (ideally a higher rate than the InterestAccount), 
	//but deducts $10 after interest is added. Additionally, the account cannot go below $100, 
	//so whenever we withdraw, we must check for this. 
	
	public void interest() {
		super.addInterest();
		withdraw(10);
		if (getBalance() < 100) {
			deposit(0);
		}
	}
	
	public void withdraw(int lostmoney) {
		super.withdraw(lostmoney);
		if (getBalance() < 100) {
			deposit(0);
		}
		
	}
	
	public String toString() {
		return super.toString();
	}

	public static void main(String[] args) {
		CreditCard L = new CreditCard("Louis", 5000, 1.06);
		
		System.out.println(L);

		L.interest();
		L.withdraw(200);

		System.out.println(L);
	}
}

