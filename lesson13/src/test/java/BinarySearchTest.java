import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class BinarySearchTest {
  @Test
  public void testStudentsSearch() {
    Student[] students = {
      new Student ("John Doe", 20),
      new Student ("Jane Roe", 25),
      new Student ("Bill Gates", 125)
    };

    int index = Arrays.binarySearch(students, 125);

    assertEquals(2, index);
  }
}
