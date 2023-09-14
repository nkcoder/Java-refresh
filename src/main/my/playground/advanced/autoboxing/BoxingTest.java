package my.playground.advanced.autoboxing;

public class BoxingTest {
  public static void main(String[] args) {
    double d = 10.5;
    Double dd = d;
    // unnecessary boxing
    Double dd2 = Double.valueOf(d);
    System.out.printf("d = %f, dd = %f, dd2 = %f\n", d, dd, dd2);

    char c = 'A';
    Character cc = c;
    System.out.printf("c = %c, cc = %c\n", c, cc);

    Integer ii = 100;
    int i = ii;
    // unnecessary unboxing
    int i2 = ii.intValue();
    System.out.printf("i = %d, i2 = %d, ii = %d\n", i, i2, ii);

  }
}
