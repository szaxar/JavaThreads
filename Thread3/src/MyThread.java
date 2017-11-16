
public class MyThread implements Runnable {
	
	private Thread t;
	private int name;
	private Counter x;
	private Semafor semafor;
	public MyThread(int name , Counter x,Semafor semafor){
		this.name=name;
		this.x=x;
		this.semafor=semafor;
	}

@Override
public void run() {
	// TODO Auto-generated method stub
	System.out.println("Running " +  name );
	try {
		semafor.P();
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	for(int a=0;a<100000000 ;a++) {
		if(name==0) x.inkrementuj();	
		else x.dekrementuj();	 
	}
	semafor.V();
	}



public Thread start () {
    System.out.println("Starting " +  name );
    if (t == null) {
       t = new Thread (this);
       t.start ();
       
    }
 
	return t;
	}


}

