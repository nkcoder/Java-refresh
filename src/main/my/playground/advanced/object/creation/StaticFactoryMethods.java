package my.playground.advanced.object.creation;

import static my.playground.advanced.object.creation.StaticFactoryMethods.City.Brisbane;
import static my.playground.advanced.object.creation.StaticFactoryMethods.City.Melbourne;
import static my.playground.advanced.object.creation.StaticFactoryMethods.City.Sydney;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.StackWalker.StackFrame;
import java.lang.reflect.Array;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Effective Java - 01: Consider static factory methods instead of constructors.
 *
 * <pre>
 *   Advantages:
 *   1. They have names.
 *   2. They're not required to create new objects on every invocation: singleton; {@link Boolean#valueOf(String)}
 *   3. They can return an object of any subtype of the return type. {@link Collections#unmodifiableSet(Set)}
 *   4. The class of the returned object can vary from call to call as a function of the input parameters. {@link EnumSet#of(Enum, Enum[])} )}
 *   5. The class of the returned object need not exist when the class containing the method is written.
 * </pre>
 *
 * <pre>
 *   Disadvantages:
 *   1. Classes without public and protected constructors cannot be subclassed.
 *   2. Hard for programmers to find.
 * </pre>
 *
 *
 * {@link Boolean#valueOf(String)}
 */
public class StaticFactoryMethods {

  public static void main(String[] args) throws IOException {
    // from(), now(), getDateInstance()
    Date date = Date.from(Instant.now());
    DateFormat dateFormat = DateFormat.getDateInstance();
    String dateFormatted = dateFormat.format(date);
    assert dateFormatted != null;

    // of(): aggregation
    EnumSet<City> bigCities = EnumSet.of(Sydney, Melbourne, Brisbane);
    assert bigCities.size() == 3;

    // valueOf()
    Boolean b = Boolean.valueOf("false");
    assert !b;
    Integer i = Integer.valueOf("100");
    assert i == 100;

    // getInstance()
    StackWalker stackWalker = StackWalker.getInstance();
    List<StackFrame> stackFrames = stackWalker.walk(
        s -> s.dropWhile(f -> f.getClassName().startsWith("com.foo")).limit(10).collect(
            Collectors.toList()));
    assert stackFrames.isEmpty();

    // newInstance
    Object a = Array.newInstance(Integer.class, 10);
    Integer[] ia = (Integer[]) a;
    ia[0] = 1;
    ia[1] = 2;

    // `getType()`, `newType()`, `type()`: almost the same.
    Path path = Paths.get(Paths.get("").toAbsolutePath() + "/README.md");
    FileStore fileStore = Files.getFileStore(path);
    assert fileStore.name() != null;

    // `newType()`
    try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
      String line = bufferedReader.readLine();
      assert line != null;
    }

    // `type()`
    Enumeration<Integer> enumeration = Collections.enumeration(List.of(1, 2, 3, 4));
    assert enumeration.hasMoreElements();
  }

  enum City {
    Sydney, Melbourne, Brisbane, Canberra, Perth, Adelaide, Darwin
  }


}
