package template;

public class App extends AbstractApp {
  int i = 10;
  protected void inittt() {
    // super.inittt();
    System.out.println("Foo:: inittt");
    System.out.println("i = " + i);
  }

  protected void invoke() {
    System.out.println("invoking");
    System.out.println("i = " + i);
  }
  protected void configure() {
    System.out.println("configuring");

  }
  protected void destroy() {
    System.out.println("destroying");
  }
}
