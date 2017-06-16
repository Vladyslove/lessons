package strategy;

public abstract class Duck {
  private QuackBehavior quackBehavior;
  private FlyBehavior flyBehavior;

  public Duck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
      this.quackBehavior = quackBehavior;
      this.flyBehavior = flyBehavior;
  }

  public void swim() {
    System.out.println("I'm swimmminng. Tha's awesome.");
  }

  abstract  public void display();

  /*final*/ public void fly() {
    flyBehavior.fly();
  }

  /*final*/ public void quack() {
    quackBehavior.quack();
  }

}
