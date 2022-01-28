package javaCLASS;

public class Garage {

	private Car[] g;
	
	public Garage(int n) {
		g = new Car[n];
	}
	
	public void addCar(int mileage, int year, String na, int i) {
		
		if(i >= g.length || i < 0) {
			System.out.println("invalid index!!");
		}
		else {
			g[i] = new Car(mileage, year, na);
		}
	}
	
	public int totalWorth() {
		int worthtotal = 0;
		for(Car car: g) {
			if(car != null){
				worthtotal += car.worth();
			}
		}
		return(worthtotal);
	}
	
	public int averageMiles() {
		int mileagetotal = 0;
		int carnumber = 0;
		for(Car car: g) {
			carnumber ++;
			if(car != null){
				mileagetotal += car.getMileage();
			}
		}
		return(mileagetotal/carnumber);
	}
	
	public void drive(int i, int n) {
		g[i].drive(n);
		
	}
	
	public static void main(String[] args) {
		Garage g = new Garage(5);
		Car c = new Car(6000,2021,"chevy spark");
		Car ff = new Car(40000,2016,"ford fiesta");
		Car j = new Car(200000,2008,"jeep");
		Car t = new Car(20000,2018,"toyota");
		
		g.addCar(6000,2021,"chevy spark",1);
		g.addCar(40000,2016,"ford fiesta",2);
		g.addCar(200000,2008,"jeep",3);
		g.addCar(20000,2018,"toyota",4);
		
		System.out.println(t.worth());
		t.drive(20);
		t.getMileage();
		
		System.out.println(g.totalWorth());
		System.out.println(g.averageMiles());

	}
}
