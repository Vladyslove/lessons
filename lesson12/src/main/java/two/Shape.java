package two;

public class Shape {
  public double calculateArea(Object shape) {
    double area = 0.0;
    if (shape instanceof Square) {
      Square s = (Square)shape;
      area = s.getWidth() * s.getWidth();
    } else if (shape instanceof Rectangle) {
      Rectangle r = (Rectangle)shape;
      area = r.getWidth() * r.getHeight();
    } else if (shape instanceof Circle) {
      Circle c = (Circle)shape;
      area = Math.PI * c.getRadius() * c.getRadius();
    }
    return area;
  }
}
