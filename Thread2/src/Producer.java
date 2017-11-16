
public class Producer implements Runnable {
    private Buffer buffer;
    private Thread t;
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

   public void run() {

        for(int i = 0;  i < buffer.getIlosc();   i++) {
            buffer.put("message "+i);
            System.out.println("Producer write "+"message "+i);
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