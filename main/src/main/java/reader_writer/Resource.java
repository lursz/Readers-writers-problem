package reader_writer;

import reader_writer.people.Human;


import java.util.concurrent.Semaphore;

public class Resource {
    private int maxAllowedReaders = 5;

    /* ---------------- Semaphores ---------------- */
    private Semaphore all_semaphore = new Semaphore(1);
    private Semaphore library_semaphore = new Semaphore(maxAllowedReaders);
    private Semaphore write_read_semaphore = new Semaphore(1);
    private Semaphore read_semaphore = new Semaphore(1);


    /* --------------- Conditions ----------------- */
    private int readCount = 0;

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    //acquire = wait
    //release = signal



    /* --------------------------------- READERS -------------------------------- */
    public void requestRead(Human human) {
        all_semaphore.acquireUninterruptibly();
        read_semaphore.acquireUninterruptibly();
        readCount++;
        if (readCount == 1) {
            write_read_semaphore.acquireUninterruptibly();
        }
        //let next person in
        all_semaphore.release();
        read_semaphore.release();
        //check if there is room in library
        library_semaphore.acquireUninterruptibly();

        System.out.println("Reader " + human.getId() + " is reading");
    }

    public void finishRead(Human human) {
        library_semaphore.release();
        System.out.println("Reader " + human.getId() + " finished reading");
        //reader stopped reading but waits for everyone to leave with them
        read_semaphore.acquireUninterruptibly();
        //all leave, so decrement readCount
        readCount--;
        //if you were the last one to leave, let the writer in
        if (readCount == 0) {
            write_read_semaphore.release();
        }
        //always let next reader in
        read_semaphore.release();


    }



    /* --------------------------------- WRITERS -------------------------------- */
    public void requestWrite(Human human) {
        all_semaphore.acquireUninterruptibly();
        write_read_semaphore.acquireUninterruptibly();
        System.out.println("Writer " + human.getId() + " is writing");

    }

    public void finishWrite(Human human) {
        all_semaphore.release();
        write_read_semaphore.release();
        System.out.println("Writer " + human.getId() + "finished writing");
    }
}
