package my.playground.newinstanceof;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaseInsensitiveStringTest {
    @Test
    public void equalComparison() {
        CaseInsensitiveString cis = new CaseInsensitiveString("New World");
        CaseInsensitiveString cis2 = new CaseInsensitiveString("New World");

        assertEquals(cis, cis2);
        assertTrue(cis.equals(cis2));
        assertTrue(cis2.equalsImproved(cis));
    }
}
