import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import two.Shape;
import two.Square;
import two.Rectangle;
import two.Circle;

public class ShapeTwoTest {
  private Shape shape;

  @Before
  public void setUp() {
      shape = new Shape();
  }


  @Test
  public void deltaDemonstration() {
      double d = 0.0;
      for (int i = 0; i < 10; i++) {
        d +=0.1;
      }
      System.out.println(d);
      assertEquals(1.0, d, 0.01);
  }

  @Test
  public void testSquare() {
    Square square = new Square(10);

    double result = shape.calculateArea(square);

    assertEquals(10 * 10, result, 0.1);

  }

  @Test
  public void testRectangle() {
    Rectangle rect = new Rectangle(10, 20);

    double result = shape.calculateArea(rect);

    assertEquals(10 * 20, result, 0.1);

  }

  @Test
  public void testCircle() {
      Circle circle = new Circle(10.0);

      double result = shape.calculateArea(circle);

      assertEquals(Math.PI * 10.0 * 10.0, result, 0.01);
  }
}
