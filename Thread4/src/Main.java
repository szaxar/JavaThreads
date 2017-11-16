public class Main {
	public static void main(String[] argv) throws InterruptedException {
		Semafor semafor=new Semafor(5);
		Klienci klienci=new Klienci(20, semafor);
		klienci.start();
		
		
	}
}
