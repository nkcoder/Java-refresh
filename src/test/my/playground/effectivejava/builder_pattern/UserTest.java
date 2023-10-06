package my.playground.effectivejava.builder_pattern;

import static org.assertj.core.api.Assertions.assertThat;

import my.playground.effectivejava.builder_pattern.User.Builder;
import org.junit.jupiter.api.Test;

public class UserTest {

  @Test
  public void shouldCreateUser() {
    User user = new Builder("Kate", "Jay")
        .address("Street 1")
        .age(35)
        .phone("24789355")
        .build();

    assertThat(user).isNotNull();
    assertThat(user.getPhone()).isEqualTo("24789355");
  }

}
