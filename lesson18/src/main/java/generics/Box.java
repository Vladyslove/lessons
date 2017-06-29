package generics;
import java.util.List;

public class Box<T> {
private  T value;

  public void set(T value) {
    this.value = value;
  }

  public T get(  ) {
    return value;
  }

  public static void main(String[] args) {
    System.out.println("Box:: main");

    Box<String> box = new Box<>();
    box.set("10");

    String value = box.get();

    Box box2 = new Box();
  }

}
