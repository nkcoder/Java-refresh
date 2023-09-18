package my.playground.advanced.dependencyinjection;

import java.text.DateFormat;
import java.util.Date;

/**
 * Dependency injection (also known as inversion of control): is considered a good practice for
 * class designers. If class A depends on class B and C, then dependencies B and C should be
 * provided (injected) to it by means of constructors (or setters, strategies etc.), but not created
 * by
 * class A itself.
 *
 * <br>
 *
 * It's easy to change the implementation of the dependencies, and write test cases for it.
 */
public class DependencyInjectionDemo {

  private final DateFormat dateFormat;

  /**
   * It's easy to change DateFormat and write tests for the DependencyInjectionTest.
   */
  public DependencyInjectionDemo(final DateFormat dateFormat) {
    this.dateFormat = dateFormat;
  }

  public String format(final Date date) {
    return dateFormat.format(date);
  }

}
