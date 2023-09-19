package my.playground.advanced.object;

import java.util.Objects;

public class HelperMethodsDemo {

  public static void main(String[] args) {
    PersonV2 p1 = new PersonV2("Kate", "Green", "kg@test.com");
    PersonV2 p2 = new PersonV2("Kate", "Green", "kg@test.com");
    assert p1.equals(p2);
    assert p1.hashCode() == p2.hashCode();

    PersonV3 p3 = new PersonV3("Kate", "Green", "kg@test.com");
    PersonV3 p4 = new PersonV3("Kate", "Green", "kg@test.com");
    assert p3.equals(p4);
    assert p3.hashCode() == p4.hashCode();
  }

}

/**
 * use helper methods `hash()` and `equals()` from object.
 */
class PersonV2 {

  private final String firstName;
  private final String lastName;
  private final String email;

  PersonV2(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  /**
   * use `Objects.equals()`
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonV2 personV2 = (PersonV2) o;
    return Objects.equals(firstName, personV2.firstName) && Objects.equals(
        lastName, personV2.lastName) && Objects.equals(email, personV2.email);
  }

  /**
   * Use `Objects.hash()`
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, email);
  }
}

/**
 * We can also use helper methods from Guava and Apache Commons Lang.
 */
class PersonV3 {

  private final String firstName;
  private final String lastName;
  private final String email;

  PersonV3(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonV3 personV3 = (PersonV3) o;
    return com.google.common.base.Objects.equal(firstName, personV3.firstName)
        && com.google.common.base.Objects.equal(lastName, personV3.lastName)
        && com.google.common.base.Objects.equal(email, personV3.email);
  }

  @Override
  public int hashCode() {
    return com.google.common.base.Objects.hashCode(firstName, lastName, email);
  }
}