
public class Counter {
		private int x;
	public Counter(int x) {
		this.x=x;
	}
	
	public void inkrementuj () {
		x++;
	}
	public void dekrementuj() {
		x--;
	}
	
	public void getX() {
		System.out.println(x);
	}
}
