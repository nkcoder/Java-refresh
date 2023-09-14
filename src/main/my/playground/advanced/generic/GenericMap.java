package my.playground.advanced.generic;

public class GenericMap<K, V> {
  private final K key;
  private final V value;

  public GenericMap(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }
}
