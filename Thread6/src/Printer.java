import java.util.ArrayList;


public class Printer {

	ArrayList<String> listaStron;
	
	public Printer() {
		listaStron=new ArrayList<String>();
	}
	
	public void Utworz_zadanie_do_druku(String text){
		listaStron.add(text);
	}
	

	
	public void drukuj(){
		for(int i=0;i<listaStron.size();i++){
			System.out.println(listaStron.get(i));
		}
		listaStron.clear();
	}
	
}
