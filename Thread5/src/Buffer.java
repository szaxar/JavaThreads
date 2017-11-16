import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Buffer{
public Buffer() {
	// TODO Auto-generated constructor stub
}
	  final Lock lock = new ReentrantLock();
	   final Condition notFull  = lock.newCondition(); 
	   final Condition notEmpty = lock.newCondition(); 

	   final String[] items = new String[100];
	   int putptr, takeptr, count;

	   public void put(String x) throws InterruptedException {
	     lock.lock();
	     try {
	       while (count == items.length)
	         notFull.await();
	       items[putptr] = x;
	       if (++putptr == items.length) putptr = 0;
	       ++count;
	       notEmpty.signal();
	     } finally {
	       lock.unlock();
	     }
	   }

	   public String take() throws InterruptedException {
	     lock.lock();
	     try {
	       while (count == 0)
	         notEmpty.await();
	       String x = items[takeptr];
	       if (++takeptr == items.length) takeptr = 0;
	       --count;
	       notFull.signal();
	       return x;
	     } finally {
	       lock.unlock();
	     }
	   }
	 }