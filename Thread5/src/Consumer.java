
public class Consumer implements Runnable {
   
	private Buffer buffer;
	private Thread t;
	private int x;
    public Consumer(Buffer buffer,int x) {
        this.buffer = buffer;
        this.x=x;
    }

   public void run() {

	   for(int i=0;i<x;i++){
            String message = null;
			try {
				message = buffer.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
