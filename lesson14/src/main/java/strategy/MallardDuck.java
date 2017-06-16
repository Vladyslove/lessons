package strategy;

public class MallardDuck extends Duck {
  public MallardDuck() {
    super(new Quack(), new FlyWithWings());
  }

  public void display () {
    System.out.println("Google to know how I look like");
  }

}
