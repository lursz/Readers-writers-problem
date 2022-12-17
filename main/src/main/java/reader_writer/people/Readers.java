package reader_writer.people;

import reader_writer.Main;
import reader_writer.Resource;

public class Readers extends Human {
    /* -------------------------------- Atributes ------------------------------- */
    private int id;

    private int maxReadingTime = 1000;


    public Readers(int id, Resource resource) {
        this.id = id;
        this.resource = resource;
    }

    /* --------------------------------- Methods -------------------------------- */
    @Override
    public synchronized void run() {
        while (true) {
            int randomWaitingTime = (int) (Math.random() * maxReadingTime);
            tryCatchThreadSleep(randomWaitingTime);
            resource.requestRead(this);
            int randomReadingTime = (int) (Math.random() * maxReadingTime);
            tryCatchThreadSleep(randomReadingTime);
            resource.finishRead(this);


        }


    }


}
