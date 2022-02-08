package javaCLASS;

public class Lab extends Dog{

	private String favfood;

	public Lab(int age, int weight, int happiness, int tricksknown, String n, String ff) {
		super(age, weight, happiness, tricksknown, n);
		
		favfood = ff;

	}

	public void walk() {;
		setHappiness(getHappiness() - 1);
	}
	
	public void train() {
		super.train(1);
		favfood = "treats";
	}
	
	public void eat() {
		System.out.println("yum");
	}
	
	public void peanutbuttert() {
		System.out.println("YAYYY");
		setHappiness(getHappiness() + 100);
	}
	
	public String toString() {
		return super.toString() + "and his favorite food is " + favfood;
	}
	
	
	public static void main(String[] args) {
		
		Lab L = new Lab(8,140,7,6, "fred", "steak");
		System.out.println(L);
		L.eat();
		L.peanutbuttert();
		L.train();
		L.walk();
		System.out.println(L);
	}
}

