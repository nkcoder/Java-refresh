package main.newoptionalmethods;

import java.util.List;
import java.util.Optional;

public class NewOptionalMethods {
    public static void main(String[] args) {
        // ifPresentOrElse()
        Optional<String> nonEmpty = Optional.of("Hello World");
        nonEmpty.ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));

        // or()
        Optional<String> empty = Optional.empty();
        nonEmpty.or(() -> Optional.of("Default")).ifPresent(System.out::println);
        empty.or(() -> Optional.of("Default")).ifPresent(System.out::println);

        // stream()
        var fruits = List.of("Apple", "Orange", "Pear", "Banana");
        fruits.stream().map(NewOptionalMethods::transform)
                .flatMap(Optional::stream)
                .forEach(System.out::println);

        // isEmpty()
        System.out.println(nonEmpty.isEmpty());
        System.out.println(empty.isEmpty());

        // orElseThrow()
        nonEmpty.orElseThrow();
        empty.orElseThrow();

    }

    private static Optional<String> transform(String s) {
        return s != null && !s.isBlank() ? Optional.of(s.toUpperCase()) : Optional.empty();
    }
}
