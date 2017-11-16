import java.util.Random;

public class Klienci implements Runnable  {
	private int y;
	private Semafor semafor;
	private Thread t;
	Random generator = new Random();
	public Klienci(int y,Semafor semafor) {
		this.y = y;
		this.semafor=semafor;
		
	}
	
	public void run() {
		// TODO Auto-generated method stub
		

		try {
			
			semafor.P();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 try {
			Thread.sleep(generator.nextInt(500));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		semafor.V();
		}
		



	public void start () {
		for(int i=0;i<y;i++){
	    
	    
	       t = new Thread (this);
	       t.start ();
	       
	    }
	 
		
		}
	}

