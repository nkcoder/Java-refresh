package my.playground.effectivejava.builder_pattern;

/**
 * Effective Java 02 - consider a builder when faced with many constructor parameters.
 *
 * <br/>
 *
 * <pre>
 * Limitation of static factories and constructors:
 * - many constructors (more than 4) and some of them are optional
 * - hard to write the client code, and hard to read (the order of the parameters is confusing and causes runtime bugs)
 *
 * Limitation of Java Bean (use setter)
 * - easy to write and read
 * - may be in inconsistent state through the construction
 * - cannot make the class immutable, so it's not thread safe
 *
 * Builder pattern:
 * - easy to read and write, but more verbose
 * - simulate the named optional parameter in Scala and Python
 * - immutable and thread safe
 * - good choice for: more than 4 constructor parameters, especially some parameters are optional or of identical type
 * </pre>
 */
public class User {

  private final String firstName;
  private final String lastName;
  private final int age;
  private final String phone;
  private final String address;

  private User(Builder builder) {
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.age = builder.age;
    this.phone = builder.phone;
    this.address = builder.address;
  }

  public static class Builder {

    // required parameters
    private final String firstName;
    private final String lastName;

    // optional parameters
    private int age = 0;
    private String phone = "";
    private String address = "";

    public Builder(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public Builder age(int age) {
      this.age = age;
      return this;
    }

    public Builder phone(String phone) {
      this.phone = phone;
      return this;
    }

    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public User build() {
      return new User(this);
    }
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  public String getPhone() {
    return phone;
  }

  public String getAddress() {
    return address;
  }
}
