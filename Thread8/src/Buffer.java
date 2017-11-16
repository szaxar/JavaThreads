import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Buffer{
	
	  final Lock lock = new ReentrantLock();
	   final Condition[] conditions  ; 
	  
	   private String[] items;
	  private int size;
	  private int[] visitors;
	   int putptr=0;
	   int takeptr=0;
	   int count=0;
	
	
public Buffer(int x) {
	this.size=x;
	items = new String[x];
    visitors = new int[x];
    conditions = new Condition[x];
    for (int i = 0; i < x; i++) {
        visitors[i] = 0;
		conditions[i] = lock.newCondition();
    }
}



public int getSize(){
	return size;
}
	   
	   public void put(String msg, int id, int index) throws InterruptedException {
		   lock.lock();
	        while (visitors[index] != id ){
	        	System.out.println("Process "+id+"is waiting to put");
	            conditions[index].await();
	            
	        }
	        visitors[index]++;
	        items[index] = msg;
	        conditions[index].signalAll();
	        lock.unlock();
	    
	   }

	   public String take(int id, int index) throws InterruptedException {
		   lock.lock();
	        String result;
	        while (visitors[index] != id){
	        	System.out.println("Process "+id+"is waiting to take");
	        	 conditions[index].await();
	        }
	           
	        result = items[index];
	        items[index] = "";
	        lock.unlock();
	        return result; 
	     
	   }
	 


}