

public class Consumer implements Runnable {
   
	private Buffer buffer;
	private Thread t;
	
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

   public void run() {

	   for(int i=0;i<buffer.getIlosc();i++){
            String message = buffer.take();
            System.out.println("Consumer reads "+message);
        }

    }
   
   public Thread start () {
	    System.out.println("Starting " );   
		if (t == null) {
	       t = new Thread (this);
	       t.start ();      
	    }
	 
		return t;
		}
}
