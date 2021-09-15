
public class Summer {

	public static void main(String[] args) {
	
		System.out.println("What was the highlight of your summer?");
		sleep(500);
		System.out.println("The highlight of my summer was working and living"
				+ "at a summer camp in Maine for 10 weeks. I "
				+ "got to experience being fully responsible for not only myself "
				+ "but also six ten year olds. It was really special because I have gone "
				+ "to this camp for nine years, so it was nice to finally"
				+ "be back as a counselor");
		sleep(1000);
		
		System.out.println("What was something new you tried this summer?");
		sleep(500);
		System.out.println("A new experience I had this summer was teaching pottery."
				+ "Although I'm not super aristic, I was still able to have fun"
				+ "and teach the campers about something I love. It also was fun"
				+ "to see them doing something so hands on after most of them"
				+ " learning virtually for the past year");
		sleep(1000);
		
		System.out.println("What was the best food you tried this summer?");
		sleep(500);
		System.out.println("The best food I ate this summer was mussles and oyesters"
				+ "at a seafood place in Portland Maine. I previously thought I was "
				+ "allergic to all shellfish, so it was nice to try something new!");
		sleep(1000);
		
		System.out.println("What was the best place you got to go this summer?");
		sleep(500);
		System.out.println("Although I loved my time in Maine, at the start of the"
				+ "summer I got to go down to the cape a couple times and that was "
				+ "super fun! Also I visited my friend in New Hampshire and we got "
				+ "to hike so that was great");		
		sleep(1000);
		
		System.out.println("What was the best place you got to go this summer?");
		sleep(500);
		System.out.println("Although I loved my time in Maine, at the start of the"
				+ "summer I got to go down to the cape a couple times and that was "
				+ "super fun! Also I visited my friend in New Hampshire and we got "
				+ "to hike so that was great");	
		sleep(1000);
		
		System.out.println("What else did you do this summer?");
		sleep(500);
		System.out.println("While I wasnt working with friends or working at camp"
				+ "I did a lot of work on my college applications. Although this was"
				+ "tough in the moment definetly glad I got a lot of the work done");	
		
		
		
		
		
	}


// makes the program pause for half a second.
public static void sleep(int time) {
	try {
		Thread.sleep(time);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

}