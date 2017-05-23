import org.junit.Test;
// import org.junit.Assert;
// import org.junit.Assert.assertTrue;
// import org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import inheritance.Developer;
public class HelloTest {
  @Test
  public void testNothing() {
    System.out.println("testing nothing");

    // Assert.assertTrue(true);
  assertTrue(true);
  }

  @Test
  public void testDevToString() {
  Developer dev = new Developer();
    assertEquals(dev.toString(), "Hi I'm a Developer");
  }
}
