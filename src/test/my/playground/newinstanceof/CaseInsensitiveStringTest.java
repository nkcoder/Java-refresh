package my.playground.newinstanceof;

import my.playground.afterjava8.newinstanceof.CaseInsensitiveString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaseInsensitiveStringTest {
    @Test
    @DisplayName(value = "equals and equalsImproved both works")
    public void equalComparison() {
        CaseInsensitiveString cis = new CaseInsensitiveString("New World");
        CaseInsensitiveString cis2 = new CaseInsensitiveString("New World");

        assertEquals(cis, cis2);
        assertTrue(cis.equals(cis2));
        assertTrue(cis2.equalsImproved(cis));
    }
}
