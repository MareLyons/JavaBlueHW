package javaCLASS;

public class CWclock {

	private int time;
	
	// create your methods here
	public void setTime(int x){
		time = x;
		System.out.println(time);
	}
	
	public void tick() {
		time += 1;
		
	}
	public void displayTime(int y) {
		System.out.println(time%60);
	}
	
	public static void main(String[] args) {
		CWclock tester = new CWclock();
		
		// should display the time to be 56, 57, 58, 59, 0, 1, etc.
		tester.setTime(56);
		tester.tick();
		tester.displayTime(57);
		tester.tick();
		tester.displayTime(58);
		tester.tick();
		tester.displayTime(59);
		tester.tick();
		tester.displayTime(0);
		tester.tick();
		tester.displayTime(1);
		tester.tick();
		tester.displayTime(2);
		tester.tick();
		tester.displayTime(3);
	}
}
