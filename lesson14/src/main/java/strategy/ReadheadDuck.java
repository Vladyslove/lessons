package strategy;

public class ReadheadDuck extends Duck{
  public ReadheadDuck() {
    super(new Quack(), new FlyWithWings());
  }
  public void display () {
  System.out.println("Hey. I'm looking like a God");
  }
}
