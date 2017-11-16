public class Semafor {

	Boolean stan;

	public Semafor() {
		stan = true;
	}

	public synchronized void V() {

		stan = true;
		notifyAll();

	}

	public synchronized void P() throws InterruptedException {

		while (!stan.equals(true)) {
			wait();
		}
		stan = false;

	}

}
