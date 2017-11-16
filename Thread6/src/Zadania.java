
public class Zadania  implements Runnable{
	private Printer_Monitor printer_Monitor;
	private int n;
	private Thread t;
	Printer printer;
		public Zadania(Printer_Monitor printer_Monitor,int n){
			this.printer_Monitor=printer_Monitor;
			this.n=n;
			
		}
		
		
	
		
		 public void run() {

			   try {
				   System.out.println("Rezerwuje ");
				printer=printer_Monitor.zarezerwuj();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   System.out.println("Tworze zadanie ");
			  printer.Utworz_zadanie_do_druku("zadanie 1  ");
			  printer.Utworz_zadanie_do_druku("zadanie 2  ");	
			  printer.drukuj();
			  printer_Monitor.zwolnij(printer);
			  	System.out.println("Zwalniam");
		 }
		   
		   public Thread start () {
			   for(int i=0;i<n;i++){
		    	        
			    System.out.println("Starting "+i );   
				
			       t = new Thread (this);
			       t.start ();      
			    
			   }
			 
				return t;
				}
}
