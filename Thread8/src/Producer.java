
public class Producer implements Runnable {
    private Buffer buffer;
    private Thread t;
    private Thread T1;
    private int x;
    private int y;
    public Producer(Buffer buffer) {
        this.buffer = buffer;
        
    }

   public void run() {

       System.out.println("producer");
        	for(int j=0;j<buffer.getSize();j++){
        		 StringBuilder msg = new StringBuilder();
                 msg.append(0).append("---").append(j);
            try {
				buffer.put(msg.toString(),0,j);
				Thread.sleep((long) (Math.random() * 500));
				System.out.println("PRODUCER puts into buffer[" + j + "] msg: "+msg.toString());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
        	}
        	
        }

   
    
}