package three;

public class Square implements Shape{
  public double width;

  public Square (double width) {
      this.width = width;
  }

  public double getWidth() {
    return width;
  }
  public double calculateArea() {
    return width * width;
  }

}
