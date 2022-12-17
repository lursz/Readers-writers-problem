package reader_writer.people;

import reader_writer.Main;
import reader_writer.Resource;

public class Writers extends Human {
    /* -------------------------------- Atributes ------------------------------- */

    private int id;
    private int maxWritingTime = 1000;

    public Writers(int id, Resource resource) {
        this.id = id;
        this.resource = resource;
    }
    /* --------------------------------- Methods -------------------------------- */

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
