package my.playground.advanced.generic;

public class GenericTest {
  public static void main(String[] args) {
    GenericMap<String, Integer> map = new GenericMap<>("hello", 100);
    System.out.printf("key = %s, value = %d", map.getKey(), map.getValue());
  }
}
