package one;

public class Shape {
  public final static int SQUARE = 1;
  public final static int RECTANGLE = 2;
  public final static int CIRCLE = 3;

  private double width;
  private double height;
  private double radius;

  public Shape (double width) {
    this(width, 0, 0);
  }

  public Shape (double width, double height) {
    this(width, height, 0);
  }

  public Shape (double width, double height, double radius) {
    this.width = width;
    this.height = height;
    this.radius = radius;

  }
  public double calculateArea(ShapeType shapeType) {
    System.out.println("Going to calculate the area for " +shapeType.getName());
    double area = 0.0;
    switch (shapeType) {
      case SQUARE: area = width * width; break;
      case RECTANGLE: area = width * height;break;
      case CIRCLE: area = Math.PI * radius * radius; break;

      default: area = - 1.0;

    }
    // System.out.println(shapeType.getName());
    return area;
  }
}

//   public double calculateArea() {
//     if (height == 0) {
//       if (radius == 0) {
//         return  width * width;
//       }
//         return Math.PI * radius * radius;
//     }
//       return width * height;
//   }
//
// }
