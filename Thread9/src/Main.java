import java.util.concurrent.ExecutionException;


public class Main {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long start=System.currentTimeMillis();
		new Mandelbrot().setVisible(true);
		long stop=System.currentTimeMillis();
		System.out.println("Czas wykonania:"+(stop-start));
	}
}
