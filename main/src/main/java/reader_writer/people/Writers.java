package reader_writer.people;
import reader_writer.Resource;

/**
 * Class that represents a writer.
 * Writer can write to the resource.
 */
public class Writers extends Human {
    /* -------------------------------- Atributes ------------------------------- */

    private int maxWritingTime = 1000;

    public Writers(int id, Resource resource) {
        this.identifier = id;
        this.resource = resource;
    }
    /* --------------------------------- Methods -------------------------------- */
    /**
     * Overridden run method, that will be executed when the thread is started.
     * It will request to write the resource, proceed to write it and then finish writing it.
     */
    @Override
    public synchronized void run() {
        while (true) {
            int randomWritingTime = (int) (Math.random() * maxWritingTime);
            int randomWaitingTime = (int) (Math.random() * maxWritingTime);
            tryCatchThreadSleep(randomWaitingTime);
            resource.requestWrite(this);
            tryCatchThreadSleep(randomWritingTime);
            resource.finishWrite(this);
        }
    }
}
