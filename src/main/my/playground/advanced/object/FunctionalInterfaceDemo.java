package my.playground.advanced.object;

/**
 * Functional interface: is the interface with only one abstract method declared in it.
 *
 * <p>
 *
 * We can convert lambda functions into the functional interface implementation.
 */
public class FunctionalInterfaceDemo {

  public static void main(String[] args) {
    FunctionalInterfaceDemo functionalInterfaceDemo = new FunctionalInterfaceDemo();
    String message = functionalInterfaceDemo.getWelcomeMessage(name -> "Hello " + name,
        "President");
    System.out.println(message);
  }

  public String getWelcomeMessage(Welcome welcome, String who) {
    return welcome.message(who);
  }

  /**
   * The annotation is a hint to the compiler to verify that the interface contains only one
   * abstract method so that any changes introduced into the interface will not break this assumption.
   */
  @FunctionalInterface
  interface Welcome {

    String message(String name);
  }
}
