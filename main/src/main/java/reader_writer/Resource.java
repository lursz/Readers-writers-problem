package reader_writer;

import reader_writer.people.Human;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Resource {
    /* ----------------- Queue -------------------- */
    private Queue<Human> queue = new LinkedList<>();
    /* ---------------- Semaphores ---------------- */
    private Semaphore mutex = new Semaphore(1);
    private Semaphore wrt = new Semaphore(1);
    private int readCount = 0;
    /* --------------- Conditions ----------------- */
    private int maxReadersAtTheSameTime = 5;

//acquire = wait
//release = signal

/* --------------------------------- READERS -------------------------------- */
  public void requestRead(Human human) {
    try {
      mutex.acquire();
      readCount++;
      if (readCount == 1) {
        wrt.acquire();
      }
      mutex.release();
      queue.add(human);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

    public void finishRead(Human human) {
        try {
        mutex.acquire();
        readCount--;
        if (readCount == 0) {
            wrt.release();
        }
        mutex.release();
        queue.remove(human);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
    }
/* --------------------------------- WRITERS -------------------------------- */
    public void requestWrite(Human human) {
        try {
        wrt.acquire();
        queue.add(human);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
    }

    public void finishWrite(Human human) {
        wrt.release();
        queue.remove(human);
    }

}
