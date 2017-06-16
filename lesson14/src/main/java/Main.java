import strategy.*;

public class Main {
  public static void main(String[]  args) {
    System.out.println("Lesson 14");


    Duck readheadDuck = new ReadheadDuck();
    Duck mallardDuck = new MallardDuck();
    Duck rubberDuck = new RubberDuck();

    readheadDuck.display();
    readheadDuck.fly();
    readheadDuck.quack();

    mallardDuck.display();
    mallardDuck.fly();
    mallardDuck.quack();

    rubberDuck.display();
    rubberDuck.fly();
    rubberDuck.quack();


      // monitor.checkForOverHeating(); // principe tell don't ask (TDA)
  }
}

// class SysMonitor {
//   Alarm alarm;
//
//   void checkForOverHeating() {
//     if (this.monitor > 100) {
//       alarm.fire();
//     }
//   }
// }
