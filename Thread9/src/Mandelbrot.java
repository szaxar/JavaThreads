import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JFrame;

public class Mandelbrot extends JFrame {

	private final double ZOOM = 150;
	private BufferedImage I;
	
	
	 ExecutorService pool = Executors.newScheduledThreadPool(8);
	 Set<Future<Tmp>> set = new HashSet<Future<Tmp>>();
	 
	public Mandelbrot() throws InterruptedException, ExecutionException {
		super("Mandelbrot Set");
		setBounds(100, 100, 800, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		I = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_RGB);
		
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				 Callable<Tmp> callable = new Process(x, y, ZOOM);
			      Future<Tmp> future = pool.submit(callable);
			      set.add(future);
			}
		}
		for (Future<Tmp> future : set) {
			I.setRGB(future.get().getX(),future.get().getY() ,future.get().getIter()  |  future.get().getIter()<< 8);
		    }
		
	}
	 @Override
	    public void paint(Graphics g) {
	        g.drawImage(I, 0, 0, this);
	    }
}
