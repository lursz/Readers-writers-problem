package reader_writer.people;
import reader_writer.Main;
public class Readers extends Human{

    public Readers(int id){
        this.id = id;
    }

    @Override
    public void run(){
        try {
            Main.resource.startRead(this);
            System.out.println("Czytelnik " + id + " rozpoczyna czytanie");
            Thread.sleep(1000);
            System.out.println("Czytelnik " + id + " kończy czytanie");
            Main.resource.endRead();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }







}
