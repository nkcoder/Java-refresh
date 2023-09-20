package my.playground.advanced.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Immutability is not a first citizen class in Java.
 * <p/>
 * Things can get really complicated if an immutable class has fields referencing another class
 * instances.
 */
public class ImmutableClass {

  /**
   * All fields should be final
   */
  private final Long id;
  private final String[] names;
  private final List<String> hobbies;

  /**
   * Make copies for the construction.
   */
  public ImmutableClass(Long id, String[] names, List<String> hobbies) {
    this.id = id;
    this.names = Arrays.copyOf(names, names.length);
    this.hobbies = new ArrayList<>(hobbies);
  }

  /**
   *  For array or collection fields, return copies so that they'll not be changed outside.
   */
  public Long getId() {
    return id;
  }

  public String[] getNames() {
    return Arrays.copyOf(this.names, this.names.length);
  }

  public List<String> getHobbies() {
    return Collections.unmodifiableList(hobbies);
  }
}
