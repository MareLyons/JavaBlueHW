package javaCLASS;

public class InterestAccount extends BankAccountClass {

	private double interest;
	
	public InterestAccount(String on, int balance, double interest) {
		super(on, balance);
		this.interest = interest;
	}

	public void addInterest() {
		deposit((getBalance()*(interest/12)));
	}
	
	public String toString() {
		return super.toString() + " and the account interest is " + interest;
	}
	
	public static void main(String[] args) {
		InterestAccount w = new InterestAccount("Will", 5000, 1.06);
		
		System.out.println(w);

		w.addInterest();

		System.out.println(w);
	}
}
