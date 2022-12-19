package pl.edu.agh.kis.pz1;

import static junit.framework.TestCase.assertNotNull;
import org.junit.Test;
import reader_writer.Main;
import static org.junit.jupiter.api.Assertions.*;


public class MainTest {


    /**
     * Test for the construction of Main and the 
     * main method being called
     *
     */
    @Test
    public void shouldCreateMainObject(){
        Main main = new Main();
        assertNotNull("Main method called.", main);
    }

    @Test
    public void integerParserTest() {
        assertEquals(1, Main.integerParser("1"));
    }

    @Test
    public void integerParserTest2() {
        assertEquals(100, Main.integerParser("100"));
    }


}


