package javaCLASS;

public class Dog {

	private double weight;
	private int age;
	private int happiness;
	private int tricksknown;
	private String name;

	public Dog(int age, double weight, int happiness, int tricksknown, String n) {
		
		this.age = age;
		this.weight = weight;
		this.setHappiness(happiness);
		this.tricksknown = tricksknown;
		name = n;	
	}
	
	public String toString() {
		return "My dog is named " + name + " he is " + age + " years old, he weighs " + weight + " pounds, he knows " + tricksknown + " tricks and he is about a " + getHappiness() + " on the happiness scale.";
	}
	
	public void train(int numtricks) {
		tricksknown += numtricks;
	}
	
	public void walk(double miles) {
		setHappiness(getHappiness() + 1);
		weight -= miles/10;
	}
	
	public int getHappiness() {
		return happiness;
		
	}
	
	public void pets() {
		setHappiness(getHappiness() + 2);
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
	
	public static void main(String[] args) {
		
		Dog D = new Dog(8,140,7,6, "fred");
		System.out.println(D);
		D.pets();
		D.train(2);
		D.walk(5);
		System.out.println(D);
		
	}
	
}