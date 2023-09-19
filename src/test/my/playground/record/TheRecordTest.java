package my.playground.record;

import my.playground.afterjava8.record.Point;
import my.playground.afterjava8.record.Range;
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
        assertEquals(1, r1.lo());
        assertEquals(5, r1.hi());

        assertThrows(IllegalArgumentException.class, () -> new Range(5, 1));
    }

}
