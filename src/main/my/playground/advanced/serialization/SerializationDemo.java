package my.playground.advanced.serialization;

import java.io.*;

public class SerializationDemo {
  public static void main(String[] args) {
    User user = new User("Daniel", 20, "Male");
    String userFile = "./user.txt";
    // serialization
    try {
      FileOutputStream fos = new FileOutputStream(userFile);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(user);

      System.out.println("User has been written to file");

      fos.close();
      oos.close();
    } catch (IOException exception) {
      System.out.println(exception.getMessage());
    }

    // deserialization
    try {
      FileInputStream fis = new FileInputStream(userFile);
      ObjectInputStream ois = new ObjectInputStream(fis);
      User userLoaded = (User) ois.readObject();

      System.out.printf("User has been loaded, name: %s, age: %d, gender: %s%n", userLoaded.getName(), userLoaded.getAge(), userLoaded.getGender());

      fis.close();
      ois.close();

    } catch (IOException | ClassNotFoundException exception) {
      System.out.println(exception.getMessage());
    }


  }
}
