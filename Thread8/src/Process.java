import java.util.concurrent.atomic.AtomicInteger;

public class Process implements Runnable {
    private Buffer buffer;
    private final int id;
    private static final AtomicInteger count = new AtomicInteger();
    
    public Process(Buffer buffer) {
        this.buffer = buffer;
        id = count.incrementAndGet();
        
    }

   public void run() {
       System.out.println("Procces "+id);
        	for(int j=0;j<buffer.getSize();j++){
        		try {
					String message = buffer.take(id, j);
					System.out.println(id + " consumes buffer[" + j + "] msg: " + message);
					Thread.sleep((long) (Math.random() * 5000));
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        		  StringBuilder msg = new StringBuilder();
                  msg.append(id).append("---").append(j);
                  
            try {
				buffer.put(msg.toString(),id,j);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            System.out.println("Process write int buffer "+j+" mesage "+msg.toString());
           
        	}
      
    }
   
  
}