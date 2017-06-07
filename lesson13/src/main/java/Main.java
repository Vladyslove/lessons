import template.App;
import template.AbstractApp;


public class Main {
  public static void main(String[]  args) {
      System.out.println(("Lesson 13"));

      printParams("one", "two", "three");
      printParams();
      printParams("one");

      // printParams2("one"); // won't compile

      App app = new App();
      app.run();
  }
  // Varargs allow to create method with different numbers of parameters
  static void printParams(String ... args) {
    for (int i = 0; i < args.length ; i++ ) {
      System.out.println(args[i]);

    }
  }

  static void printParams2(String [] args) {
    for (int i = 0; i < args.length ; i++ ) {
      System.out.println(args[i]);

    }
  }
}
