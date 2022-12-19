package reader_writer.people;
import reader_writer.Resource;

/**
 * An abstract class that will be derived to represent a reader or a writer.
 */
public abstract class Human extends Thread {
    /* -------------------------------- Atributes ------------------------------- */
    protected int identifier;
    public int getIdentifier() {
        return identifier;
    }

    protected Resource resource;

    /* --------------------------------- Methods -------------------------------- */

    /**
     * An abstract method which will be implemented by the subclasses.
     */
    @Override
    public synchronized void run() {}

    /**
     * Method that unclutters the code, tries to sleep the thread and catches the exception in case of failure.
     * @param value
     */
    public void tryCatchThreadSleep(int value) {
        try {
            Thread.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
