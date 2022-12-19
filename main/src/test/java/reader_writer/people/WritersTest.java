package reader_writer.people;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WritersTest {

    @Test
    void testGetIdentifier() {
        Writers writer = new Writers(0, null);
        assertEquals(0, writer.getIdentifier());
    }

}