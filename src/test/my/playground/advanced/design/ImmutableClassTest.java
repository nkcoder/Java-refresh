package my.playground.advanced.design;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import my.playground.advanced.object.ImmutableClass;
import org.junit.jupiter.api.Test;

public class ImmutableClassTest {

  @Test
  public void shouldReturnImmutableFields() {
    String[] names = {"one", "two", "three"};
    List<String> hobbies = List.of("Basketball", "Football");
    ImmutableClass immutableClass = new ImmutableClass(
        100L,
        names,
        hobbies
    );

    assertThrows(UnsupportedOperationException.class,
        () -> immutableClass.getHobbies().add("Baseball"));

    // Arrays.asList: doesn't support operations that will change the size of the list
    assertThrows(UnsupportedOperationException.class,
        () -> Arrays.asList(immutableClass.getNames()).add("four"));
  }

}
