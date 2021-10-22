package javaCLASS;

public class Nestedloops2 {

		
		//quadratic
		public void nByM(int n, int m) {
			
			for(int i = 0; i < n; i++) {
		
				for (int j  = 0; j < m; j ++) {
				System.out.print("*");
				}
				System.out.println();
			}	
		}
		
		//constant
		public void aToZ() {
			for(int i = 65; i < 91; i++) {
				System.out.print((char)i);
				
			}
			System.out.println();
		}
		
		//constant
		public void multiplicationTable() {

			for(int i = 1; i < 13; i++) {
				
				for (int j  = 1; j < 13; j ++) {
					
					System.out.print(j * i + ", ");
					}
					System.out.println();
			}
		}
		
		//linear
		public void primeToX(double n) {

			int count = 0;
			
			for (int i = 2; i <= n; i++) {
			    count = 0;
			    for (int j = 2; j < i; j++) {
			        if (i % j == 0) {
			            count++;
			        }
			    }
			    if (count == 0) {
			        System.out.print(i + " ");
			    }
			}
		
			}
		
		//constant
		public void xOfStars(int n) {
		   // took me a really long time to simplfy but wondering if there is a way to make my center star not 
			//off center because that only happened when i simplified
			for(int i=1;i<=(n*2-1);i++)
	        {   
				for(int j=1;j<=(n*2-1);j++)
							
	                 {      if(j==i || j==(2*n-1)-i+1) {
	                         System.out.print("*");
	                 }
	                 System.out.print(" ");
	                 }
	         		 System.out.println();
	                 }
	        }
		
		// looked up formula
		//linear
		//public void pascalsTriangle(int x) {
		    

	public static void main(String[] args) {
		Nestedloops2 tester = new Nestedloops2();
		
		tester.nByM(2, 3);
		tester.aToZ();
		tester.multiplicationTable();
		tester.primeToX(17);
		System.out.println(" ");
		tester.xOfStars(6);
		
		
	}
	}


