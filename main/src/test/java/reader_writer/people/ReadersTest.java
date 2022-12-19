package reader_writer.people;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadersTest {
    @Test
    void testGetIdentifier() {
        Readers reader = new Readers(0, null);
        assertEquals(0, reader.getIdentifier());
    }
}