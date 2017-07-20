import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class JCFTest {
  @Ignore
  @Test
  public void name() throws Exception {
    List<Integer> list = Arrays.asList(10, 20, 30);
    list.forEach(System.out::println);
    list.clear();
    list.forEach(System.out::println);

  }
}
