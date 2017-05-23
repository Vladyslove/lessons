import inheritance.Developer;
import inheritance.QA;
import inheritance.*;


public class Main {
  public static void main(String[] args) {
    System.out.println("\nhello");
      Developer dev = new Developer();
      QA qa = new QA();

      System.out.println(dev);
      System.out.println(qa);
      // System.out.println(qa.eqauls(qa));
  }
}
