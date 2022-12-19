package reader_writer;
import reader_writer.people.*;

/**
 * Main class, loads the Humans and the Resource and starts the threads.
 */
public class Main {
    public static Resource resource = new Resource();

    /**
     * Function parsing string to integer
     * @param s
     * @return
     */
    public static int integerParser(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args ) {
        System.out.println( "________ Readers - Writers Problem ________" );

          int nReaders = integerParser(args[0]);
          int nWriters = integerParser(args[1]);

        for (int i = 0; i < nReaders; i++) {
            Readers reader = new Readers(i, resource);
            reader.start();
        }
        for (int i = 0; i < nWriters; i++) {
            Writers writer = new Writers(i, resource);
            writer.start();
        }

    }

}
