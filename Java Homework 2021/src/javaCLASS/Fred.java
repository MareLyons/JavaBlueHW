package javaCLASS;

public class Fred extends Lab{

	private int sleep;

	public Fred(int age, int weight, int happiness, int tricksknown, int sleep, String n, String ff) {
		super(age, weight, happiness, tricksknown, n, ff);
		
		this.sleep = sleep;
		
	}
	
	public void pets() {
		sleep += 2;
	}
	
	public String toString() {
		return super.toString() + "and he slept " + sleep + " hours last night";
	}
	
	public static void main(String[] args) {
		
		Fred F = new Fred(8, 140, 7, 6, 8, "fred", "steak");
		System.out.println(F);;
		F.pets();
		System.out.println(F);;
		
	}

}
