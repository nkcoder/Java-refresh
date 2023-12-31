package my.playground.afterjava8.newswitch;

import java.util.Random;

public class NewSwitch {
    public static void main(String[] args) {
        switchStatement(1);
        switchStatement(2);
        switchStatement(10);

        switchExpression(1);
        switchExpression(5);

        switchExpWithYield(1);
        switchExpWithYield(4);
        switchExpWithYield(100);
    }

    private static void switchStatement(int n) {
        switch (n) {
            case 1 -> System.out.println("one");
            case 2 -> System.out.println("two");
            default -> System.out.println("many");
        }
    }

    /**
     * Capture the return value of `switch` statement
     */
    private static void switchExpression(int n) {
        String value = switch (n) {
            case 1 -> "one";
            case 2 -> "two";
            default -> "many";
        };
        System.out.println(value);
    }

    /**
     * Return value with `yield`
     */
    private static void switchExpWithYield(int n) {
        int j = switch (n) {
            case 0, 1 -> 0;
            case 2, 3, 4 -> 1;
            default -> {
              int x = new Random().nextInt();     // just demo
              yield x;
            }
        };
        System.out.println(j);
    }
}
