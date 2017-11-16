
public class Producer implements Runnable {
    private Buffer buffer;
    private Thread t;
    private int x;
    public Producer(Buffer buffer,int x) {
        this.buffer = buffer;
        this.x=x;
    }

   public void run() {

        for(int i = 0;  i < x;   i++) {
            try {
				buffer.put("message "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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