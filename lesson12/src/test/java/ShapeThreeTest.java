import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import three.Shape;
import three.Square;
import three.Rectangle;
import three.Circle;

public class ShapeThreeTest {

  @Test
  public void testSquare() {
    Square square = new Square(10);

    double result = square.calculateArea();

    assertEquals(10 * 10, result, 0.1);

  }


  @Test
  public void testRectangle() {
    Rectangle rect = new Rectangle(10, 20);

    double result = rect.calculateArea();

    assertEquals(10 * 20, result, 0.1);

  }

  @Test
  public void testCircle() {
      Circle circle = new Circle(10.0);

      double result = circle.calculateArea();

      assertEquals(Math.PI * 10.0 * 10.0, result, 0.01);
  }
}
