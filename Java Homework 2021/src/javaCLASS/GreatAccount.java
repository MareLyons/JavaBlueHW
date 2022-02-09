package javaCLASS;

public class GreatAccount extends BankAccountClass{
	private int withdrawlcount = 0;
	private int totalwithdrawlcount = 0;
	private int months = 12;
	
	public GreatAccount(String on, int balance) {
		super(on, balance);
		
	}

	//A GreatAccount class, which extends the BankAccount class. 
	//This account only allows 3 withdrawals per month which means you'll 
	//need a variable to count this month's withdrawal. You'll also need a nextMonth() 
	//method to reset this count. Every year (12 months), if you did not withdraw at all, your balance is doubled. 
	
	public void withdraw(int lostmoney) {
		super.withdraw(lostmoney);
		withdrawlcount ++;
		totalwithdrawlcount++;
	}
	
	public void nextMonth() {
		if(months == 12 && totalwithdrawlcount == 0) {
			deposit((double)getBalance());
		}
		withdrawlcount = 0;
		months ++;
	}
	
	public String toString() {
		return super.toString();
	}
	
	public static void main(String[] args) {
		GreatAccount J = new GreatAccount("Jojo", 5000);
		
		System.out.println(J);

		//J.withdraw(200);
		J.nextMonth();
		
		System.out.println(J);
	}
}

