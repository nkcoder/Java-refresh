package main.localtypereference;

import java.util.Arrays;

public class LocalTypeReference {
    public static void main(String[] args) {
        var list = Arrays.asList("A", "B", "C");   // infers ArrayList<String>
        var stream = list.stream();     // infers Stream<String>
        System.out.println(stream.count());

        for (var i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
