
public class Consumer implements Runnable {
   
	private Buffer buffer;
	private int id;
    public Consumer(Buffer buffer,int id) {
        this.buffer = buffer;
        this.id=id;
    }

   public void run() {

	   
		   for(int j=0;j<buffer.getSize();j++){
            String message=new String();
			try {
				message = buffer.take(id,j);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Consumer reads "+j+" "+message);
           
		   }
        

    }
   
}