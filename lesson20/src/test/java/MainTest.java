import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Iterator;

public class MainTest {
  @Test
  public void testSimpleAddition() {
    Stack<String> stack = new Stack<>();
    stack.push("10");

    assertThat(stack.pop(), is("10"));
  }

  @Test
  public void testMultipleAddition() {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < 5 ; i++ ) {
      stack.push(i + 1);

    }

    assertThat(stack.pop(), is(5));
    assertThat(stack.pop(), is(4));
    assertThat(stack.pop(), is(3));
    assertThat(stack.pop(), is(2));
    assertThat(stack.pop(), is(1));
  }
}
