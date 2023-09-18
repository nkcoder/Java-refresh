package my.playground.advanced.annotation;

import java.lang.reflect.Method;

public class AnnotationDemo {
  @MyCustomAnnotation(value = 100)
  public void sayHello() {
    System.out.println("Hello");
  }

  public static void main(String[] args) throws Exception {
    AnnotationDemo annotationTest = new AnnotationDemo();
    Method sayHello = annotationTest.getClass().getMethod("sayHello");
    MyCustomAnnotation annotation = sayHello.getAnnotation(MyCustomAnnotation.class);
    System.out.println("annotation value is " + annotation.value());
  }
}
