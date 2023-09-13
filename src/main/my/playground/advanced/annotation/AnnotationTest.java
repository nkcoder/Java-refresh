package my.playground.advanced.annotation;

import java.lang.reflect.Method;

public class AnnotationTest {
  @MyCustomAnnotation(value = 100)
  public void sayHello() {
    System.out.println("Hello");
  }

  public static void main(String[] args) throws Exception {
    AnnotationTest annotationTest = new AnnotationTest();
    Method sayHello = annotationTest.getClass().getMethod("sayHello");
    MyCustomAnnotation annotation = sayHello.getAnnotation(MyCustomAnnotation.class);
    System.out.println("annotation value is " + annotation.value());
  }
}
