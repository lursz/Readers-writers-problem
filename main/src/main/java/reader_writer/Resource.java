package reader_writer;

import reader_writer.people.Human;

import java.util.LinkedList;
import java.util.Queue;

import java.util.concurrent.Semaphore;

public class Resource {
    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore db = new Semaphore(1);
    private Queue<Human> queue = new LinkedList<>();
    private int readCount = 0;

    public void startRead(Human human) throws InterruptedException {
        mutex.acquire();
        queue.add(human);
        if (queue.peek() == human) {
            db.acquire();
        }
        mutex.release();
        readCount++;
    }

    public void endRead() throws InterruptedException {
        mutex.acquire();
        readCount--;
        if (readCount == 0) {
            db.release();
        }
        mutex.release();
    }

    public void startWrite(Human human) throws InterruptedException {
        mutex.acquire();
        queue.add(human);
        if (queue.peek() == human) {
            db.acquire();
        }
        mutex.release();
    }

    public void endWrite() throws InterruptedException {
        mutex.acquire();
        db.release();
        mutex.release();
    }
}
