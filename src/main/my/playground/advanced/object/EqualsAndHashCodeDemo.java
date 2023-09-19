package my.playground.advanced.object;

import java.util.Optional;

/**
 * <pre>
 * 1. If you ever are going to write you own `equals()`, think twice if you really need it;
 * 2. Rules to remember: whenever you override `equals()`, always override `hashcode()` as well.
 * 3. If for any two objects, the `equals()` returns true, then the `hashCode()` of the two objects
 * should return the same integer.
 * </pre>
 */
public class EqualsAndHashCodeDemo {

  public static void main(String[] args) {
    Person p1 = new Person("Danny", "Johua", "dj@test.com");
    Person p2 = new Person("Kate", "Green", "kg@test.com");

    assert !p1.equals(p2);

    // for non-primitive types, == operator returns true only if both references point to the same object, and false otherwise.
    String city = "Canberra";
    System.out.println("using ==: " + (city == "CanberraA")); //  false
    System.out.println("using ==: " + (city == city));    // true
    System.out.println("using equals: " + city.equals("Canberra")); // true
  }

}

/**
 * Actually it can be a record introduced in Java 14. <br>
 * {@link my.playground.afterjava8.record.RecordDemo}
 */
class Person {

  private final String firstName;
  private final String lastName;
  private final String email;

  public Person(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  /**
   * And always make sure that the same fields are used within implementation of `equals()` and
   * `hashcode()`.
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Optional.ofNullable(firstName).map(String::hashCode).orElse(0);
    result = prime * result + Optional.ofNullable(lastName).map(String::hashCode).orElse(0);
    result = prime * result + Optional.ofNullable(email).map(String::hashCode).orElse(0);
    return result;
  }

  /**
   * <pre>
   * By default, the two object references are equal only if they are referring to the same memory.
   * But you can override `equals()` of object, and the rules are:
   * 1. Reflexive: x.equals(x) == true
   * 2. Symmetric: if x.equals(y) == true, then y.equals(x) == true
   * 3. Transitive: if x.equals(y) == true and y.equals(z) == true, then x.equals(z) == true
   * 4. Consistent: multiple invocations of `equals()` must result into the same value, unless any
   * of the properties used for
   * equality comparison are modified.
   * 5. Equals to null: x.equals(null) must always be false
   * </pre>
   */
  @Override
  public boolean equals(Object obj) {
    // step 1: check if `obj` is null
    if (obj == null) {
      return false;
    }

    // step 2: check if `obj` is pointing to this instance
    if (obj == this) {
      return true;
    }

    // step 3: check if `obj` is the same class. (NOTE: don't use `instanceof` here because it may cause issue within class hierarchies.
    if (obj.getClass() != getClass()) {
      return false;
    }

    // step 4: check equality for each field
    final Person other = (Person) obj;
    if (firstName == null) {
      if (other.firstName != null) {
        return false;
      }
    } else {
      if (!firstName.equals(other.firstName)) {
        return false;
      }
    }

    if (lastName == null) {
      if (other.lastName != null) {
        return false;
      }
    } else {
      if (!lastName.equals(other.lastName)) {
        return false;
      }
    }

    if (email == null) {
      return other.email == null;
    } else {
      return email.equals(other.email);
    }
  }
}
