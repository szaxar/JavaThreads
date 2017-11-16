
public class Main {

	public static void main(String[] argv) {
		Buffer buffer = new Buffer(8);
		Producer producer=new Producer(buffer);
		Consumer consumer=new Consumer(buffer);
		Thread T1 = producer.start();
		Thread T2 = consumer.start();
		
		while(true) {
	    	 try {
	    		 T1.join();
	    		 T2.join();
	    		 break;
	    	 }catch (InterruptedException e) {
	    	      e.printStackTrace();
	      }
	      }
}
	
}
