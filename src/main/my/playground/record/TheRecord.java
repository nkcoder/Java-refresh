package my.playground.record;

public class TheRecord {
    public static void main(String[] args) {
        Point p = new Point(10, 20);
        System.out.println(p.square());

        Range range = new Range(10, 15);
        System.out.println(range);
    }
}

record Point(int x, int y) {
    public int square() {
        return x * y;
    }
}

record Range(int lo, int hi) {
    Range {
        if (lo > hi)  // referring here to the implicit constructor parameters
            throw new IllegalArgumentException(String.format("(%d, %d)", lo, hi));
    }
}
