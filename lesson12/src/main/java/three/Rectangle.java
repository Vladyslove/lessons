package three;

public class Rectangle implements Shape {
  public double width;
  public double height;

  public Rectangle (double width, double height) {
      this.width = width;
      this.height = height;
  }

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }

  public double calculateArea() {
    return width * height;
  }

}
