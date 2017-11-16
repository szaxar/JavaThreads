
public class Main {
	public static void main(String[] argv) {
		Printer_Monitor printer_Monitor=new Printer_Monitor(2);
		Zadania zadania=new Zadania(printer_Monitor, 20);
		zadania.start();
		
	}
}
