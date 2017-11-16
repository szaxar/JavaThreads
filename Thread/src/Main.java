
public class Main {

	public static void main(String[] argv) {
		
		Counter x=new Counter(0);
		 MyThread R1 = new MyThread(0, x);
	     Thread R1t= R1.start();
	      
	      
	      MyThread R2 = new MyThread(1, x);
	      Thread R2t= R2.start();
	      
	      while(true) {
	    	 try {
	    		 R1t.join();
	    		 R2t.join();
	    		 break;
	    	 }catch (InterruptedException e) {
	    	      e.printStackTrace();
	      }
	      }
	      x.getX();
	
	
}
	
}
