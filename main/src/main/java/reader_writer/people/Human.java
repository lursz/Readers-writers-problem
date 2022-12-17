package reader_writer.people;

import reader_writer.Resource;

public class Human extends Thread {

    protected Resource resource;


    public void tryCatchThreadSleep(int value) {
        try {
            Thread.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
