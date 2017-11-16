
public class MyThread implements Runnable {
	
	private Thread t;
	private int name;
	private Counter x;
	
	public MyThread(int name , Counter x){
		this.name=name;
		this.x=x;
	}

@Override
public void run() {
	// TODO Auto-generated method stub
	System.out.println("Running " +  name );
	synchronized(x) {
	for(int a=0;a<100000000 ;a++) {
		if(name==0) x.inkrementuj();	
		else x.dekrementuj();
		 
	}
	}
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

