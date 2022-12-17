package reader_writer.people;

public class Human extends Thread{
    protected int id;

    protected void threadSleep1000(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
