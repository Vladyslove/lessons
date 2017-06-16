import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class MainTest {
  @Test
  public void testNothing() {
    Bag <Integer> bag = new Bag<>();
    bag.add(10);

    Integer i = 10;
    Integer ii = new Integer (10);
    int iii = ii;

    Bag <String> bagOfStrings = new Bag <>();
    bagOfStrings.add("Hello");
    // int i = bag.get(0);
  }
}
