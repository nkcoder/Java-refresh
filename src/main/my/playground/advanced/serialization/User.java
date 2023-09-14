package my.playground.advanced.serialization;

import java.io.Serial;
import java.io.Serializable;

/**
 * Serializable: enable the serializability of a class, otherwise `NotSerializableException` will be thrown.
 */
public class User implements Serializable {
  // serialVersionUID: is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization.
  @Serial
  private static final long serialVersionUID = 1L;

  public User(String name, int age, String gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  private String name;
  private int age;
  // the field is marked as `transient`, so it won't be serialized.
  private transient String gender;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}
