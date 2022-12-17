package reader_writer;

import reader_writer.people.*;

public class Main {
    public static Resource resource = new Resource();

    public static void main(String[] args ) {
        System.out.println( "________ Readers - Writers Problem ________" );
        int nReaders = Integer.parseInt(args[0]);
        int nWriters = Integer.parseInt(args[1]);

        for(int i = 0; i < nReaders; i++){
            Readers reader = new Readers(i);
            reader.start();
        }
        for(int i = 0; i < nWriters; i++){
            Writers writer = new Writers(i);
            writer.start();
        }







    }
}
