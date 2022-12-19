package reader_writer.people;
import reader_writer.Resource;

/**
 * Class that represents a reader.
 * Reader can read the resource alone or with other readers.
 */
public class Readers extends Human {


    /* -------------------------------- Attributes ------------------------------- */
    private int maxReadingTime = 3000;
    private int minReadingTime = 1000;


    public Readers(int identifier, Resource resource) {
        this.identifier = identifier;
        this.resource = resource;
    }

    /* --------------------------------- Methods -------------------------------- */

    /**
     * Overridden run method, that will be executed when the thread is started.
     * It will request to read the resource, proceed to read it and then finish reading it.
     */
    @Override
    public synchronized void run() {
        while (true) {
            int randomReadingTime = (int) (Math.random() * (maxReadingTime - minReadingTime) + minReadingTime);
            int randomWaitingTime = (int) (Math.random() * maxReadingTime);
            tryCatchThreadSleep(randomWaitingTime);
            resource.requestRead(this);
            tryCatchThreadSleep(randomReadingTime);
            resource.finishRead(this);


        }


    }


}
