package reader_writer.people;

import reader_writer.Main;

public class Writers extends Human{
/* -------------------------------- Atributes ------------------------------- */

    private int id;
    public Writers(int id){
        this.id = id;
    }

/* --------------------------------- Methods -------------------------------- */

    @Override
    public synchronized void run(){
        while(true){
            threadSleep1000();
            Main.resource.requestWrite(this);
            System.out.println("Writer " + id + " is writing");
            threadSleep1000();
            Main.resource.finishWrite(this);
            System.out.println("Writer " + id + " finished writing");
        }
    }

}
