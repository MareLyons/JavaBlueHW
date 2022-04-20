package javaCLASS;

import java.util.ArrayList;

public class Editor {
//	Create an Editor class. It will hold a string s as information.
//	It should have a few methods. change takes in a new string and 
//	updates s to hold this value. delete deletes the last letter from 
//	the current string. undo undoes the most recent change. redo undoes 
//	the most recent undo, nothing if undo hasn't been called. 

	private ArrayList<String> history = new ArrayList<String>();
	private int index = 0;

	
	public Editor (String s) {
		history.add(s);
	}
	
	public void change(String newstring){
		history.add(newstring);
		index ++;
	}
	
	public void delete() {
		String curr = history.get(index);
		history.add(curr.substring(0,curr.length()-1));
		index++;
	}
	
	public void undo() {
		index -= 1;
	}
	
	public void redo() {
		index += 1;
	}
	
	public String toString() {
		return(history.get(index));
	}
	
	public static void main(String[] args) {
		
		Editor e = new Editor("hello");
		System.out.println(e);
		e.change("bye");
		System.out.println(e);
		e.delete();
		System.out.println(e);
		e.undo();
		System.out.println(e);
		e.redo();
			
	}
}
