package my.playground.advanced.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 1. use @interface for the definition
 * 2. @Retention: RUNTIME (Annotations are to be recorded in the class file by the compiler and retained by the VM at run time, so they may be read reflectively.)
 * 3. @Target: TYPE(class/interface/record), METHOD, FIELD, ...
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MarkerAnnotation {
}
