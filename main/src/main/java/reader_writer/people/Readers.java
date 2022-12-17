package reader_writer.people;
import reader_writer.Main;
public class Readers extends Human{
/* -------------------------------- Atributes ------------------------------- */
    private int id;

    public Readers(int id){
        this.id = id;
    }
/* --------------------------------- Methods -------------------------------- */
    @Override//use infinite loop to simulate the reader
    public synchronized void run(){
        while(true){
            threadSleep1000();
            Main.resource.requestRead(this);
            System.out.println("Reader " + id + " is reading");
            threadSleep1000();
            Main.resource.finishRead(this);
            System.out.println("Reader " + id + " finished reading");
        }


    }







}
