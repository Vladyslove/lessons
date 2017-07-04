import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Iterator;

public class ExpressionTest {

  @Test
  public void test1() {
    Expression expr = new Expression();

    assertThat(expr.evaluate("1 + ((2 + 3) * (4 * 5)))"), is(101.0));
  }

  @Test
  public void test2() {
    Expression expr = new Expression();

    assertThat(expr.evaluate("(((4 / 2) * 2) + 2)"), is(6.0));
  }

  @Test
  public void test3() {
    Expression expr = new Expression();

    assertThat(expr.evaluate("(((4 * 2) + 2) - 2)"), is(8.0));
  }

  @Test
  public void test4() {
    Expression expr = new Expression();

    assertThat(expr.evaluate("(((3 / 2) + 2) - 2)"), is(1.5));
  }
}
