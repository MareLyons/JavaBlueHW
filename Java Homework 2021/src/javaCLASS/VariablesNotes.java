package javaCLASS;

import sun.jvmstat.monitor.Variability;

public class VariablesNotes {

	private String myWord = "hi"; // only accessible within file whereas public accessible
								  // to all files in my library
	public void setWord(String userWord) {
		
		this.myWord = userWord;

	}
	public void sayWord() {
		
		String myWord = "hi";
		
		System.out.println(myWord);
	}
	
	public static void main(String[] args) {	
	
		Variable runner = new Variables ();
		
		System.out.println(runner.myWord);
	}
}
