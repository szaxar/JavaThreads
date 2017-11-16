import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] argv) throws InterruptedException {
		Buffer buffer = new Buffer(100);
	
		 List<Thread> threads = new ArrayList<>();
		 threads.add(new Thread(new Producer(buffer)));
		 
		  for (int i = 0; i < 5; i++) {
	            threads.add(new Thread(new Process(buffer)));
	        }
		
		  threads.add(new Thread(new Consumer(buffer, 6)));

	        for (Thread thread : threads) {
	            thread.start();
	        }
	        for (Thread thread : threads) {
	            thread.join();
	        }
}
	
}