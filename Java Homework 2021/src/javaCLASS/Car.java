package javaCLASS;

public class Car {
	
	private int mileage;
	private int year;
	private String name;


	public Car(int mileage, int year, String na) {
		
		this.mileage = mileage;
		this.year = year;
		name = na;
	}
	
	
	public void drive(int distance) {
		mileage += distance;
	}
	
	public int worth() {
		return(1000*(mileage/year));
	}
	
	public int getMileage() {
		return mileage;
	}
}
