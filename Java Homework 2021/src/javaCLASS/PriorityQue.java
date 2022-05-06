package javaCLASS;

import java.util.ArrayList;
import java.util.HashMap;

public class PriorityQue<T> {
	
	private class Bundle {
		T element;
		int priority;
		
		public Bundle(T e, int p) {
			element = e;
			priority = p;
		}
		
		public String toString() {
			return(element + ":" + priority);
		}
	}
		
	ArrayList<Bundle> queue = new ArrayList<Bundle>();
		
	//pop will get the top thing (remove the first thing)
	public T pop() {
		return(queue.remove(0).element);
	}
		
	//size
	public int size() {
		return(queue.size());	
	}
		
		
	//add push
	public void push(T info, int p) {
		
		for(int i = 0; i < queue.size(); i++) {

			if(queue.get(i).priority < p) {
				queue.add(i,new Bundle(info, p));
			}
		}
			
		if(queue.contains(new Bundle(info, p))){
			
			for(int i = 0; i < queue.size(); i++) {
				
				if(queue.get(i).element.equals(info)) {
					queue.remove(i);
					break;
				}
			}
		}	
		queue.add(new Bundle(info,p));
	}
		
	//to String
	public String toString() {
		return queue.toString();
	}
		
		public static void main(String[] args) {
			
			PriorityQue<String> pq = new PriorityQue<String>();
			pq.push("mare", 7);
			pq.push("ryan", 7);
			pq.push("anika", 7);
			pq.push("cooper", 7);
			pq.push("yumna", 7);
			pq.push("hanson", 7);
			
			pq.size();
			pq.pop();
			pq.toString();
		}


		
		
}
	
	


