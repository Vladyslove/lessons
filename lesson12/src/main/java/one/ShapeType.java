package one;

public enum ShapeType {
  SQUARE("сквер"), RECTANGLE("рыктангэл"), CIRCLE("сёркл");

  private String name;
  ShapeType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
