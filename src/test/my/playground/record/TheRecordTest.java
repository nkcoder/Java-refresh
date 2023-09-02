package my.playground.record;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TheRecordTest {

    @Test
    public void pointIsARecord() {
        Point p = new Point(2, 5);
        assertEquals(p.x(), 2);
        assertEquals(p.y(), 5);
        assertEquals(p.square(), 10);
    }

    @Test
    public void rangeIsAlsoARecord() {
        Range r1 = new Range(1, 5);
        assertEquals(r1.lo(), 1);
        assertEquals(r1.hi(), 5);

        assertThrows(IllegalArgumentException.class, () -> new Range(5, 1));
    }

}
