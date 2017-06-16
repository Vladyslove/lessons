package strategy;

public class RubberDuck extends Duck {
  QuackBehavior quackBehavior = new Squeak();

  public RubberDuck() {
    super(new Squeak(), new FlyWhenKicked());
  }
  public void display() {
    System.out.println("I'm made of a piece of rubber");
  }

}
