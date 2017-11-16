
import java.util.concurrent.Callable;


public class Process implements Callable {
	private final int MAX_ITER = 57000;
	private int x;
	private int y;
	private double zx, zy, cX, cY, tmp;
	private double ZOOM;
	
	public Process(int x, int y,double ZOOM){
		this.x=x;
		this.y=y;	
		this.ZOOM=ZOOM;
		
	}

	@Override
	public Tmp call() throws Exception {
		// TODO Auto-generated method stub
		zx = zy = 0;
		cX = (x - 400) / ZOOM;
		cY = (y - 300) / ZOOM;
		Integer iter = MAX_ITER;
		while (zx * zx + zy * zy < 4 && iter > 0) {
			tmp = zx * zx - zy * zy + cX;
			zy = 2.0 * zx * zy + cY;
			zx = tmp;
			iter--;
		}
		Tmp tmp=new Tmp(x, y, iter);
		return tmp;
	}
	
	
	
}
