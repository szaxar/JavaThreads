
class Buffer{

    private final String[] storage;
    private int end;
    private int start;
    private int ilosc;
    public Buffer(int ilosc) {
        this.storage = new String[ilosc];
        end = 0;
        start = 0;
        this.ilosc=ilosc;
    }


    public void put(String wiadomosc) { // puts add the END
        synchronized(storage) {
       
            this.storage[end] = wiadomosc;
            end = incrementMod(end);
            storage.notifyAll();
        }
    }


    public String take(){

        synchronized(storage) {
            while (end == start) { //pusta kolejka
                try {
                    storage.notifyAll(); // powiadom producera
                    storage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int index = start;
            start = incrementMod(start);
            storage.notifyAll(); 
            return storage[index];

        }
    }

    private int incrementMod(int index) {
        synchronized (storage) {
            if (index == storage.length-1) return 0;
            else return index+1;
        }
    }

    public boolean isEmpty(){
        synchronized (storage) {
            return (start == end);
        }
    }
    
    public int getIlosc(){
    	return ilosc;
    }

}