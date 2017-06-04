import org.junit.Test;
import static org.junit.Assert.*;

import one.Shape;
import one.ShapeType;


public class ShapeOneTest {

  @Test
  public void testSquare() {
    Shape shape = new Shape(10, 0, 0);
    double area = shape.calculateArea(ShapeType.SQUARE);

    assertEquals(10 * 10, area, 0.1);

  }

  @Test
  public void testRectangle() {
    Shape shape = new Shape(10, 20, 0);
    double area = shape.calculateArea(ShapeType.RECTANGLE);

    assertEquals(10 * 20, area, 0.1);

  }

  @Test
  public void testCircle() {
    Shape shape = new Shape(0, 0, 10);

    double area = shape.calculateArea(ShapeType.CIRCLE);

    // assertEquals(10 * 10 * Math.PI, area, 0.1);

  }
}
