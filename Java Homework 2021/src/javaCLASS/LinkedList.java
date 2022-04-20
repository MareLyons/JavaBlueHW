package javaCLASS;

public class LinkedList<Q> {
	int size = 0;
	
	private class Node{
		//Q or any letter creates a GENERIC type --> awesome. functional
		Q info;
		Node next;
	
		
		public Node (Q i, Node n) {
			info = i;
			next = n;
		}
	}
		
		
		private Node head = null;
		
		public void add(Q info) {
			Node newNode = new Node(info, null);
			
			if(head == null) {
				head = newNode; 
			}
			else {
				Node curr = head;
				while(curr.next != null) {
					curr = curr.next;
				}
				curr.next = newNode;
				size++;
			}
		}
		
		public Q get(int i) {
		
		try {
			Node curr = head;
		
			for(int j = 0; j < i; j++) {
				curr = curr.next;
			}
			return curr.info;
		}
		catch(NullPointerException e) {
			
			throw new IndexOutOfBoundsException();
				
			}
		}
		
		public void addIndex(Q info, int i) {
			
			Node newNode = new Node(info, null);
			int count = 0;
			Node curr = head;
			
			while(count != i-1) {
				curr = curr.next;
				count++;
			}
			newNode.next = curr.next;
			curr.next = newNode;
			size++;
		}

		
		public void removeIndex(int i){

			int count = 0;
			Node curr = head;
			
			while(count != i-1) {
				curr = curr.next;
				count++;
			}
			curr.next = curr.next.next;
			size--;
		}
		
		public int size() {
			return(size);
			
		}
		
}


