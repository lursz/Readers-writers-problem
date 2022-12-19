package reader_writer;
import reader_writer.people.Human;
import java.util.concurrent.Semaphore;

/**
 * Class that represents the resource. In this case library.
 * It contains 4 semaphores, one for each type of action.
 */
public class Resource {
    private int maxAllowedReaders = 5;

    /* ---------------- Semaphores ---------------- */
    private Semaphore all_semaphore = new Semaphore(1, true);
    private Semaphore library_semaphore = new Semaphore(maxAllowedReaders, true);
    private Semaphore write_read_semaphore = new Semaphore(1, true);
    private Semaphore read_semaphore = new Semaphore(1, true);


    /* --------------- Conditions ----------------- */
    private int readCount = 0;

    /* --------------------------------- READERS -------------------------------- */

    /**
     * Request to read the resource
     * @param human
     */
    public void requestRead(Human human) {
        System.out.println("Reader " + human.getIdentifier() + " is requesting to read.");

        all_semaphore.acquireUninterruptibly();
        read_semaphore.acquireUninterruptibly();
        readCount++;
        //Block the writer from entering the library if there is a reader inside
        if (readCount == 1) {
            write_read_semaphore.acquireUninterruptibly();
        }
        //let the next reader in
        all_semaphore.release();
        read_semaphore.release();
        //if there is room in library, let the reader in
        library_semaphore.acquireUninterruptibly();

        System.out.println("Reader " + human.getIdentifier() + " is reading");

    }

    /**
     * Finish reading, release the resource
     * @param human
     */
    public void finishRead(Human human) {
        library_semaphore.release();
        System.out.println("Reader " + human.getIdentifier() + " finished reading");
        //reader stopped reading, he exits through the read_semaphore for safety
        read_semaphore.acquireUninterruptibly();
        //reader leaves so decrement the count
        readCount--;
        System.out.println("    [Readers currently in library: " + readCount+"]");
        //if you were the last one to leave, allow writers to enter
        if (readCount == 0) {
            write_read_semaphore.release();
        }
        //release the read_semaphore for next reader
        read_semaphore.release();

    }



    /* --------------------------------- WRITERS -------------------------------- */

    /**
     * Request to write the resource
     * @param human
     */
    public void requestWrite(Human human) {
        System.out.println("Writer " + human.getIdentifier() + " is requesting to write.");
        all_semaphore.acquireUninterruptibly();
        write_read_semaphore.acquireUninterruptibly();
        System.out.println("Writer " + human.getIdentifier() + " is writing");
        System.out.println("    [Writers currently in library: 1]");

    }

    /**
     * Finish writing, release the resource
     * @param human
     */
    public void finishWrite(Human human) {
        all_semaphore.release();
        write_read_semaphore.release();
        System.out.println("Writer " + human.getIdentifier() + " finished writing");
    }
}
