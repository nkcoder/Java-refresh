package newinstanceof;

public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = s;
    }

    public final boolean equals(Object o) {
        return (o instanceof CaseInsensitiveString) &&
                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }

    public final boolean equalsImproved(Object o) {
        CaseInsensitiveString cis2 = new CaseInsensitiveString("hello");
        System.out.println(cis2.s);

        return (o instanceof CaseInsensitiveString cis) && cis.s.equalsIgnoreCase(s);
    }
}
