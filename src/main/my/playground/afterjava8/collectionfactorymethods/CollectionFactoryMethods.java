package my.playground.afterjava8.collectionfactorymethods;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

public class CollectionFactoryMethods {
    public static void main(String[] args) {
        var set1 = Set.of(1, 2, 3, 3, 5, 2, 10);
        var list1 = List.of("A", "Grade", "Morning", "A");
        System.out.println(set1);
        System.out.println(list1);

        var map1 = Map.of("Canberra", "ACT", "Melbourne", "Vic", "Sydney", "NSW");
        var map2 = Map.ofEntries(entry("A", 1), entry("B", 2), entry("C", 3));
        System.out.println(map1);
        System.out.println(map2);
    }
}
