package my.playground.advanced.design;

/**
 * 1. Every declaration in interface are `public`, which is enforced by the compiler.
 *
 */
public interface InterfaceWithDefinitions {

  // implicitly declared as: public static final
  String CONSTANT = "Welcome";

  // the nested class, enums and interfaces are implicitly declared as: public and static
  enum InnerEnum {
    E1, E2
  }

  class InnerClass {

  }

  interface InnerInterface {

  }

  // implicitly declared as: public abstract
  void performAction();

}
