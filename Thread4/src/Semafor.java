public class Semafor {
	private int x;

	public Semafor(int x) {
		this.x = x;
	}

	public synchronized void V() {
		x++;
		notifyAll();
		System.out.println("Klient odstawil koszyk");
		
	}

	public synchronized void P() throws InterruptedException {
		while (x == 0) {
			System.out.println("oczekuje na koszyk");
			wait();
		}
		x--;
		System.out.println("Klient zabral koszyk");
	}

}
