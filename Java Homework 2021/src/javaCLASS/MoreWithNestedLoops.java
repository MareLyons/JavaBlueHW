package javaCLASS;

public class MoreWithNestedLoops {
	
	public void  loopingBox(int x) {
		for(int i = 1; i < x+1; i++) {
			for (int j  = 1; j < x+1; j ++) {
			System.out.print(i++);
				if (i > 5) {
					i =1;
				}
		}
		System.out.println();
		}

	}

    public void  xTriangle(int n) {

		for(int i=0;i < n;i++)
        {   
			for(int j=0;j < i +1;j++)		
                 {
                 System.out.print("X");

                 }
			System.out.println();
        }
    	
		
	}
    
	  public static void main(String[] args) {
		  MoreWithNestedLoops runner = new MoreWithNestedLoops();
		  
		  runner.loopingBox(5);
		  runner.xTriangle(6);
		 


}
}
