package javaCLASS;

public class MyHuman {
	
	//we have private variables to do things behind the scenes
		private int age;
		private int height;
		private String name;
		private String eyecolor;
		private String haircolor;

		//access instance variables throughout method
		//objects 
		
		
		// have to put name at top
		//constructor
		public MyHuman(int age, int height, String n, String ec, String hc) {
			
			this.age = age;
			this.height = height;
			name = n;
			eyecolor = ec;
			haircolor = hc;

		}
		
		public void getOlder() {
			age += 1;
		}
		
		public void changeName(String newname) {
			name = newname;
		}
		
		public void canVote(int Year) {
			if(Year % 4 == 0 && age >= 18) {
				System.out.println("they can vote");
			}
			else {
				System.out.println("they cannot vote");
			}
		}
		
		public void  dyeHair(String newHaircolor) {
			haircolor = newHaircolor;
		}
	

		public String toString() {
			return "I am " + name + ", I am " + age + " years old, I have " + eyecolor + " eyes, "+ haircolor + " hair, and I am " + height + " inches tall";
		}
		
		public static void main(String[] args) {
			MyHuman m = new MyHuman(12, 100, "Mare", "blue", "brown");
			
			m.getOlder();
			m.changeName("Marianne");
			m.canVote(2011);
			m.dyeHair("red");
			
			System.out.println(m);
		}
		
		
}
