import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;




public class Printer_Monitor {
	 final Lock lock = new ReentrantLock();
	 final Condition notEmpty  = lock.newCondition(); 
	int m;
	ArrayList<Printer> zajeteDrukarki=new ArrayList<Printer>();
	ArrayList<Printer> wolneDrukarki=new ArrayList<Printer>();
	
	public Printer_Monitor(int m) {
		this.m=m;
		for(int i=0;i<m;i++){
			wolneDrukarki.add(new Printer());
		}
	}
	
	
	public Printer zarezerwuj() throws InterruptedException{
		
		Printer drukarka;
		lock.lock();
		
		while(wolneDrukarki.size()==0){
			System.out.println("Czekam");
			 notEmpty.await();
		}
		drukarka=wolneDrukarki.remove(wolneDrukarki.size()-1);
		zajeteDrukarki.add(drukarka);
		
		lock.unlock();
	return drukarka;
	}
	

	public void zwolnij(Printer drukarka){
		
		lock.lock();
		zajeteDrukarki.remove(drukarka);
		wolneDrukarki.add(drukarka);
		notEmpty.signal();
		lock.unlock();
	}
}
